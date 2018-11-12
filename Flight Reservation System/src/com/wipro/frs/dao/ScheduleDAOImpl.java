package com.wipro.frs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.wipro.frs.bean.ScheduleBean;

import com.wipro.frs.util.DBUtil;
import com.wipro.frs.util.DBUtilImpl;

public class ScheduleDAOImpl implements ScheduleDAO {
/**
 * 
 */
	
	/**
	 * 
	 * @param scheduleBean sb
	 * @return String
	 */
	public String registerSchedule(ScheduleBean scheduleBean) {
		// TODO Auto-generated method stub
		int c=1;
		
		try { String s ="";
		System.out.println("in try");
		DBUtil dbutilobj=new DBUtilImpl();
		Connection con=dbutilobj.getConnection("type4");
		PreparedStatement pst=con.prepareStatement("select frs_seq_schedule_id.nextval from dual");
		System.out.println("after prepare");
		ResultSet rs=pst.executeQuery();
		System.out.println("b4 while");
		while(rs.next())
			{
			System.out.println("in while");
		  s = scheduleBean.getFlightid().substring(0,c+1).concat(scheduleBean.getRouteid().substring(0,c+1).concat(rs.getString(1)));
		//s=rs.getString(1);
			System.out.println();
			System.out.println(s);
	return s;
	}
				} 
	catch (SQLException e) {				
		e.printStackTrace();
	}
	return "Fail";
}
	
	/**
	 * 
	 * @param scheduleBean sb
	 * @return String
	 */
public String addSchedule(ScheduleBean scheduleBean) {
try {
	        int count=1;
			String scheduleid=registerSchedule(scheduleBean);
			DBUtil dbutilobj=new DBUtilImpl();
			Connection con=dbutilobj.getConnection("type4");
			PreparedStatement pst=con.prepareStatement("insert into frs_tbl_schedule values(?,?,?,?,?,?)");
				pst.setString(count++,scheduleid);
				System.out.println("the schedule id is "+scheduleid);

				System.out.println("the schedule id is "+scheduleBean.getFlightid());
				System.out.println("the schedule id is "+scheduleBean.getRouteid());
				
				pst.setString(count++,scheduleBean.getFlightid());
				pst.setString(count++,scheduleBean.getRouteid());
				pst.setInt(count++, scheduleBean.getTravelduration());
				pst.setString(count++,scheduleBean.getAvailabledays());
				pst.setInt(count++,scheduleBean.getDeparturetime());
				if(pst.executeUpdate()>0)
				{
					return scheduleid;
			}
				}
		 catch (SQLException e) {
			System.out.println("error registering"+e);
			e.printStackTrace();
		
		
		return "error";
		
	}
		
	return null;
}


@Override
public ArrayList<ScheduleBean> viewByAllSchedule() {
	// TODO Auto-generated method stub
	ArrayList<ScheduleBean> scheduleList = new ArrayList<ScheduleBean>();
	
	try {
		System.out.println("in try");
		DBUtil dbutilobj=new DBUtilImpl();
		Connection con=dbutilobj.getConnection("type4");
		PreparedStatement pst = con.prepareStatement("select * from frs_tbl_schedule");
		ResultSet rs = pst.executeQuery();
		
		while (rs.next()) {
			ScheduleBean schedule = new ScheduleBean();
			schedule.setScheduleid(rs.getString("scheduleid"));
			schedule.setFlightid(rs.getString("flightid"));
			schedule.setRouteid(rs.getString("routeid"));
			schedule.setTravelduration(rs.getInt("travelduration"));
			schedule.setAvailabledays(rs.getString("availabledays"));
			schedule.setDeparturetime(rs.getInt("departuretime"));
			System.out.println("displaying sched");
			scheduleList.add(schedule);
			System.out.println("displayed scedu");
		}
		return scheduleList;
	} 
	catch (Exception e) {
		System.out.println("in catch of view all schedule");
		e.printStackTrace();
		return null;
	}
	
}


@Override
public ScheduleBean viewByScheduleID(String scheduleid) {
	// TODO Auto-generated method stub
	ScheduleBean schedule1 = new ScheduleBean();
	try {
		
		System.out.println("in try: the value of scedule id in scheduledao is "+ scheduleid);
		DBUtil dbutilobj=new DBUtilImpl();
		Connection con=dbutilobj.getConnection("type4");
		
		PreparedStatement pst = con.prepareStatement("select * from frs_tbl_schedule where scheduleid=?");
		pst.setString(1,scheduleid);
		
		ResultSet rs = pst.executeQuery();
		
		while (rs.next()) {
			schedule1.setScheduleid(rs.getString("scheduleid"));
			schedule1.setFlightid(rs.getString("flightid"));
			schedule1.setRouteid(rs.getString("routeid"));
			schedule1.setTravelduration(rs.getInt("travelduration"));
			schedule1. setAvailabledays(rs.getString("availabledays"));
			schedule1.setDeparturetime(rs.getInt("departuretime"));		
}
		return schedule1;
	}catch (Exception e) {
		e.printStackTrace();
		return null;
	}
}
@Override
public boolean updateSchedule(ScheduleBean scheduleBean) {
	// TODO Auto-generated method stub
	try {
		int count=1;
		DBUtil dbutilobj=new DBUtilImpl();
		Connection con=dbutilobj.getConnection("type4");
		System.out.println("in the update method");
			PreparedStatement pst=con.prepareStatement("Update frs_tbl_schedule set flightid=?,routeid=?,travelduration=?,availabledays=?,departuretime=? where scheduleid=?");
			System.out.println("afte query");
			pst.setString(count++, scheduleBean.getFlightid());
			pst.setString(count++, scheduleBean.getRouteid());
			pst.setInt(count++, scheduleBean.getTravelduration());
			pst.setString(count++, scheduleBean.getAvailabledays());
			pst.setInt(count++, scheduleBean.getDeparturetime());
			pst.setString(count++, scheduleBean.getScheduleid());
			int i=pst.executeUpdate();
			System.out.println("updated rows are:"+i);
			if(i>0)
			{
				return true;
			}
			}
	 catch (SQLException e) {
		System.out.println("error registering"+e);
		e.printStackTrace();
	}
	
	
	return false;

}

@Override
public int deleteSchedule(ArrayList<String> scheduleid) {
	// TODO Auto-generated method stub
	DBUtil dbutilobj=new DBUtilImpl();
	Connection con=dbutilobj.getConnection("type4");
	System.out.println("inside delete func");
	Iterator it=scheduleid.iterator();
	while(it.hasNext())
	{
		try
		{
		System.out.println("inside try delete of route");
		PreparedStatement pst=con.prepareStatement("delete from frs_tbl_schedule where scheduleid=?");
		System.out.println("afte sql in schedule");
		pst.setString(1,(String) it.next());
		int deleteresult=pst.executeUpdate();
		System.out.println("b4 if deld");
		if(deleteresult<0)
		{
			return 0;
		}
	else
	{	System.out.println("inside else of del method of scheduke");
		return 1;
	}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("in catch del");
		}
	}
	return 1;
}
}








