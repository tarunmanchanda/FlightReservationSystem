package com.wipro.frs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.wipro.frs.bean.CreditCardBean;
import com.wipro.frs.util.DBUtil;
import com.wipro.frs.util.DBUtilImpl;

public class CreditCardDAOImpl implements CreditCardDAO {

	@Override
	public boolean findByCardNumber(String userid, String creditcardnumber) {
		// TODO Auto-generated method stub
		
		int count=1;
		DBUtil dbutilobj=new DBUtilImpl();
		Connection con=dbutilobj.getConnection("type4");
		try
		{
			PreparedStatement pst=con.prepareStatement("select validfrom,validto from frs_tbl_creditcard where userid=? and creditcardnumber=?");
			pst.setString(count,userid);
			pst.setString(++count,creditcardnumber);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
	//		log.info(e.toString());
			return false;
		}
		
	}



	@Override
	public boolean updateCreditCardBalance(CreditCardBean creditcardBean) {
		// TODO Auto-generated method stub
		DBUtil dbutilobj=new DBUtilImpl();
		Connection con=dbutilobj.getConnection("type4");
		try
		{
			System.out.println("in try of credit card bal in cc impl");
			PreparedStatement pst=con.prepareStatement("select creditbalance from frs_tbl_creditcard where creditcardnumber=?");
			pst.setString(1,creditcardBean.getCreditcardnumber());
			ResultSet rs=pst.executeQuery();
			System.out.println("before if in cc bal in cc impl");
			if(rs.next())
			{
				int balance=rs.getInt(1);
				System.out.println("in if in cc in ccimpl");
				Map<String, Object> session=ActionContext.getContext().getSession();
				double billD=(Double)session.get("totalamount");
				int bill=(int)billD;
				if(balance>bill)
				{
					balance=balance-bill;
					try
					{
						int count=1;
						pst=con.prepareStatement("update frs_tbl_creditcard set creditbalance=? where creditcardnumber=?");
						pst.setInt(count,balance);
						pst.setString(++count,creditcardBean.getCreditcardnumber());
						pst.executeUpdate();
						
					}
					catch(Exception e)
					{
					//	log.info(e.toString());
					}
					return true;
				}
				else
				{
					return false;
				}
				
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
	//		log.info(e.toString());
			return false;
		}
	}

}
