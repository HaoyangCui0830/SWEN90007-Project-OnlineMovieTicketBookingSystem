package controller;

import java.io.IOException;

import javax.servlet.ServletException;

public class LoginCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		forward("/jsp/Common/Login.jsp");
		//forward("/jsp/ManagerPages/ManagerHomePage.jsp");
	}

}
