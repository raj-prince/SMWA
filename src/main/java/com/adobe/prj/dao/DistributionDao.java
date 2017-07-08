package com.adobe.prj.dao;

import java.util.Date;
import java.util.List;

import com.adobe.prj.entity.Distribution;
import com.adobe.prj.entity.Survey;
import com.adobe.prj.entity.User;

public interface DistributionDao {
	
	/*
	 * Insert Distribution in the DataBase and returns
	 * their distribution id.
	 */
	public int distributeSurvey(Distribution distribution);
	
	/*
	 * returns all distribution object from the DataBase.
	 */
	public List<Distribution> getDistributedSurveys();
	
	/*
	 *  return count of the Responded user.
	 */
	public long cntClosedStatus(int surveyId);
	
	/* 
	 * return count of the not responded user.
	 */
	public long cntOpenStatus(int surveyId);
	
	/*
	 * returns time stamp of the survey when it is being distributed.
	 */
	public Date getTimeStamp(int surveyId);
	
	/*
	 * return list of users object for which survey
	 * is not distributed yet.
	 */
	public List<User> getUnsentUsers(Survey s);
	
}
