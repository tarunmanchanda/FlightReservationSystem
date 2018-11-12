package com.wipro.frs.service;

import java.util.ArrayList;

import com.wipro.frs.bean.FlightBean;
import com.wipro.frs.bean.PassengerBean;
import com.wipro.frs.bean.RouteBean;
import com.wipro.frs.bean.ScheduleBean;
import com.wipro.frs.dao.ReservationDAO;
import com.wipro.frs.dao.ReservationDAOImpl;
import com.wipro.frs.dao.RouteDAO;
import com.wipro.frs.dao.RouteDAOImpl;
import com.wipro.frs.dao.ScheduleDAO;
import com.wipro.frs.dao.ScheduleDAOImpl;
import com.wipro.frs.dao.flightDAO;
import com.wipro.frs.dao.flightDAOImpl;

public class AdministratorImpl implements Administrator {
	private flightDAO getDetail = new flightDAOImpl();
	/**
	 * 
	 * @return getDetail
	 */
	public flightDAO getGetDetail() {
		return getDetail;
	}
/**
 * 
 * @param getDetail gd
 */
	public void setGetDetail(flightDAO getDetail) {
		this.getDetail = getDetail;
	}

	/**
	 * 
	 * @param flightBean fb
	 * @return String
	 */
	public String addFlight(FlightBean flightBean) 
	{
		flightDAO flight = new flightDAOImpl();
		return flight.addFlight(flightBean);
	}

	@Override
	/**
	 * 
	 * 
	 * @return ArrayList
	 */
	public ArrayList<FlightBean> viewByAllFlights()  
	{
		// TODO Auto-generated method stub
		
	
			
			ArrayList<FlightBean> flightList = new ArrayList<FlightBean>();
			flightList = getDetail.findAll();
			return flightList;
		}
	/**
	 * 
	 * @param flightid fd
	 * @return FlightBean
	 */
	public FlightBean viewByFlightId(String flightid)  
	{
		flightDAO getflight = new flightDAOImpl();
		FlightBean flight = getflight.viewByFlightID(flightid);
		return flight;
	}
	/**
	 * 
	 * @param flightBean fb
	 * @return boolean
	 */
	public boolean modifyFlight(FlightBean flightBean)  
	{
		flightDAO flight =new flightDAOImpl();
		return flight.updateFlight(flightBean);
	}
	
	@Override
	public String addRoute(RouteBean routeBean)  
	{
		// TODO Auto-generated method stub
		RouteDAO route = new RouteDAOImpl();
		System.out.println(routeBean.getSource());
		return route.addRoute(routeBean);
	}

	@Override
	public ArrayList<RouteBean> viewByAllRoutes()  
	{
		// TODO Auto-generated method stub
		RouteDAO getRouteDetails = new RouteDAOImpl();
		ArrayList<RouteBean> routeList = new ArrayList<RouteBean>();
		routeList = getRouteDetails.viewByAllRoute();
		return routeList;
	
	}

	@Override
	public RouteBean viewByRouteId(String routeid)  
	{
		// TODO Auto-generated method stub
	System.out.println("the routwe id in admin"+ routeid);
		RouteDAO getroute = new RouteDAOImpl();
		RouteBean route = getroute.viewByRouteId(routeid);
		System.out.println("THe route in adminimpl is  "+route);
		return route;
		
	
	}

	@Override
	public String addSchedule(ScheduleBean scheduleBean)  
	{
		// TODO Auto-generated method stub
		ScheduleDAO schedule = new ScheduleDAOImpl();
		//System.out.println(scheduleBean.getSource());
		return schedule.addSchedule(scheduleBean);
		
	}
	@Override
	public int removeFlight(ArrayList<String> flightid)  
	{
		
		flightDAO flightdetails = new flightDAOImpl();
		return flightdetails.deleteFlight(flightid);
		
	}

	@Override
	public boolean modifyRoute(RouteBean routeBean)  
	{
		// TODO Auto-generated method stub
		RouteDAO route =new RouteDAOImpl();
		return route.updateRoute(routeBean);
		
	}

	@Override
	public int removeRoute(ArrayList<String> routeid)  
	{
		// TODO Auto-generated method stub
		RouteDAO routedetails = new RouteDAOImpl();
		return routedetails.deleteRoute(routeid);
	
	}
	
	@Override
	public ArrayList<ScheduleBean> viewByAllSchedule()  
	{
		// TODO Auto-generated method stub
		ScheduleDAO getScheduleDetails = new ScheduleDAOImpl();
		ArrayList<ScheduleBean> scheduleList = new ArrayList<ScheduleBean>();
		scheduleList = getScheduleDetails.viewByAllSchedule();
		return scheduleList;
	
	}

	@Override
	public ScheduleBean viewByScheduleId(String scheduleid) 
	{
		// TODO Auto-generated method stub
		System.out.println("THe schedule id in shecsule is "+scheduleid);
		ScheduleDAO getschedule = new ScheduleDAOImpl();
		ScheduleBean schedule = getschedule.viewByScheduleID(scheduleid);
		return schedule;
		
	}
	@Override
	public boolean modifySchedule(ScheduleBean scheduleBean) {
		// TODO Auto-generated method stub
		ScheduleDAO schedule =new ScheduleDAOImpl();
		return schedule.updateSchedule(scheduleBean);
		
	}
	@Override
	public int removeSchedule(ArrayList<String> scheduleid) {
		// TODO Auto-generated method stub
		
		ScheduleDAO scheduledetails = new ScheduleDAOImpl();
		return scheduledetails.deleteSchedule(scheduleid);
		}
	public ArrayList<PassengerBean> viewPasengersBySchedule(String scheduleid) {
		ReservationDAO viewPassenger=new ReservationDAOImpl();
		ArrayList<PassengerBean> passengerList=viewPassenger.viewPassengers(scheduleid);
		return passengerList;
	}
	
}


