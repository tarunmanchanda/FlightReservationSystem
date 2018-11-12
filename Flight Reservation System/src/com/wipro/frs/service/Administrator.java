package com.wipro.frs.service;

import java.util.ArrayList;

import com.wipro.frs.bean.FlightBean;
import com.wipro.frs.bean.PassengerBean;
import com.wipro.frs.bean.RouteBean;
import com.wipro.frs.bean.ScheduleBean;

public interface Administrator {
	/**
	 * 
	 * @param flightBean fb
	 * @return String
	 */
	String addFlight(FlightBean flightBean);
	/**
	 * 
	 * @return ArrayList
	 */
	ArrayList<FlightBean> viewByAllFlights();
/**
 * 
 * @param flightid fd
 * @return FlightBean
 */
	FlightBean viewByFlightId(String flightid);
	/**
	 * 
	 * @param flightBean fb
	 * @return boolean
	 */
	boolean modifyFlight(FlightBean flightBean);
	/**
	 * 
	 * @param flightid fd
	 * @return int
	 */
	int removeFlight(ArrayList<String> flightid);
	
	/**
	 * 
	 * @param routeBean rb
	 * @return String
	 */
	String addRoute(RouteBean routeBean);
	/**
	 * 
	 * @return ArrayList
	 */
	ArrayList<RouteBean> viewByAllRoutes();
	/**
	 * 
	 * @param routeid rd
	 * @return RouteBean
	 */
	RouteBean viewByRouteId(String routeid);
	/**
	 * 
	 * @param routeBean rb
	 * @return boolean
	 */
	boolean modifyRoute(RouteBean routeBean);
	/**
	 * 
	 * @param routeid rd
	 * @return int
	 */
	int removeRoute(ArrayList<String> routeid);
	
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
	ArrayList<ScheduleBean> viewByAllSchedule();
	/**
	 * 
	 * @param scheduleid  sd
	 * @return ScheduleBean
	 */
	ScheduleBean viewByScheduleId(String scheduleid);
	/**
	 * 
	 * @param scheduleBean
	 * @return boolean
	 */
	boolean modifySchedule(ScheduleBean scheduleBean);
	int removeSchedule(ArrayList<String> scheduleid);
	public ArrayList<PassengerBean> viewPasengersBySchedule(String scheduleid);
}
