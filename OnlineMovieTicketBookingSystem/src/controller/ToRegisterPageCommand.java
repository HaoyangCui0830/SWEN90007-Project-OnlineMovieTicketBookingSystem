package controller;

import java.io.IOException;

import javax.servlet.ServletException;

public class ToRegisterPageCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		// TODO Auto-generated method stub
		forward("/jsp/Common/Register.jsp");
	}

}
