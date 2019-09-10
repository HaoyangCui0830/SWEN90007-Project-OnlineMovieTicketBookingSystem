package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import domain.Movie;
import service.MovieService;

public class CustomerHomeCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		forward("/jsp/CustomerPages/CustomerHomePage.jsp");
		
	}

}
