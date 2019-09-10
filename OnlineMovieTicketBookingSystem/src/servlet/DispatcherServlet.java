package servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Movie;
import service.Action;
import service.MovieService2;
import utils.ValuesUtils;
import utils.XMLUtils;

/**
 * Servlet implementation class Dispatcher
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	public void init() {
		XMLUtils.init();
	}
	
    public DispatcherServlet() {
        super();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get uri from request
		String uri = request.getRequestURI();
		//Movie!insertMovie.do
		String actionName = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("."));
		String methodName =null;
		if (actionName.indexOf("!")>0) {
			methodName = actionName.substring(actionName.lastIndexOf("!")+1);
			actionName = actionName.substring(0, actionName.lastIndexOf("!"));
		}
		System.out.println(actionName);
		String forward = "index.jsp"; 
		try {
			String beanClassName = XMLUtils.getBeanClassName(actionName);
			System.out.println(beanClassName);
			Class beanClass = Class.forName(beanClassName);
			
			String actionClassName = XMLUtils.getActionClassName(actionName);
			System.out.println(actionClassName);
			Class actionClass = Class.forName(actionClassName);
			//get object from input
			Object movie = ValuesUtils.setValues(request, beanClass);
			System.out.println(movie);
			Action action = (Action) actionClass.getDeclaredConstructor().newInstance();
			Method method = actionClass.getMethod(methodName, Object.class);
			method.invoke(action, movie);
			//action.insertMovie(movie);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(forward).forward(request, response);
	}

}
