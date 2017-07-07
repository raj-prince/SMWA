package com.adobe.prj.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adobe.prj.entity.Distribution;
import com.adobe.prj.entity.Question;
import com.adobe.prj.entity.QuestionType;
import com.adobe.prj.entity.Survey;
import com.adobe.prj.entity.SurveyStatus;
import com.adobe.prj.service.SurveyService;

@Controller
public class SurveyController {
	@Autowired 
	private SurveyService surveyService;
	
	@ExceptionHandler(Exception.class)
	public String handleException(HttpServletRequest request, Exception ex){
//		System.out.println("abcd");
		return "error";
	}
	@RequestMapping("createSurvey.do")
	public String getSurveyForm(Model model) {
		model.addAttribute("survey", new Survey());
		return "surveyForm";
//		throw new Exception("test exc");
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
	
	@RequestMapping("showAllSurveys.do")
	public String showAllSurveys(Model model, HttpSession session, Authentication authentication)
	{
		User a=(User) authentication.getPrincipal();
		String createdBy=a.getUsername();
		model.addAttribute("surveyList",surveyService.getAllSurvey(createdBy));
		return "allSurveys";
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
		List<Long> totalCntList = new ArrayList<Long>();
		List<Long> responseCntList = new ArrayList<Long>();
		List<Date> distributionDate = new ArrayList<Date>();
		List<Integer> surveyIdList = new ArrayList<Integer>();
		List<String> surveyTitleList = new ArrayList<String>();
		for (Survey s : allCreatedSurvey) {
			long open = surveyService.cntOpenStatus(s.getSurveyId());
			long closed = surveyService.cntClosedStatus(s.getSurveyId());
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
		Survey survey = surveyService.getSurvey(surveyId);
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
		model.addAttribute("survey", survey);
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
