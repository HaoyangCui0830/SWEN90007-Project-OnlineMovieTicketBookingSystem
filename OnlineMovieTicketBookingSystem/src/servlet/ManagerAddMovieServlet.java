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
 * Servlet implementation class ManagerAddMovieServlet
 */
@WebServlet("/ManagerAddMovieServlet")
public class ManagerAddMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerAddMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String movieName = request.getParameter("movieName");
		String movieLength = request.getParameter("movieLength");
		Time time = Time.valueOf(movieLength);
		String moviePrice = request.getParameter("moviePrice");
		Float moviePrice2 = Float.parseFloat(moviePrice);
		
		System.out.println(movieName);
		System.out.println(time);
		System.out.println(moviePrice2);
		Movie movie = new Movie(movieName, time, moviePrice2);
////		Movie movie = new Movie(114, "'The Death of Superman'", Time.valueOf("01:45:00") , Float.valueOf(20));
		MovieService movieService = new MovieService();
		movieService.insertMovie(movie);
		List<Movie> movies = new ArrayList<Movie>();
		movies = movieService.getAllMovies();
		request.setAttribute("movies", movies);
		request.getRequestDispatcher("index.jsp").forward(request, response);

		
//		Movie movie = new Movie(114, "'The Death of Superman'", Time.valueOf("01:45:00") , Float.valueOf(20));
//		MovieService movieService = new MovieService();
//		movieService.insertMovie(movie);
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
