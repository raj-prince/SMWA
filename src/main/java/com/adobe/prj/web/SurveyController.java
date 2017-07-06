package com.adobe.prj.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
