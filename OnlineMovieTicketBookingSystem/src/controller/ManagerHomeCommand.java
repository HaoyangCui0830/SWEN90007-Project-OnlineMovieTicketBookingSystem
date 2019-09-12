package controller;

import java.io.IOException;

import javax.servlet.ServletException;

public class ManagerHomeCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		// TODO Auto-generated method stub
		forward("/jsp/ManagerPages/ManagerHomePage.jsp");
	}

}
