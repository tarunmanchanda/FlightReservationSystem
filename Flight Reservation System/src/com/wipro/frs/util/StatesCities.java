package com.wipro.frs.util;

import java.util.ArrayList;

import com.wipro.frs.dao.StateCityDAO;

public class StatesCities {
	
	public ArrayList<String> getCityList(String state)
	{
		ArrayList<String> cityList = new ArrayList<String>();
		
		StateCityDAO stateCity = new StateCityDAO();
		
		cityList = stateCity.getCities(state);
		
		return cityList;
		
	}
	
	public ArrayList<String> getStatesList()
	{
		ArrayList<String> stateList = new ArrayList<String>();
		
		StateCityDAO stateCity = new StateCityDAO();
		
		stateList = stateCity.getStates();
		
		return stateList;
		
	}

}
