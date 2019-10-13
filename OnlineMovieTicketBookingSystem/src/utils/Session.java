package utils;


import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;

import domain.User;
import service.UserService;

public class Session {
	
	private static final String USER_ATTRIBUTE_NAME = "user";
	
	private HttpSession httpSession;
	
	private Session (HttpSession httpSession) {
		this.httpSession = httpSession;
	}
	
	public static Session refreshSession(HttpSession httpSession, String username, String password, HttpSession ipnuthttpSession) {
		UserService userService = new UserService();
		User user = userService.getUserByUsername(username);	
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		token.setRememberMe(true);
		org.apache.shiro.subject.Subject currentUser = SecurityUtils.getSubject();
		
		currentUser.login(token);
		
		if (user.getRole().equals("manager")) {
 			httpSession = ipnuthttpSession;
 			httpSession.setAttribute("user", user);
 			httpSession.setMaxInactiveInterval(60*60*1);
			
		}else if (user.getRole().equals("customer")) {
			httpSession = ipnuthttpSession;
 			httpSession.setAttribute("user", user);
 			httpSession.setMaxInactiveInterval(60*60*1);
			
		}
		return new Session(httpSession);
		
	}
	
	public User getUser() {
		return (User)httpSession.getAttribute(USER_ATTRIBUTE_NAME);
	}

}