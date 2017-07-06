package com.adobe.prj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adobe.prj.entity.Response;
import com.adobe.prj.entity.Survey;
import com.adobe.prj.service.ResponseService;

@Controller
public class ResponseController {
	
	@Autowired
	ResponseService responseService;
	
	@RequestMapping("getSurvey.do")
	public String fetchSurvey(Model model){ //
		
		//User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		//System.out.println("Hello"+ user.getFirstName());
		model.addAttribute("survey",responseService.getSurvey());
		return "surveyList.jsp";
		
		
	}
	
	@RequestMapping("getClosedSurvey.do")
	public String fetchClosedSurvey(Model model){ //
		
		//User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		//System.out.println("Hello"+ user.getFirstName());
		model.addAttribute("survey",responseService.getClosedSurvey());
		return "SurveyList.jsp";
		
		
	}
	
	/*@RequestMapping("newResponse.do")
	public String getResponseForm(Model model) {
		model.addAttribute("response", new Response());
		return "responseForm.jsp";
	}*/
	
	@RequestMapping("addResponse.do")
	public String addResponse(@ModelAttribute("response") Response response, Model model){
	    responseService.addResponse(response);
	    
		model.addAttribute("msg","Response  "+ response.getResponseId() +" added successfully !");	
		return "indexRespondent.jsp";
		
	}
	
	
	@RequestMapping(value = "/getOneClosedSurvey/{id}", method = RequestMethod.GET)
    public String getSurveyById(@PathVariable Integer id, Model model) {
       
		model.addAttribute("survey",responseService.getSurveyById(id));
		int surveyId=(int)model.asMap().get("surveyId");
		model.addAttribute("question",responseService.getQuestion(surveyId));
		
		return "closedSurvey.jsp";
}
	
	@RequestMapping(value = "/getOneOpenSurvey/{id}", method = RequestMethod.GET)
    public String getOpenSurveyById(@PathVariable Integer id, Model model) {
       
		model.addAttribute("survey",responseService.getSurveyById(id));
		int surveyId=(int)model.asMap().get("surveyId");
		model.addAttribute("question",responseService.getQuestion(surveyId));
		
		model.addAttribute("response", new Response());
		
		//model.addAttribute(arg0, arg1)
		
		return "openSurvey.jsp";
}
	
	
	

}
