package com.wipro.frs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.wipro.frs.util.DBUtilImpl;

public class StateCityDAO {
	
	private static Logger log = Logger.getLogger(StateCityDAO.class.getName());
	private Connection con;
	
	public StateCityDAO(){
		con = new DBUtilImpl().getConnection("type4");
	}

	public ArrayList<String> getCities(String state){
		
		ArrayList<String> cityList = new ArrayList<String>();
		
		try{
			PreparedStatement prepStmt = con.prepareStatement("select destination from frs_tbl_route where source=?");
			prepStmt.setString(1, state);
			
			ResultSet resCities = prepStmt.executeQuery();
			
			String city = null;
			
			while(resCities.next()){
				city = resCities.getString("destination");
				if(city != null){
					cityList.add(city);
				}
				else{
					cityList.add(state);
				}
			}
			
			return cityList;
		}
		catch(SQLException sqlExp){
			log.info(sqlExp.toString());
			return null;
		}
		
	}
	
public ArrayList<String> getStates(){
		
		ArrayList<String> stateList = new ArrayList<String>();
		
		try{
			PreparedStatement prepStmt = con.prepareStatement("select DISTINCT source from frs_tbl_route order by source asc");
			
			ResultSet resStates = prepStmt.executeQuery();
			
			String state = null;
			
			while(resStates.next()){
				state = resStates.getString("source");
				System.out.println(state);
				stateList.add(state);
			}
			
			return stateList;
		}
		catch(SQLException sqlExp){
			log.info(sqlExp.toString());
			return null;
		}
		
	}
}
