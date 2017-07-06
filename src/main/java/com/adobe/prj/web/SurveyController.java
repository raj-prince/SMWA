package com.adobe.prj.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adobe.prj.entity.Distribution;
import com.adobe.prj.entity.Question;
import com.adobe.prj.entity.QuestionType;
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
	public String addSurvey(Model model, @ModelAttribute("survey") Survey s,
			Authentication authentication) {
		org.springframework.security.core.userdetails.User a = 
				(org.springframework.security.core.userdetails.User) authentication.getPrincipal();
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
	
	/*
	 * This controller method is invoked after clicking on the review survey by the
	 * surveyor. It collects all the survey created by the current surveyor and
	 * counts the total number of user where this survey is being distributed along with
	 * that also counts how many respondent responded to that distribution.
	 */
	@RequestMapping("reviewResponseForSurvey.do")
	public String reviewResponseForSurvey(Model model, Authentication authentication) {
		org.springframework.security.core.userdetails.User currentUser = 
				(org.springframework.security.core.userdetails.User) authentication.getPrincipal();
		String currentUserName = currentUser.getUsername();
		List<Survey> allCreatedSurvey = surveyService.getAllSurvey(currentUserName);
		List<Integer> totalCntList = new ArrayList<Integer>();
		List<Integer> responseCntList = new ArrayList<Integer>();
		List<Date> distributionDate = new ArrayList<Date>();
		List<Integer> surveyIdList = new ArrayList<Integer>();
		List<String> surveyTitleList = new ArrayList<String>();
		for (Survey s : allCreatedSurvey) {
			int open = surveyService.cntOpenStatus(s.getSurveyId());
			int closed = surveyService.cntClosedStatus(s.getSurveyId());
			surveyIdList.add(s.getSurveyId());
			totalCntList.add(open + closed);
			responseCntList.add(open);
			distributionDate.add(surveyService.getTimeStamp(s.getSurveyId()));
			surveyTitleList.add(s.getSurveyTitle());
		}
		model.addAttribute("surveyIdList", surveyIdList);
		model.addAttribute("totalCntList", totalCntList);
		model.addAttribute("responseCntList", responseCntList);
		model.addAttribute("distributionList", distributionDate);
		model.addAttribute("surveyTitleList", surveyTitleList);

		return "reviewResponseForSurvey";
	}
	
	/*
	 * This controller method is invoked after clicking on the given survey. It analysis
	 * all questions for a given survey with their responses and render it to the 
	 * view "reviewResponForQuestion".
	 */
	@RequestMapping("reviewResponseForQuestion.do")
	public String reviewResponseForQuestion(@RequestParam("surveyId") String surveyIdStr, Model model) {
		int surveyId = Integer.parseInt(surveyIdStr);
		Survey surveyor = surveyService.getSurvey(surveyId);
		List<Question> listOfQuestion = surveyService.getQuestions(surveyId);
		List<Question> mcqQuestion = new ArrayList<Question>();
		List<Integer> cntForA = new ArrayList<Integer>();
		List<Integer> cntForB = new ArrayList<Integer>();
		List<Integer> cntForC = new ArrayList<Integer>();
		List<Integer> cntForD = new ArrayList<Integer>();
		
		List<Question> descQuestion = new ArrayList<Question>();
		
		List<List<String>> descAnswer = new ArrayList<List<String>>();
		
		
		for (Question q : listOfQuestion) {
			if (q.getQuestionType() == QuestionType.ONE_CORRECT || q.getQuestionType() == QuestionType.MORE_CORRECT) {
				mcqQuestion.add(q);
				cntForA.add(surveyService.countResponse(q.getQuestionId(), "A"));
				cntForB.add(surveyService.countResponse(q.getQuestionId(), "B"));
				cntForC.add(surveyService.countResponse(q.getQuestionId(), "C"));
				cntForD.add(surveyService.countResponse(q.getQuestionId(), "D"));
			} else {
				descQuestion.add(q);
				descAnswer.add(surveyService.getResponseForId(q.getQuestionId()));
			}
		}
		model.addAttribute("surveyor", surveyor);
		model.addAttribute("mcqQuestion", mcqQuestion);
		model.addAttribute("cntForA", cntForA);
		model.addAttribute("cntForB", cntForB);
		model.addAttribute("cntForC", cntForC);
		model.addAttribute("cntForD", cntForD);
		model.addAttribute("descQuestoin", descQuestion);
		model.addAttribute("descAnswer", descAnswer);
		
		return "reviewResponseForQuestion";
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
