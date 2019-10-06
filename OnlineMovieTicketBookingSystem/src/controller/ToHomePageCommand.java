package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import domain.Movie;
import service.MovieService;

public class ToHomePageCommand extends FrontCommand{

	/**
	 * Jump to the root home page
	 * */
	@Override
	public void process() throws ServletException, IOException {
		// TODO Auto-generated method stub
		forward("/index.jsp");
		
	}

}
