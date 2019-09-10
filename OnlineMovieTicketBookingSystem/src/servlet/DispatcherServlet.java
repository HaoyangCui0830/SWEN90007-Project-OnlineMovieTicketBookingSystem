package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Movie;
import service.MovieService2;
import utils.ValuesUtils;

/**
 * Servlet implementation class Dispatcher
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get uri from request
		String uri = request.getRequestURI();
		String actionName = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		String forward = "index.jsp"; 
		Movie movie = ValuesUtils.setValues(request, Movie.class);	
		MovieService2 movieService = new MovieService2();
		System.out.println(movie);
		//movieService.insertMovie(movie);
		
		//request.getRequestDispatcher("Success.jsp").forward(request, response);
	}

}
