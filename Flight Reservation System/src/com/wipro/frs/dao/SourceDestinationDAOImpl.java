package com.wipro.frs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.frs.util.DBUtil;
import com.wipro.frs.util.DBUtilImpl;

public class SourceDestinationDAOImpl implements SourceDestinationDAO{
	
	//private static Logger log = Logger.getLogger(StateCityDAO.class.getName());
	private Connection con;
	
	public SourceDestinationDAOImpl(){
		DBUtil dbutilobj=new DBUtilImpl();
		Connection con=dbutilobj.getConnection("type4");
	}

	public ArrayList<String> getCities() {
		
		ArrayList<String> sourceList = new ArrayList<String>();
		
		try{
			PreparedStatement pst= con.prepareStatement("select source from frs_tbl_route ");
		//	pst.setString(1, source);
			
			ResultSet rs = pst.executeQuery();
			
			String source = null;
			
			while(rs.next()){
				source = rs.getString("source");
				System.out.println(source);
				sourceList.add(source);
			}
			
			return sourceList;
		}
		catch(SQLException sqlExp){
			//log.info(sqlExp.toString());
			return null;
		}
		
	}


}
