package com.wipro.frs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;


import com.wipro.frs.bean.FlightBean;

import com.wipro.frs.util.DBUtil;
import com.wipro.frs.util.DBUtilImpl;

public class flightDAOImpl  implements flightDAO {

		private Connection con;
		public flightDAOImpl()
			{
			DBUtil dbutilobj=new DBUtilImpl();
			con=dbutilobj.getConnection("type4");
			}
		/**
		 * @param flightBean fb
		 * @return String
		 */
		public String registerFlight(FlightBean flightBean) {
			int a=1;
		
			try { String s ="";
				System.out.println("in try");
				PreparedStatement pst=con.prepareStatement("select frs_seq_flight_id.nextval from dual");
				ResultSet rs=pst.executeQuery();
				while(rs.next())
					{
					s = flightBean.getFlightname().substring(0,a+1).concat(rs.getString(1));
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
		 * @param flightBean dfb
		 * @return String
		 */
		public String addFlight(FlightBean flightBean) {
			String flightid=registerFlight(flightBean);
			try {
				    int count=1;
				PreparedStatement pst=con.prepareStatement("insert into frs_tbl_flight values(?,?,?,?)");
					pst.setString(count++, flightid);
					pst.setString(count++, flightBean.getFlightname());
					pst.setInt(count++,flightBean.getSeatingcapacity());
					pst.setInt(count++, flightBean.getReservationcapacity());
					
					if(pst.executeUpdate()>0)
					{
			
						return flightid;
					}
				}
			 catch (SQLException e) {
				System.out.println("error registering"+e);
				e.printStackTrace();
			}
			
			return "error";
			
		
		}
		/**
		 * @return ArrayList
		 */
		public ArrayList<FlightBean> findAll()
		{
			ArrayList<FlightBean> flightList = new ArrayList<FlightBean>();
			
			try {
				PreparedStatement pst = con.prepareStatement("select * from frs_tbl_flight");
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					FlightBean flight= new FlightBean();
					flight.setFlightid(rs.getString("flightid"));
					flight.setFlightname(rs.getString("flightname"));
					flight.setSeatingcapacity(rs.getInt("seatingcapacity"));
					flight.setReservationcapacity(rs.getInt("reservationcapacity"));
					flightList.add(flight);
					
				}return flightList;
			} catch (Exception e) {
				System.out.println("in catch of view all");
				e.printStackTrace();
				return null;
			}
			}
		/**
		 * @param flightid fid
		 * @return flight
		 */
		public FlightBean viewByFlightID(String flightid) {
	
			FlightBean flight1 = new FlightBean();
			try {
				
				PreparedStatement pst = con.prepareStatement("select * from frs_tbl_flight where flightid=?");
				pst.setString(1,flightid);
				ResultSet rs = pst.executeQuery();
				
				while (rs.next()) {
					flight1.setFlightid(rs.getString("flightid"));
					flight1.setFlightname(rs.getString("flightname"));
					flight1. setSeatingcapacity(rs.getInt("seatingcapacity"));
					flight1.setReservationcapacity(rs.getInt("reservationcapacity"));
			
					


			}return flight1;
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			}

			
		}

	/**
	 * @param flightBean fb
	 * @return boolean
	 */
		public boolean updateFlight(FlightBean flightBean) {
			// TODO Auto-generated method stub
			
			try {
				System.out.println("in the update method");
				PreparedStatement pst=con.prepareStatement("Update frs_tbl_flight set flightname=?,seatingcapacity=?,reservationcapacity=? where flightid=?");
					System.out.println("afte query");
					int count=1;
					pst.setString(count++, flightBean.getFlightname());
					pst.setInt(count++, flightBean.getSeatingcapacity());
					pst.setInt(count++, flightBean.getReservationcapacity());
					pst.setString(count++, flightBean.getFlightid());
				
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

		/**
		 * @param flightid fid
		 * @return delflight
		 */
		@Override
		public int deleteFlight(ArrayList<String> flightid) {
			// TODO Auto-generated method stub
			System.out.println("inside delete func");
			
			
			try
			{
				Iterator it=flightid.iterator();
			  while(it.hasNext())
				{
					String s1=(String)it.next();
					PreparedStatement pst=con.prepareStatement("delete from frs_tbl_schedule where flightid=?");
					pst.setString(1,s1);
					pst.executeUpdate();
				System.out.println("inside try delete");
				 pst=con.prepareStatement("delete from frs_tbl_flight where flightid=?");
				pst.setString(1,s1);
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
	
	
	
	
	
	

