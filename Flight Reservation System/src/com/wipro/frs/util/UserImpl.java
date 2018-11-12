package com.wipro.frs.util;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.wipro.frs.bean.CredentialsBean;
import com.wipro.frs.bean.ProfileBean;

public class UserImpl implements User{
	
	public static int userPresent = 0;
	public static final int loginstatus=1;
	public static final int logoutstatus=0;
	
	private PreparedStatement  pst;
	private ResultSet rs;
	private Authentication authenticate;
	private Map<String, Object> session;
	
	@Override
	public String login(CredentialsBean credentialsBean) 
	{
		// TODO Auto-generated method stub
		
		 authenticate=new AuthenticationImpl();
		
		if(authenticate.authenticate(credentialsBean))
		{
			System.out.println("authenticated");
			if(authenticate.changeLoginStatus(credentialsBean,loginstatus))
			{
				System.out.println("changed login status");
				return (authenticate.authorize(credentialsBean.getUserid()));
				}
			else
			{
				
				return "fail";
			}	
		}
		
		else
			{
				System.out.println("in else returnin");
				return "invalid";
			}
		

	}
	@Override
	public String changePassword(CredentialsBean credentialsBean,String newpassword) 
	{
		// TODO Auto-generated method stub
		DBUtil dbutilobj=new DBUtilImpl();
		Connection con=dbutilobj.getConnection("type4");

						try {
							int count=1;
							PreparedStatement pst=con.prepareStatement("Select userid,password from frs_tbl_user_credentials where userid=? AND password=?");
							pst.setString(count++, credentialsBean.getUserid());
							pst.setString(count++,credentialsBean.getPassword());
							if(pst.executeQuery().next())
							{
								int counttt=1;
								pst=con.prepareStatement("Update frs_tbl_user_credentials set password= ? where userid=?");
								pst.setString(counttt++,newpassword);
								pst.setString(counttt++,credentialsBean.getUserid());
								if(pst.executeUpdate()>0)
								{
									System.out.println("in if2");
									return "updatesuccess";
								}
								else
								{
									System.out.println("in else2");
									return "updatefail";
								}
							}
						}
						catch (SQLException e) {
							e.printStackTrace();
						}	
						finally
						{
						try {
							 con.close();
							} catch (Exception e2) 
							{
								e2.printStackTrace();
							}
						}
						
						System.out.println("outside");
					return "updateinvalid";
				}
	@Override 
	public boolean logout(String userId) 
	{
		// TODO Auto-generated method stub
		System.out.println("in logout");
		CredentialsBean credentialsBean=new CredentialsBean();
		 authenticate=new AuthenticationImpl();

		 credentialsBean.setUserid(userId);
		if(authenticate.changeLoginStatus(credentialsBean,logoutstatus))
		{
			System.out.println("in if log");
			session=ActionContext.getContext().getSession();
			session.clear();
			System.out.println("ho gya logout");
			return true;
		}
		return false;
	}
		
		
	@Override
	public String register(ProfileBean profileBean)
		{
		int d=1;
		DBUtil dbutilobj=new DBUtilImpl();
		Connection con=dbutilobj.getConnection("type4");
		try {
			pst=con.prepareStatement("select userIdseq.NEXTVAL from dual");
			rs=pst.executeQuery();
			System.out.println("before while");
			while(rs.next())
			{
			return (profileBean.getFirstname().substring(0,d+1).concat(rs.getString(1)));
			}
			} catch (SQLException e) {
						System.out.println("in catch");
						e.printStackTrace();
		}
		finally
		{
			try {
				
				con.close();
			} catch (Exception e2) 
			{
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
		
					System.out.println("after catch in register");
		return "fail";
	}


		}
	
	
	
	
	
	
	
	

