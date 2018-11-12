package com.wipro.frs.dao;

import java.util.ArrayList;

import com.wipro.frs.bean.FlightBean;

public interface flightDAO {
	/**
	 * 
	 * @param flightBean fb
	 * @return String
	 */
	 String registerFlight(FlightBean flightBean);
	 /**
	  * 
	  * @param flightBean fb
	  * @return String
	  */
	 String addFlight(FlightBean flightBean);
	 /**
	  * 
	  * @return Arraylist
	  */
	 ArrayList<FlightBean> findAll();
	 /**
	  * 
	  * @param fightid fd
	  * @return FlightBean
	  */
	 FlightBean viewByFlightID(String fightid);
/**
 * 
 * @param flightBean fb
 * @return boolean
 */
	 boolean updateFlight(FlightBean flightBean);
	 /**
	  * 
	  * @param flightid fbb
	  * @return int
	  */
	 int deleteFlight(ArrayList<String> flightid);
}
