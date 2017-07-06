package com.adobe.prj.dao;

import java.util.Date;
import java.util.List;

import com.adobe.prj.entity.Distribution;

public interface DistributionDao {

	public int distributeSurvey(Distribution distribution);
	public int dis(Distribution distribution);
	public List<Distribution> getDistributedSurveys();
	
	// return count of the Responded user.
	public int cntClosedStatus(int surveyId);
	
	// return count of the not responded user.
	public int cntOpenStatus(int surveyId);
	
	// returns time stamp of the survey when it is being distributed.
	public Date getTimeStamp(int surveyId);
	
}
