package com.wipro.frs.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.wipro.frs.bean.PassengerBean;
import com.wipro.frs.bean.ReservationBean;
import com.wipro.frs.util.DBUtil;
import com.wipro.frs.util.DBUtilImpl;

	public class ReservationDAOImpl implements ReservationDAO {
		
		
		@Override
		public String reserveTicket(ReservationBean reservationBean,ArrayList<PassengerBean> passengers) 
		{
			Map<String, Object> session=ActionContext.getContext().getSession();
			String rid=reservationidgen(reservationBean);
			DBUtil dbutil=new DBUtilImpl();
			Connection con=dbutil.getConnection("type4");
			int size1=passengers.size();
			System.out.println("inside reserve before doublwe");
			System.out.println("size is" +size1);
			double totalfare=((Double) session.get("calcfare"))*size1;
			System.out.println("Total Fare"+totalfare);
			
			int inserted=0;
			try
			{
					
				int count=1;
				
				System.out.println("Inside try of reserve ticket");		
				PreparedStatement pst=con.prepareStatement("insert into frs_tbl_reservation values(?,?,?,'Business Class',sysdate,to_date(?,'dd-mm-yyyy'),?,?,1)");
				pst.setString(count++,rid);
				pst.setString(count++,(String) session.get("userid") );
				pst.setString(count++,(String) session.get("scheduleid"));
				SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
				pst.setString(count++,format.format(session.get("date")));
				System.out.println("Date is :: "+format.format(session.get("date")));
				pst.setInt(count++,size1);
				pst.setDouble(count++,totalfare);
				inserted=pst.executeUpdate();
				
				if (inserted>0) 
				{	
			/*		int rescapacity = 0;
				session.get("flightid");
					int count2=1;
					System.out.println("in if of resewrdao impls");
					PreparedStatement pst2=con.prepareStatement("select reservationcapacity from frs_tbl_flight where flightid=?");
					pst2.setString(count2++,(String)session.get("flightid"));
					ResultSet rs=pst.executeQuery();
					while(rs.next())
					{
						System.out.println("in while of if in reserve impl");
					 rescapacity=rs.getInt(1);
					System.out.println("capacity is"+rescapacity);
					}
					System.out.println("afte while ih re impl");
					int count4=1;
					PreparedStatement pst3=con.prepareStatement("update frs_tbl_flight set reservationcapacity=? where flightid=?");
					pst3.setInt(count4++,rescapacity);
					pst3.setString(count4++,(String)session.get("flighid"));
					pst3.executeUpdate();*/ 
					
				//	pst2.setInt(count2++,session.get("reservationcapacity"));
				//	pst2.setString(count2++,reser);
					
					
					Iterator<PassengerBean> it=passengers.iterator();
					//int seat=0;
						int seat=seatnumber();
					while(it.hasNext())
					{
						PassengerBean pass=it.next();
						int count1=1;
						PreparedStatement pst1=con.prepareStatement("insert into frs_tbl_passenger values(?,?,?,?,?)");
						pst1.setString(count1++,rid);
						pst1.setString(count1++,pass.getName());
						pst1.setString(count1++,pass.getGender());
						pst1.setString(count1++,Integer.toString(pass.getAge()));
						pst1.setString(count1++,Integer.toString(seat++));
						pst1.executeUpdate();
					}
					return "success";
				}
				else
				{
					return "error";
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				//log.info(e);
				return "error";
			}
			finally
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//log.info(e);
				}
			}
			
		}
		public int seatnumber()
		{

			DBUtil dbutil=new DBUtilImpl();
			Connection con=dbutil.getConnection("type4");
			int seatno=0;
			try
			{
				PreparedStatement pst=con.prepareStatement("Select * from frs_tbl_passenger");
				if(pst.executeQuery().next()){
					pst=con.prepareStatement("Select max(seatno) from frs_tbl_passenger");
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					
					seatno=Integer.parseInt(rs.getString(1));
				}
				System.out.println(seatno);
			}
				 seatno+=1;
			}				
			catch(Exception e)
			{
				//log.info(e);
				e.printStackTrace();
			}
			System.out.println("allocated seat number:"+seatno);
			return seatno;
		}
	


		public String reservationidgen(ReservationBean reservationBean)
		{
			int reservationID=0;
			System.out.println("in idgen method");
			Map<String, Object> session=ActionContext.getContext().getSession();
			String uid=(String) session.get("userid");
			String sid=(String) session.get("scheduleid");
			System.out.println("uid ::"+uid);
			System.out.println("sid ::"+sid);
			DBUtil dbutil=new DBUtilImpl();
			Connection con=dbutil.getConnection("type4");
			try
			{
				PreparedStatement pst=con.prepareStatement("select frs_seq_reservation_id.NEXTVAL from dual");
				ResultSet rs=pst.executeQuery();
				System.out.println("inside try ");
				if(rs.next())
				{
					System.out.println("if ");
					reservationID=rs.getInt(1);
				}
					String part1=uid.substring(0,(1+1)).toUpperCase();
					String part2=sid.substring(0,(1+1)).toUpperCase();
					String reservationID1=part1+part2+reservationID;
					//reservationBean.setReservationID(reservationID1);
					System.out.println(reservationID1);
					return reservationID1;
					
				
			}
			catch(Exception e)
			{
				
				//log.info(e);
				
			}
			finally
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
				//	log.info(e);
				}
			}
			
			return "";
		}
		
		public ArrayList<PassengerBean> viewPassengers(String scheduleid) {
			Map<String, Object> session=ActionContext.getContext().getSession();
			ResultSet rs = null;
			DBUtil dbutil=new DBUtilImpl();
			Connection con=dbutil.getConnection("type4");
			//java.sql.PreparedStatement getPassenger = null;
			// con = null;
			
			ArrayList<PassengerBean> passengersList = new ArrayList<PassengerBean>();
		try {
				
			System.out.println("in try of view passengers in reser dao impl");
			System.out.println("sc id is"+scheduleid);
			PreparedStatement pst=con.prepareStatement("select reservationid from frs_tbl_reservation where scheduleid=?");
			pst.setString(1, scheduleid);
			rs = pst.executeQuery();

			while (rs.next()) {
				   String resid=rs.getString(1);
				   session.put("reservationss", resid);
				   System.out.println("reser id is  is" +session.get("reservationss"));
				   pst=con.prepareStatement("select * from frs_tbl_passenger where reservationid=?");
				   pst.setString(1,resid);
				   rs=pst.executeQuery();
				
					System.out.println("in while of view passenger in reser dao impl");
					while(rs.next())
					{
					PassengerBean passengers = new PassengerBean();
					//passengers.setReservationid(rs.getString("reservationid"));
					//passengers.setScheduleid(rs.getString("scheduleid"));
					passengers.setName(rs.getString("name"));
					passengers.setAge(rs.getInt("age"));
					passengers.setGender(rs.getString("gender"));
					
					passengersList.add(passengers);
				}
			}

			} catch (Exception e) {
				System.out.println("in catch in reser dao impl view passenm");
				e.printStackTrace();
			}

			return passengersList;
		}
		
	}

