package com.wipro.frs.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.wipro.frs.util.StatesCities;

public class GetSource extends ActionSupport{
	
	private ArrayList<String> destinationList;
	private ArrayList<String> sourceList;
	private String source;
	
	public String execute(){
		
		StatesCities stateCity = new StatesCities();
		
		ArrayList<String> cities = new ArrayList<String>();
		cities = stateCity.getCityList(source);
		
		if(cities.size() == 0){
			cities.add(getSource());
		}
		
		setDestinationList(cities);
		
		return SUCCESS;
		
	}
	
	/**
	 * @return the destinationList
	 */
	public ArrayList<String> getDestinationList() {
		return destinationList;
	}

	/**
	 * @param destinationList the destinationList to set
	 */
	public void setDestinationList(ArrayList<String> destinationList) {
		this.destinationList = destinationList;
	}

	/**
	 * @return the sourceList
	 */
	public ArrayList<String> getSourceList() {
		return sourceList;
	}

	/**
	 * @param sourceList the sourceList to set
	 */
	public void setSourceList(ArrayList<String> sourceList) {
		this.sourceList = sourceList;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	public String getSources(){
		
		StatesCities stateCity = new StatesCities();
		
		ArrayList<String> states = new ArrayList<String>();
		states = stateCity.getStatesList();
		setSourceList(states);
		
		return SUCCESS;
		
	}
}
