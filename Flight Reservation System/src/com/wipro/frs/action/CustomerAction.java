package com.wipro.frs.action;

import java.util.Date;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.wipro.frs.bean.FlightBean;
import com.wipro.frs.bean.RouteBean;
import com.wipro.frs.bean.ScheduleBean;
import com.wipro.frs.service.Administrator;
import com.wipro.frs.service.AdministratorImpl;
import com.wipro.frs.service.Customer;
import com.wipro.frs.service.CustomerImpl;

public class CustomerAction implements ModelDriven {
	
	private String source;
	private String destination;
	private Date date;
	private String flightid;
	ArrayList<ScheduleBean> scheduleLList = new ArrayList<ScheduleBean>();
	private FlightBean flightBean= new FlightBean();
	private RouteBean routeBean= new RouteBean();
	ScheduleBean schedule = new ScheduleBean();
	private String scheduleid;
	private String routeid;
	private int travelduration;
	HttpServletRequest request;
	private double fare;
	private int distance;
	
	

	public int getTravelduration() {
		return travelduration;
	}

	public void setTravelduration(int travelduration) {
		this.travelduration = travelduration;
	}

	public String getFlightid() {
		return flightid;
	}

	public void setFlightid(String flightid) {
		this.flightid = flightid;
	}

	public FlightBean getFlightBean() {
		return flightBean;
	}

	public void setFlightBean(FlightBean flightBean) {
		this.flightBean = flightBean;
	}

	public String getRouteid() {
		return routeid;
	}

	public void setRouteid(String routeid) {
		this.routeid = routeid;
	}

	public String getScheduleid() {
		return scheduleid;
	}

	public void setScheduleid(String scheduleid) {
		this.scheduleid = scheduleid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public ArrayList<ScheduleBean> getScheduleLList() {
		return scheduleLList;
	}

	public void setScheduleLList(ArrayList<ScheduleBean> scheduleLList) {
		this.scheduleLList = scheduleLList;
	}

	public ScheduleBean getSchedule() {
		return schedule;
	}

	public void setSchedule(ScheduleBean schedule) {
		this.schedule = schedule;
	}

	public RouteBean getRouteBean() {
		return routeBean;
	}

	public void setRouteBean(RouteBean routeBean) {
		this.routeBean = routeBean;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String viewFlightName() {
		Map<String, Object> session=ActionContext.getContext().getSession();
		Administrator showflight = new AdministratorImpl();
		session.put("scheduleid", scheduleid);
		session.put("flightid",flightid);
		
		flightBean = showflight.viewByFlightId(getFlightid());
		
		schedule=showflight.viewByScheduleId(getScheduleid());
	
		routeBean=showflight.viewByRouteId(schedule.getRouteid());
	
		
		double calcfare=calcfare(routeBean);
		System.out.println("fare is"+calcfare);
		
		
		
		session.put("calcfare", calcfare);
		System.out.println("the session id: " + session.get("calcfare"));
		return "success";
	}
	
	public String viewAllschedulebyroute() {
		Map<String, Object> session=ActionContext.getContext().getSession();
		session.put("date", date);
		Customer showschedulebyroute = new CustomerImpl();
		scheduleLList = showschedulebyroute.viewScheduleByRoute(source,destination,date);
		session.put("schedule",scheduleLList);
			return "success";
		}
	//	public String view()
	//{
	//	Administrator administratorImpl=new AdministratorImpl();
	//	flight1=administratorImpl.viewFlightById(schedule.getFlightID());
	//	schedule1=administratorImpl.viewByScheduleId(schedule.getFlightID());
	//	route1=administratorImpl.viewByRouteId(schedule.getRouteID());
	
	//	double calcfare=calcfare();
//		
	//	request.setAttribute("calcfare", calcfare);
	//	return "Success";
	//}
	
	public double calcfare(RouteBean routBean)
	{
	
		double fare=routeBean.getFare();
		System.out.println("fare is"+fare);
		int distance=routeBean.getDistance();
		System.out.println("distance is" +distance);
		Double calcfare=fare*distance;
		return calcfare;
	}
	
	
	
	
	
	
		}
