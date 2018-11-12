package com.wipro.frs.dao;
import java.util.ArrayList;

import com.wipro.frs.bean.RouteBean;
public interface RouteDAO {
/**
 * 
 * @param routeBean rb
 * @return String
 */
		 String registerRoute(RouteBean routeBean);
		 /**
		  * 
		  * @param routeBean rb
		  * @return String
		  */
		String addRoute(RouteBean routeBean);
		/**
		 * 
		 * @return ArrayList
		 */
		ArrayList<RouteBean>viewByAllRoute();
		/**
		 * 
		 * @param routeid ri
		 * @return RouteBean
		 */
		 RouteBean viewByRouteId(String routeid);
		 /**
		  * 
		  * @param routeBean rb
		  * @return boolean
 		  */
		boolean updateRoute(RouteBean routeBean);
		/**
		 * 
		 * @param routeid rd
		 * @return int
		 */
		int deleteRoute(ArrayList<String> routeid);
	}


