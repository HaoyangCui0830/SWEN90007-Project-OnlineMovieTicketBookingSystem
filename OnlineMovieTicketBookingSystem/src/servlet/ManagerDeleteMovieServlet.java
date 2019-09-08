package servlet;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Movie;
import service.MovieService;

/**
 * Servlet implementation class ManagerDeleteMovieServlet
 */
@WebServlet("/ManagerDeleteMovieServlet")
public class ManagerDeleteMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerDeleteMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		MovieService movieService = new MovieService();
		Movie movie=movieService.getMovieById(movieId);
		movieService.deleteMovie(movie);
		
		List<Movie> movies = new ArrayList<Movie>();
		movies = movieService.getAllMovies();
		request.setAttribute("movies", movies);
		request.getRequestDispatcher("index.jsp").forward(request, response);
//		Movie movie = new Movie(113, "The Sound of Music", Time.valueOf("01:30:00") , 10);
//		MovieService movieService = new MovieService();
//		movieService.deleteMovie(movie);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
