package com.wipro.frs.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.wipro.frs.bean.CreditCardBean;
import com.wipro.frs.bean.PassengerBean;
import com.wipro.frs.bean.ReservationBean;
import com.wipro.frs.service.Customer;
import com.wipro.frs.service.CustomerImpl;
import com.wipro.frs.util.Payment;
import com.wipro.frs.util.PaymentImpl;

public class CustomerPayAmountAction implements ModelDriven{
	private CreditCardBean creditcardBean=new CreditCardBean();
	ReservationBean reservationBean=new ReservationBean();
	public CreditCardBean getCreditCardBean() {
		return creditcardBean;
	}
	public void setCreditCardBean(CreditCardBean creditcardBean) {
		this.creditcardBean = creditcardBean;
	}
	
	public String execute()
	{
		Map<String, Object> session=ActionContext.getContext().getSession();
		String userid=(String)session.get("userid");
		System.out.println("in execute of cust pay amount action");	
		Payment paymentobj=new PaymentImpl();
		boolean result=paymentobj.findByCardNumber(userid,creditcardBean.getCreditcardnumber());
		if(result)
		{
			System.out.println("inside if of cust pay amount action");	
			String resultingString=paymentobj.process(creditcardBean);
			if(("success").equals(resultingString))
			{	
				System.out.println("inside if 2 cust pay amount action");	
				Customer customer=new CustomerImpl();
				ArrayList<PassengerBean> passengers=(ArrayList<PassengerBean>) session.get("passengerlist");
				String returnString=customer.reserveTicket(new ReservationBean(),passengers);
				passengers=new ArrayList<PassengerBean>();
				System.out.println("before 3 if cust pay amount action");	
				if(returnString.equals("success"))
				{
				return "success";
				}
				else
				{
					return "error";
				}
			}
			else
			{
				return "error";
			}
		}
		else
		{
			return "errormismatching";
		}
	}
	
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return creditcardBean;
	}
	

}
