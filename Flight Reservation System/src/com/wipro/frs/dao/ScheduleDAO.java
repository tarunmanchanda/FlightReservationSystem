package com.wipro.frs.dao;

import java.util.ArrayList;

import com.wipro.frs.bean.RouteBean;
import com.wipro.frs.bean.ScheduleBean;

public interface ScheduleDAO {
	/**
	 * 
	 * @param scheduleBean sb
	 * @return String
	 */
	 String registerSchedule(ScheduleBean scheduleBean);
	 /**
	  * 
	  * @param scheduleBean sb
	  * @return String
	  */
		String addSchedule(ScheduleBean scheduleBean);
		/**
		 * 
		 * @return ArrayList
		 */
		ArrayList<ScheduleBean>viewByAllSchedule();
		/**
		 * 
		 * @param scheduleid sd
		 * @return ScheduleBean
		 */
		ScheduleBean viewByScheduleID(String scheduleid);
		/**
		 * 
		 * @param routeBean
		 * @return boolean
		 */
		boolean updateSchedule(ScheduleBean scheduleBean);
		int deleteSchedule(ArrayList<String> scheduleid);
	
}
