package Service;


import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Time;
import java.util.Enumeration;

import javax.el.MethodNotFoundException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import entity.User;
import web.UserAction;

/**
 * Servlet implementation class UserServlet
 * 用户业务处理类
 */

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		//初始化加载配置
    	XMLUtils.init();
    }
	
    /**
     * Default constructor. 
     */
    public DispatcherServlet() {
        // TODO Auto-generated constructor stub
    }

    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String actionName = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		String forward = "index.jsp";
		try {
			//取得数据对象类名
			String beanClassName = XMLUtils.getBeanClassName(actionName);
			//加载类
			Class beanClass = Class.forName(beanClassName);
			Object object = Values.setValues(request, beanClass);	
			//取得业务对象类名
			String actionClassName = XMLUtils.getActionClassName(actionName);
			//加载类
			Class actionClass = Class.forName(actionClassName);
			Action action = (Action) actionClass.getDeclaredConstructor().newInstance();
			forward = action.execute(object);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
//			UserAction userAction = new UserAction();
//			forward = userAction.execute(request, response, object);

		//取得所有参数的名字
		
		
		request.getRequestDispatcher(forward).forward(request,response);
	}

}
