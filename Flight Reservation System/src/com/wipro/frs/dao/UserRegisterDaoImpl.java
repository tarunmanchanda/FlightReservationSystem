package com.wipro.frs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;


import com.wipro.frs.bean.CreditCardBean;
import com.wipro.frs.bean.ProfileBean;

import com.wipro.frs.util.DBUtil;
import com.wipro.frs.util.DBUtilImpl;
import com.wipro.frs.util.User;
import com.wipro.frs.util.UserImpl;

public class UserRegisterDaoImpl implements UserRegisterDao {



	/**
	 * 
	 * 
	 * @return 
	 */
	
	@Override
	public String createUser(ProfileBean profileBean)
	{
		
		User user=new UserImpl();
		String userid=user.register(profileBean);
		try {
			int count=1;
			DBUtil dbutil=new DBUtilImpl();
			Connection con=dbutil.getConnection("type4");
			PreparedStatement pst=con.prepareStatement("insert into frs_tbl_user_credentials values(?,?,'C',0)");
			pst.setString(count++, userid);
			pst.setString(count++, profileBean.getPassword());
			if(pst.executeUpdate()>0)
			{
				int countt=1;
				pst=con.prepareStatement("insert into frs_tbl_user_profile values(?,?,?,?,?,?,?,?,?,?,?,?)");
				pst.setString(countt++, userid);
				pst.setString(countt++, profileBean.getFirstname());
				pst.setString(countt++, profileBean.getLastname());
				pst.setDate(countt++, profileBean.getDateofbirth());
				pst.setString(countt++, profileBean.getGender());
				pst.setString(countt++, profileBean.getStreet());
				pst.setString(countt++, profileBean.getLocation());
				pst.setString(countt++, profileBean.getCity());
				pst.setString(countt++, profileBean.getState());
				pst.setString(countt++, profileBean.getPincode());
				pst.setString(countt++, profileBean.getMobilenumber());
				pst.setString(countt++, profileBean.getEmailid());
				if(pst.executeUpdate()>0)
				{
					return userid;
				}
			}
		} catch (SQLException e) {
			System.out.println("error registering"+e);
			e.printStackTrace();
		}
		
		return "error";
	}
	@Override
	public String addCreditCard(CreditCardBean creditcardBean) {
		// TODO Auto-generated method stub
		//User user=new UserImpl();
		//String userid=user.register(profileBean);
		try {
			    int count=1;
			     DBUtil dbutil=new DBUtilImpl();
			     Connection con=dbutil.getConnection("type4");
				PreparedStatement pst=con.prepareStatement("insert into frs_tbl_creditcard values(?,?,?,?,?)");
				pst.setString(count++, creditcardBean.getCreditcardnumber());
				pst.setString(count++, creditcardBean.getValidfrom());
				pst.setString(count++, creditcardBean.getValidto());
				pst.setDouble(count++, creditcardBean.getCreditbalance());
				pst.setString(count++, creditcardBean.getUserid());
					if(pst.executeUpdate()>0)
					{
					return "creditdetailsuccess";
			}
					
			} catch (SQLException e) {
			System.out.println("error addind card"+e);
			e.printStackTrace();
		}
		
		return "creditcarddetailfail";
	}
}
		
		
		

