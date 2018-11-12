package com.wipro.frs.util;
import java.sql.Connection;

public interface DBUtil 
{
	
	/**
	 * 
	 * @param drivertype dt
 	 * @return Connection
	 */
	
	Connection  getConnection(String drivertype);
}