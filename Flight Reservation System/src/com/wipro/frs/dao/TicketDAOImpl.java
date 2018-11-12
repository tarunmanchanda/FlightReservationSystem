package com.wipro.frs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.wipro.frs.bean.FlightBean;
import com.wipro.frs.bean.PassengerBean;
import com.wipro.frs.bean.ReservationBean;
import com.wipro.frs.bean.RouteBean;
import com.wipro.frs.bean.ScheduleBean;
import com.wipro.frs.bean.TicketBean;
import com.wipro.frs.util.DBUtil;
import com.wipro.frs.util.DBUtilImpl;

public class TicketDAOImpl implements TicketDAO {

	
	
	public ArrayList<TicketBean> allTickets() {
		// TODO Auto-generated method stub
		DBUtil dbutil=new DBUtilImpl();
		Connection con=dbutil.getConnection("type4");
		
		ArrayList<TicketBean> tlist=new ArrayList<TicketBean>();
		Map<String, Object> session=ActionContext.getContext().getSession();
		String userid=(String)session.get("userid");
				
		try
		{
			PreparedStatement pst5=con.prepareStatement("Select reservationid,journeydate from frs_tbl_reservation where userid=? and bookingstatus=1");
			pst5.setString(1, userid);
			ResultSet rst=pst5.executeQuery();
			  while(rst.next())
			  {
				  TicketBean showTicketBean=new TicketBean();
				  String res_id=rst.getString(1);
				  Date j_date=rst.getDate(2);
				  showTicketBean.setReservationid(res_id);
				  showTicketBean.setJourneydate(j_date);
				  tlist.add(showTicketBean);
			  }
			  System.out.println(tlist);
			  return tlist;
		}
		catch(Exception e)
		{
		//	log.info(e.toString());
		}
		
		return tlist;
	}

	@Override
	public ArrayList<PassengerBean> ticketDetails(String r_id) {
		// TODO Auto-generated method stub
		{
			System.out.println("before connection in tick details");
			DBUtil dbutil=new DBUtilImpl();
			Connection con=dbutil.getConnection("type4");
			
			Map<String, Object> session=ActionContext.getContext().getSession();
			TicketBean ticketBean=new TicketBean();
			System.out.println("in ticket details tick dao impl");
			ReservationBean reservationBean=new ReservationBean();
			ScheduleBean scheduleBean=new ScheduleBean();
			FlightBean flightBean=new FlightBean();
			RouteBean routeBean=new RouteBean();
			
			
			ArrayList<PassengerBean> list=new ArrayList<PassengerBean>();
			String userid=(String)session.get("userid");
			System.out.println("u id is"+userid);
			try
			{
				System.out.println("in try of ticket details tick dao impl");
				PreparedStatement pst=con.prepareStatement("Select reservationid,scheduleid,journeydate,noofseats,totalfare from frs_tbl_reservation where reservationid=?");
				  pst.setString(1, r_id);
				  ResultSet rs=pst.executeQuery();
				  if(rs.next())
				  {
					  String rid=rs.getString(1);
					  reservationBean.setReservationid(rid);
					  String sid=rs.getString(2);
					  reservationBean.setScheduleid(sid);
					  reservationBean.setJourneydate(rs.getDate(3));
					  reservationBean.setNoofseats(rs.getInt(4));
					  reservationBean.setTotalfare(rs.getDouble(5));
					  session.put("resbean", reservationBean);
					 // System.out.println("the resbean is"+resbean);
					  				  
					  PreparedStatement pst1=con.prepareStatement("Select flightid,routeid,departuretime from frs_tbl_schedule where scheduleid=?");
					  pst1.setString(1, sid);
					  ResultSet rs1=pst1.executeQuery();
				
					  while(rs1.next())
					  {
						  System.out.println("inside while ji hehe..");
						  String fid=rs1.getString(1);
						  scheduleBean.setFlightid(fid);
						  String rid1=rs1.getString(2);
						  scheduleBean.setRouteid(rid1);
						  scheduleBean.setDeparturetime(rs1.getInt(3));
						  session.put("schbean", scheduleBean);
						  
						  
						  PreparedStatement pst2=con.prepareStatement("Select flightname from frs_tbl_flight where flightid=?");
						  pst2.setString(1, fid);
						  ResultSet rs2=pst2.executeQuery();
						  while(rs2.next())
						  {
							  System.out.println("inside ehile2 ji ");
							  flightBean.setFlightname(rs2.getString(1));
							  session.put("flibean", flightBean);
							 
						  }
					 
						  	PreparedStatement pst3=con.prepareStatement("Select source,destination,distance from frs_tbl_route where routeid=?");
						  	pst3.setString(1, rid1);
						  	ResultSet rs3=pst3.executeQuery();
						  	while(rs3.next())
						  	{
						  		System.out.println("inside while 3");
						  		routeBean.setSource(rs3.getString(1));
						  		routeBean.setDestination(rs3.getString(2));
						  		routeBean.setDistance(rs3.getInt(3));
						  		 session.put("roubean", routeBean);
						  		
								  
						  	}
					  }
					  
					  PreparedStatement pst4=con.prepareStatement("Select name,gender,age,seatno from frs_tbl_passenger where reservationid=?");
					  pst4.setString(1, rid);
					  System.out.println("apni reservation id :: "+rid);
					  ResultSet rs4=pst4.executeQuery();
					  while(rs4.next())
					  {
						  PassengerBean passengerBean=new PassengerBean();
						  passengerBean.setName(rs4.getString(1));
						  passengerBean.setGender(rs4.getString(2));
						  passengerBean.setAge(Integer.parseInt(rs4.getString(3)));
						  passengerBean.setSeatno(Integer.parseInt(rs4.getString(4)));
						  list.add(passengerBean);
						  
					  }
				  }
				
				  return list;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			//	log.info(e.toString());
			}
		return null;
	}
}
	
	public boolean removeTicket(String reservationid) {
		// TODO Auto-generated method stub
		DBUtil dbutil=new DBUtilImpl();
		Connection con=dbutil.getConnection("type4");
		
		try
		{
			PreparedStatement pst=con.prepareStatement("Delete from frs_tbl_passenger where reservationid=?");
			pst.setString(1, reservationid);
			int rs=pst.executeUpdate();
			
			if(rs>0)
			{
				PreparedStatement pst1=con.prepareStatement("Update frs_tbl_reservation set bookingstatus=0 where reservationid=?");
				pst1.setString(1, reservationid);
				int rs1=pst1.executeUpdate();
				if(rs1>0)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		catch(Exception e)
		{
			//log.info(e.toString());
		}
		return false;
	}
}

