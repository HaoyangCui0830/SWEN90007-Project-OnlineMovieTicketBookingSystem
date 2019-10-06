package controller;

import java.io.IOException;

import javax.servlet.ServletException;

public class ManagerAddMovieCommand extends FrontCommand{

	/**
	 * Jump to add new Movie Page for manager to create new movie
	 * */
	@Override
	public void process() throws ServletException, IOException {
		forward("/jsp/ManagerPages/ManagerAddMovie.jsp");
	}

}
