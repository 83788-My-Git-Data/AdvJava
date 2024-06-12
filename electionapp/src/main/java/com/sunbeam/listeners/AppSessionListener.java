package com.sunbeam.listeners;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.apache.catalina.User;

public class AppSessionListener  implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
			System.out.println("New HttpSession Started");
		}
		// event: Session stop
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
			HttpSession session = se.getSession();
			User user = (User) session.getAttribute("curuser");
			System.out.println("HttpSession Stopped -- " + user.getFirstName());
		}
}
