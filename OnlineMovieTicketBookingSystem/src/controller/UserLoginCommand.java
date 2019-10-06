package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import domain.Session;
import domain.User;
import service.UserService;

public class UserLoginCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		PrintWriter out = response.getWriter();
 		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserService userService = new UserService();
		User user = userService.getUserByUsername(username);
		if(user.getUsername()==null || !user.getPassword().equals(password)) {
			request.setAttribute("msg", "invalid username or password");
			request.getRequestDispatcher("/jsp/Common/Login.jsp").forward(request, response);
			return;
		}
 		if (user.getRole().equals("manager")) {
 			HttpSession httpSession = request.getSession();
 			httpSession.setAttribute("user", user);
 			httpSession.setMaxInactiveInterval(60*60*24);
			forward("/jsp/ManagerPages/ManagerHomePage.jsp");
		}else if (user.getRole().equals("customer")) {
			HttpSession httpSession = request.getSession();
 			httpSession.setAttribute("user", user);
 			httpSession.setMaxInactiveInterval(60*60*24);
			forward("/jsp/CustomerPages/CustomerHomePage.jsp");
		}
 		
	}

}