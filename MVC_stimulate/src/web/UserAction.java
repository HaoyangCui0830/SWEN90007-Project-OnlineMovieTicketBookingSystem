package web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Action;
import entity.User;

public class UserAction implements Action{
	
	public String execute(Object object) {
		System.out.println(object);
		return "Success.jsp";
	}
}
