package controller;

import java.io.IOException;

import javax.servlet.ServletException;

import domain.User;
import service.UserService;

public class RegisterCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		String username = request.getParameter("username");
		String password1 = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String role = "customer";
		
		if(!password1.equals(password2))
		{
			request.setAttribute("msg", "password is different");
			request.getRequestDispatcher("/jsp/Common/Register.jsp").forward(request, response);
			return;
		}
		
		UserService uService = new UserService();
		User user = uService.getUserByUsername(username);
		System.out.println(user);
		if (user.getUsername()!=null) {
			request.setAttribute("msg", "username has existed");
			request.getRequestDispatcher("/jsp/Common/Register.jsp").forward(request, response);
			return;
		}
		User newUser = new User(username, password1, role, firstName, lastName);
		uService.insertUser(newUser, request.getSession().getId());
		response.getWriter().write("Register successfully");
		request.getSession().setAttribute("user", newUser);
		//response.setHeader("refresh", "1;url="+request.getContextPath());
		forward("/jsp/CustomerPages/CustomerHomePage.jsp");
		
	}

}
