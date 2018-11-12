package com.wipro.frs.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import com.wipro.frs.bean.ScheduleBean;
import com.wipro.frs.util.DBUtil;
import com.wipro.frs.util.DBUtilImpl;

public class CustomerDAOImpl implements CustomerDAO {

public String getDay(Date date)
{
System.out.println("in "+date);
Calendar c = Calendar.getInstance();
c.setTime(date);
int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
System.out.println("dsauy  "+dayOfWeek);
switch(dayOfWeek)
{
case 1: 
	return "sun";
case 2:
	return "mon";
case 3:
	return "tue";
case 4:
	return "wed";
case 5:
	return "thu";
case 6:
	return "fri";
case 7:
	return "sat";

	default: return "no day selected";
}
}
@Override
	public ArrayList<ScheduleBean> viewScheduleByRoute(String source,
			String destination, Date date) {
	
	ArrayList<ScheduleBean> scheduleList = new ArrayList<ScheduleBean>();
	ScheduleBean schedule=null;
	try {
		
		DBUtil dbutilobj=new DBUtilImpl();
		Connection con=dbutilobj.getConnection("type4");
		String dayy=getDay(date);
		System.out.println("day is" +dayy);
		PreparedStatement pst = con.prepareStatement("select * from frs_tbl_schedule inner join frs_tbl_route on frs_tbl_schedule.routeid=frs_tbl_route.routeid AND frs_tbl_route.source=? AND frs_tbl_route.destination=? AND frs_tbl_schedule.availabledays like ?");
		pst.setString(1, source);
		System.out.println("source is" +source);
		pst.setString(2, destination);
		System.out.println("destination is" +destination);
		pst.setString(3, "%"+dayy+"%");
		ResultSet rs = pst.executeQuery();
		System.out.println("b4 while cust impl");
		while(rs.next()) 
		{
			System.out.println("inside while");
			schedule = new ScheduleBean();
			schedule.setScheduleid(rs.getString("scheduleid"));
			schedule.setFlightid(rs.getString("flightid"));
			schedule.setRouteid(rs.getString("routeid"));
			schedule.setTravelduration(rs.getInt("travelduration"));
			schedule.setAvailabledays(rs.getString("availabledays"));
			schedule.setDeparturetime(rs.getInt("departuretime"));
			scheduleList.add(schedule);
		}
		
		//con.close();

	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("in catch ib cusy impl");
	}

	return scheduleList;
	}


}

