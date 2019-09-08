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
 * Servlet implementation class ManagerUpdateMovieServlet
 */
@WebServlet("/ManagerUpdateMovieServlet")
public class ManagerUpdateMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerUpdateMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		String movieName = request.getParameter("movieName");
		Time time = Time.valueOf(request.getParameter("movieLength"));
		Float moviePrice = Float.parseFloat(request.getParameter("moviePrice"));
		
		Movie movie = new Movie(movieId,movieName, time , moviePrice);
		MovieService movieService = new MovieService();
		movieService.updateMovie(movie);
		List<Movie> movies = new ArrayList<Movie>();
		movies = movieService.getAllMovies();
		request.setAttribute("movies", movies);
		request.getRequestDispatcher("index.jsp").forward(request, response);
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
