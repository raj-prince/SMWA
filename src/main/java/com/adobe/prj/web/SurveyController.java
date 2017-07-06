package com.adobe.prj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adobe.prj.entity.Distribution;
import com.adobe.prj.entity.Question;
import com.adobe.prj.entity.Survey;
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
	public String addSurvey(Model model, @ModelAttribute("survey") Survey s,Authentication authentication)
	{
		org.springframework.security.core.userdetails.User a=(org.springframework.security.core.userdetails.User) authentication.getPrincipal();
		s.setCreatedBy(a.getUsername());
		surveyService.addSurvey(s);
		model.addAttribute("survey2",s);
		model.addAttribute("msg_surveyadded", "Survey" + s.getSurveyTitle() + " added successfully!!!");
		Question q= new Question(s);
		model.addAttribute("question",q);
		return "questionForm";
	}
	
	@RequestMapping("addQuestion.do")
	public String addQuestion(Model model, @ModelAttribute("survey2") Survey sid, 
			@ModelAttribute("question") Question q)
	{
//		model.addAttribute("question", new Question());
//		Question q= new Question(sid);
		surveyService.addQuestion(q);
		model.addAttribute("msg", "question added successfully");
		q=new Question(sid);
		model.addAttribute("question",q);
		return "questionForm";
	}
	
	
	
	@RequestMapping("distribute.do")
	public String distribute(Model model, @ModelAttribute("survey2") Survey s)
	{
		Distribution d=new Distribution();
		d.setSurveyId(s);
		model.addAttribute("distri",d);
		return "distributionForm";
		
	}
	
	@RequestMapping("addDistribution.do")
	public String addDistribution(Model model, @ModelAttribute("distri") Distribution d)
	{
		surveyService.distributeSurvey(d);
		model.addAttribute("msg","distributed to "+ d.getUserId().getUserName() + " succesfully" );
		return "summaryPage";
		
	}
	
	
}
