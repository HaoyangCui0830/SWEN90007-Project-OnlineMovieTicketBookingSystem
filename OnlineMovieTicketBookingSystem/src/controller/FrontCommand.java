package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class FrontCommand {

	protected ServletContext context;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	public void init(ServletContext context,HttpServletRequest request,
			HttpServletResponse response) {
		this.context = context;
		this.request = request;
		this.response = response;
	}
	
	abstract public void process() throws ServletException, IOException;
	
	protected void forward(String target) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = context.getRequestDispatcher(target);
		dispatcher.forward(request, response);
	}
}
