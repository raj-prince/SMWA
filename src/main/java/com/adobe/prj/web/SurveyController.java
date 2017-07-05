package com.adobe.prj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adobe.prj.dao.QuestionDao;
import com.adobe.prj.dao.SurveyDao;
import com.adobe.prj.entity.Distribution;
import com.adobe.prj.entity.Movie;
import com.adobe.prj.entity.Question;
import com.adobe.prj.entity.Survey;
import com.sun.scenario.effect.Blend.Mode;

@Controller
public class SurveyController {
	@Autowired 
	private SurveyDao surveyDao;
	
	@Autowired
	private QuestionDao questionDao;
	
	@RequestMapping("createSurvey.do")
	public String getSurveyForm(Model model) {
		model.addAttribute("survey", new Survey());
		return "surveyForm.jsp";
	}
	
	@RequestMapping("addSurvey.do")
	public String addSurvey(Model model, @ModelAttribute("survey") Survey s)
	{
		surveyDao.addSurvey(s);
		model.addAttribute("survey2",s);
		model.addAttribute("msg_surveyadded", "Survey" + s.getSurveyTitle() + " added successfully!!!");
		Question q= new Question(s);
		model.addAttribute("question",q);
		return "questionForm.jsp";
	}
	
	@RequestMapping("addQuestion.do")
	public String addQuestion(Model model, @ModelAttribute("survey2") Survey sid, 
			@ModelAttribute("question") Question q)
	{
//		model.addAttribute("question", new Question());
//		Question q= new Question(sid);
		questionDao.addQuestion(q);
		model.addAttribute("msg_qa", "question added successfully");
		q=new Question(sid);
		model.addAttribute("question",q);
		return "questionForm.jsp";
	}
	
	
	
	@RequestMapping("distribute.do")
	public String distributeSurvey(Model model, @ModelAttribute("survey2") Survey s)
	{
		Distribution d=new Distribution();
		d.setSurveyId(s);
		model.addAttribute("distri",d);
		return "distributionForm.jsp";
		
	}
	
	
}