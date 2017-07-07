package com.adobe.prj.web;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.adobe.prj.dto.ResponseDto;
import com.adobe.prj.entity.Rental;
import com.adobe.prj.entity.Response;
import com.adobe.prj.entity.ResponseList;
import com.adobe.prj.entity.User;
import com.adobe.prj.service.ResponseService;
import com.adobe.prj.service.SurveyService;
import com.adobe.prj.service.UserService;

@Controller
@SessionAttributes("userName")
public class ResponseController {
	
	@Autowired
	ResponseService responseService;
	
	@Autowired
	SurveyService surveyService;
	
	@Autowired
	UserService userService;
	
	
	@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest request, Exception ex){
		return "error";
	}
	@ModelAttribute("responseList")
	public ResponseList populate(Authentication authentication)
	{
		org.springframework.security.core.userdetails.User a=(org.springframework.security.core.userdetails.User) authentication.getPrincipal();
		String username=a.getUsername();
		
		User user=surveyService.getUserByName(username);
		
		ResponseList responseList = new ResponseList();
	    List<ResponseDto> responses = new ArrayList<ResponseDto>();
	    for(int i=0; i<20; i++) {
	        responses.add(new ResponseDto());
	       responses.get(i).setUserId(user);
	    }
	    responseList.setResponseList(responses);
	    return responseList;
	}
	
	@RequestMapping("getSurvey.do")

	public String fetchSurvey(Model model,Authentication authentication){ //
		org.springframework.security.core.userdetails.User a=(org.springframework.security.core.userdetails.User) authentication.getPrincipal();
		
		model.addAttribute("survey",responseService.getSurvey(surveyService.getUserByName(a.getUsername()).getUserId()));

	   
		
		System.out.println(model.toString());
		model.addAttribute("msg", "checking ");
		

		return "surveyList";
		
		
	}
	
	
	
	@RequestMapping("getClosedSurvey.do")
	public String fetchClosedSurvey(Model model,Authentication authentication){

		
		org.springframework.security.core.userdetails.User a=(org.springframework.security.core.userdetails.User) authentication.getPrincipal();
		model.addAttribute("survey",responseService.getClosedSurvey(surveyService.getUserByName(a.getUsername()).getUserId()));
		return "closedSurveyList";

		
	}
	

	@RequestMapping(value="/*/addResponse.do",method = RequestMethod.POST)
	public String addResponse(@RequestParam("sid") int sid,@ModelAttribute("responseList") ResponseList responseList, Model model,Authentication authentication){
		org.springframework.security.core.userdetails.User a=(org.springframework.security.core.userdetails.User) authentication.getPrincipal();
		User user=surveyService.getUserByName(a.getUsername());
		for(ResponseDto response : responseList.getResponseList()) {
			System.out.println(response.getResponseText());
			//System.out.println(response.getQuestionId());
			if(response.getResponseText()!=null)
			responseService.addResponse(response);
			
		    }
		responseService.updateDistributionTable(sid,user.getUserId());   //Update distribution Table	
		return "indexRespondent";
		

	}
	
	
	@RequestMapping(value="/*/addResponse.do2",method = RequestMethod.POST)
	public String addResponse2(HttpServletRequest req){
		Enumeration<String> parameterNames = req.getParameterNames();
		
		 

		        while (parameterNames.hasMoreElements()) {
		
		 
		
		            String paramName = parameterNames.nextElement();
		
		            System.out.println(paramName);
		
		           
		
		 
		
		            String[] paramValues = req.getParameterValues(paramName);
		
		            for (int i = 0; i < paramValues.length; i++) {
		
		                String paramValue = paramValues[i];
		
		                System.out.println("t" + paramValue);
		
		                System.out.println("n");
		
		            }
		
		 
		
		        }
		
		 

		return "indexRespondent";
		
	}

	@RequestMapping(value = "/showSurvey/{id}", method = RequestMethod.GET)
    public String showSurveyDetails(@PathVariable Integer id, Model model) {
	
       
		model.addAttribute("survey",responseService.getSurveyById(id));
		

		model.addAttribute("question",responseService.getQuestion(id));
	
		
		return "showSurvey";
}

		
	
	@RequestMapping(value = "/showClosedSurvey/{id}", method = RequestMethod.GET)
    public String showClosedSurveyDetails(@PathVariable Integer id, Model model, HttpServletRequest req) {
       
		model.addAttribute("survey",responseService.getSurveyById(id));
		
		model.addAttribute("question",responseService.getQuestion(id));
		

		return "showClosedSurvey";
}
	
	@RequestMapping(value = "/showResponse/{id}", method = RequestMethod.GET)
	  public String showResponse(@PathVariable Integer id, Model model,Authentication authentication) {
		
		org.springframework.security.core.userdetails.User a=(org.springframework.security.core.userdetails.User) authentication.getPrincipal();
		User user=surveyService.getUserByName(a.getUsername());
		model.addAttribute("response", responseService.getResponse(id,user.getUserId()));
		model.addAttribute("surveyId", id);
		return "response";
		
	}
}
	
	

