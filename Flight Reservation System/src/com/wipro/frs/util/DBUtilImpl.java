package com.wipro.frs.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtilImpl implements DBUtil {	
	/**
	 * @param drivertype dt
	 * @return Connection
	 */
	
	public  Connection getConnection(String drivertype)
	{
	Connection con = null;
	
	if("type1".equals(drivertype))
	{
		System.out.println("wrong driver");
		
	}
	else if("type4".equals(drivertype))
	{	
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			}
			
			catch(Exception e)
			{
				System.out.println(e);
			}
		
	
		}
	return con;	
	
	}
}
