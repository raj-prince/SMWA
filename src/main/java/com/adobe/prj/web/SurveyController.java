package com.adobe.prj.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.adobe.prj.entity.Distribution;
import com.adobe.prj.entity.Question;
import com.adobe.prj.entity.Survey;
import com.adobe.prj.entity.SurveyStatus;
import com.adobe.prj.service.SurveyService;

@Controller
public class SurveyController {
	@Autowired 
	private SurveyService surveyService;
	
	@RequestMapping("createSurvey.do")
	public String getSurveyForm(Model model) {
		
		model.addAttribute("survey", new Survey());
		
		return "surveyForm";
	}
	
	@RequestMapping("addSurvey.do")
	@Transactional
	public String addSurvey(Model model, @ModelAttribute("survey") Survey s,Authentication authentication, HttpSession session)
	{
		User a=(User) authentication.getPrincipal();
		s.setCreatedBy(a.getUsername());
//		System.out.println(s.getSurveyId()+"surveyid");
		model.addAttribute("survey2",s);
		surveyService.addSurvey(s);
		
		model.addAttribute("msg", "Survey" + s.getSurveyTitle() + " added successfully!!!");
		Question q= new Question();
		q.setSurveyId(s);
		System.out.println(q.getSurveyId().getSurveyId());
		model.addAttribute("question",q);
		System.out.println(s);
		session.setAttribute("surveyId", s.getSurveyId());
		return "questionForm";
	}
	
	@RequestMapping("addQuestion.do")
	@Transactional
	public String addQuestion(Model model,  
			@ModelAttribute("question") Question q, Authentication authentication, HttpSession session)
	{	
		
		int surveyId=(int) session.getAttribute("surveyId");
		Survey sid = surveyService.getSurveyById(surveyId);
//		Survey s=(Survey) surveyService.addQuestion(question)
		System.out.println(sid + " addques");
		q.setSurveyId(sid);
		surveyService.addQuestion(q);
		model.addAttribute("msg", "question added successfully");
		q=new Question(sid);
		q.setSurveyId(sid);
		System.out.println(q.getSurveyId().getSurveyId());
		model.addAttribute("question",q);
		return "questionForm";
	}
	
	
	
	@RequestMapping("distribute.do")
	public String distribute(Model model,HttpSession session)
	{
		int surveyId=(int) session.getAttribute("surveyId");
		Survey s = surveyService.getSurveyById(surveyId);
		model.addAttribute("user",new com.adobe.prj.entity.User());
		
		List<com.adobe.prj.entity.User> userObjectList=surveyService.getUnsentUsers(s);
		List<String> userList=new ArrayList<String>();
		userObjectList.forEach((u) -> userList.add(u.getUserName()));
		model.addAttribute("userList", userList);
		return "distributionForm";
		
	}
	
	@RequestMapping(value="addDistribution.do")
	public String addDistribution(Model model, @ModelAttribute("user") com.adobe.prj.entity.User u1, HttpSession session)
	{
//		Distribution d = new Distribution();
		System.out.println("here");
		String uname=u1.getUserName();
		System.out.println(uname);
		com.adobe.prj.entity.User user= surveyService.getUserByName(uname);
		Distribution d2=new Distribution();
//		d.setUserId(new com.adobe.prj.entity.User());
		System.out.println(user);
		int surveyId=(int) session.getAttribute("surveyId");
		Survey s = surveyService.getSurveyById(surveyId);
//		Distribution d2=new Distribution();
		d2.setSurveyId(s);
		d2.setSurveyStatus(SurveyStatus.OPEN);
		d2.setDistributionTimestamp(new Date());
		d2.setUserId(user);
		surveyService.distributeSurvey(d2);
		model.addAttribute("msg","distributed to "+ d2.getUserId().getUserName() + " succesfully" );
		List<com.adobe.prj.entity.User> userObjectList=surveyService.getUnsentUsers(s);
		List<String> userList=new ArrayList<String>();
		userObjectList.forEach((u) -> userList.add(u.getUserName()));
		model.addAttribute("userList", userList);
		model.addAttribute("user",new com.adobe.prj.entity.User());
		return "distributionForm";
		
	}
	
//	@RequestMapping()
//	public ModelAndView getUsers()
//	{
//		
//	}
	
//	@RequestMapping("view_qtypes.do")
//	public ModelAndView selectTag()
//	{
//		ModelAndView mav = new ModelAndView();
//		Map<String, String> qTypes=new HashMap<String,String>();
//		qTypes.put("OneCorrect", "oc");
//		qTypes.put("multiCorrect", "mc");
//		qTypes.put("oneline", "ol");
//		qTypes.put("desc", "desc");
//		mav.addObject("qTypes",qTypes);
//		mav.addObject("ques",new Question());
//		return mav;
//	}
	
	
}
