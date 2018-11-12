package com.wipro.frs.dao;

import java.util.Date;
import java.util.ArrayList;

import com.wipro.frs.bean.ScheduleBean;

public interface CustomerDAO {

	
	ArrayList<ScheduleBean> viewScheduleByRoute(String source, String destination, Date date);	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
