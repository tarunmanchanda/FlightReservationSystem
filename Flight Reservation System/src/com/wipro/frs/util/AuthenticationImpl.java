package com.wipro.frs.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.wipro.frs.bean.CredentialsBean;

public class AuthenticationImpl implements Authentication {
	private Connection con;
	private PreparedStatement  pst;
	private ResultSet rs;
	
	/**
	 * 
	 */
	public AuthenticationImpl()
	{
		DBUtil db= new DBUtilImpl();
		con=db.getConnection("type4");
	}
	

	@Override
	public boolean authenticate(CredentialsBean credentialsBean) {
		// TODO Auto-generated method stub
		Map<String,Object> session=ActionContext.getContext().getSession();
		String x=credentialsBean.getUserid();
		
	try{
		pst=con.prepareStatement("select password from frs_tbl_user_credentials where userid=?");
		pst.setString(1,x);
		
		rs=pst.executeQuery();
		if(rs.next())
			
		{	

			if(rs.getString("password").equals(credentialsBean.getPassword()))
			{
				session.put("userid", credentialsBean.getUserid());
				return true;
			}
			
			
			//if(rs.getInt("loginstatus")== 0)
			//	{
			//session.put("userid", credentialsBean.getUserid());
			//return  true;
			//}else
			//{
				//return false;
			//}
				
			
			
			else 
			{
				session.put("Invaliduser",0);
				return false;
			}
		}
		return false;
		
	}
		catch(Exception e)
		{
			//System.out.println("in catch of if");
			System.out.println(e);
			return false;
		}
		
		}


	@Override
	public String authorize(String userId) {
		// TODO Auto-generated method stub
		try
		{
		   pst=con.prepareStatement("select usertype from frs_tbl_user_credentials where userid=?");
		   pst.setString(1,userId);
		   rs=pst.executeQuery();
		   while(rs.next())
		   {
			   return rs.getString(1);
		   }
		   
		//   if(rs.getString(1) == null){
		//	   UserImpl.userPresent = 0;
		//   }
		   
		//   else{
		//	   UserImpl.userPresent = 1;
		//   }
		   
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e);
		}
		
		return null;
	}

	@Override
	public boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus) {
		// TODO Auto-generated method stub
		try{
			PreparedStatement psts=con.prepareStatement("Select LoginStatus from frs_tbl_user_credentials where userid= ?");
			psts.setString(1, credentialsBean.getUserid());
			ResultSet rst=psts.executeQuery();
			while(rst.next())
			{	
				int i=1;
				PreparedStatement pst=con.prepareStatement("Update frs_tbl_user_credentials set LOGINSTATUS= ? where userid=?");	
				pst.setInt(i++,loginStatus);
				pst.setString(i++,credentialsBean.getUserid());
				if(loginStatus==1 && rst.getInt(1)==0)
				{
					pst.executeUpdate();
					return true;	
				}
				else if(loginStatus==0 && rst.getInt(1)==1) 
				{
					pst.executeUpdate();
					return true;	
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
}
