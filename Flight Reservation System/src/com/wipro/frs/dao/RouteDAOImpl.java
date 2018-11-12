package com.wipro.frs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;


import com.wipro.frs.bean.RouteBean;
import com.wipro.frs.bean.ScheduleBean;

import com.wipro.frs.util.DBUtil;
import com.wipro.frs.util.DBUtilImpl;

public class RouteDAOImpl implements RouteDAO{
	
	private PreparedStatement pst;
	private ResultSet rs;
	private Connection con;
	/**
	 * 
	 */
	public RouteDAOImpl()
		{
		DBUtil dbutilobj=new DBUtilImpl();
		con=dbutilobj.getConnection("type4");
		}

	@Override
	public String registerRoute(RouteBean routeBean) {
		// TODO Auto-generated method stub
		int b=1;
		try { String s ="";
		System.out.println("in try");
		pst=con.prepareStatement("select frs_seq_route_id.nextval from dual");
		System.out.println("after prepare");
		rs=pst.executeQuery();
		System.out.println("b4 while");
		while(rs.next())
			{
			System.out.println("in whule");
		   s = routeBean.getSource().substring(0,b+1).concat(routeBean.getDestination().substring(0,b+1).concat(rs.getString(1)));
		System.out.println(s);
	return s;
	}
				} 
	catch (SQLException e) {				
		e.printStackTrace();
	}
	return "Fail";
}
@Override
	public String addRoute(RouteBean routeBean) {
		
		try {
			int count=1;
			String routeid=registerRoute(routeBean);
				pst=con.prepareStatement("insert into frs_tbl_route values(?,?,?,?,?)");
				pst.setString(count++, routeid);
				pst.setString(count++, routeBean.getSource());
				pst.setString(count++,routeBean.getDestination());
				pst.setInt(count++, routeBean.getDistance());
				pst.setDouble(count++, routeBean.getFare());
				
				
				
				if(pst.executeUpdate()>0)
				{
					return routeid;
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
public ArrayList<RouteBean> viewByAllRoute() {
	// TODO Auto-generated method stub
	ArrayList<RouteBean> routeList = new ArrayList<RouteBean>();
	
	try {
		System.out.println("in try route");
		pst = con.prepareStatement("select * from frs_tbl_route");
		rs = pst.executeQuery();
		
		while (rs.next()) {
			RouteBean route = new RouteBean();
			route.setRouteid(rs.getString("routeid"));
			route.setSource(rs.getString("source"));
			route.setDestination(rs.getString("destination"));
			route.setDistance(rs.getInt("distance"));
			route.setFare(rs.getInt("fare"));
			System.out.println("adding");
			routeList.add(route);
			System.out.println("added");
		}return routeList;

	} catch (Exception e) {
		System.out.println("in catch of view all route");
		e.printStackTrace();
		return null;
	}
	
}

@Override
public RouteBean viewByRouteId(String routeid) {
	// TODO Auto-generated method stub
	
	
	RouteBean route1 = new RouteBean();
	try {
		
		System.out.println("insider try of routedao"+ " "+routeid);
		pst = con.prepareStatement("select * from frs_tbl_route where routeid=?");
		pst.setString(1,routeid);
		rs = pst.executeQuery();
		
		
		while (rs.next()) {
			System.out.println("inside while routedao");
			
			route1.setRouteid(rs.getString("routeid"));
			route1.setSource(rs.getString("source"));
			route1. setDestination(rs.getString("destination"));
			route1.setDistance(rs.getInt("distance"));
			route1.setFare(rs.getInt("fare"));
		
			System.out.println(route1.getDestination());
			System.out.println(route1.getDistance());
			System.out.println(route1.getSource());
			System.out.println(route1.getRouteid());
			System.out.println(route1.getFare());
			
			
			
			
			
			
 }
		return route1;
	}
	catch (Exception e) {
		e.printStackTrace();
		return null;
	}

	

}

@Override
public boolean updateRoute(RouteBean routeBean) {
	// TODO Auto-generated method stub
	try {
		int count=1;
		System.out.println("in the update method");
			pst=con.prepareStatement("Update frs_tbl_route set source=?,destination=?,distance=?,fare=? where routeid=?");
			System.out.println("afte query");
			pst.setString(count++, routeBean.getSource());
			pst.setString(count++, routeBean.getDestination());
			pst.setInt(count++, routeBean.getDistance());
			pst.setDouble(count++, routeBean.getFare());
			pst.setString(count++, routeBean.getRouteid());
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
public int deleteRoute(ArrayList<String> routeid) 
	{
	// TODO Auto-generated method stub
	System.out.println("inside delete func");
	
	try
	{
		Iterator it=routeid.iterator();
	  while(it.hasNext())
		{
			String s=(String)it.next();
		PreparedStatement pst=con.prepareStatement("delete from frs_tbl_schedule where routeid=?");
		pst.setString(1,s);
		pst.executeUpdate();
		System.out.println("inside try delete of route");
		pst=con.prepareStatement("delete from frs_tbl_route where routeid=?");
		System.out.println("afte sql in route ");
		pst.setString(1,s);
		int deleteresult=pst.executeUpdate();
		System.out.println("b4 if deld");
		if(deleteresult>0)
		{
			return 1;
		}
	else
	{	System.out.println("inside else of del method");
		return 0;
	}
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("in catch del");
		}
	
	return 1;
}

	
}
