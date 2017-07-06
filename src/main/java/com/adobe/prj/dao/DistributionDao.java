package com.adobe.prj.dao;

import java.util.List;

import com.adobe.prj.entity.Distribution;
import com.adobe.prj.entity.Survey;
import com.adobe.prj.entity.User;

public interface DistributionDao {

	public int distributeSurvey(Distribution distribution);
	public int dis(Distribution distribution);
	public List<User> getUnsentUsers(Survey s);
	
}
