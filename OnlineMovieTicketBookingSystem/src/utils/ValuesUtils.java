package utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Time;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class ValuesUtils {

		public static <T> T setValues(HttpServletRequest request, Class cls) {
			Object object = null;
			try {
				object = cls.getDeclaredConstructor().newInstance();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			Enumeration<String> paramNames = request.getParameterNames();
			while (paramNames.hasMoreElements()) {
				String paramName = paramNames.nextElement();
				String paramValue = request.getParameter(paramName);
				//combine them as a method name
				String methodName = "set"+paramName.substring(0,1).toUpperCase()+paramName.substring(1);
				try {
					Class paramType = cls.getDeclaredField(paramName).getType();
					Object value = null;
					if (paramType==String.class) {
						value =paramValue;
					}else if(paramType == int.class || paramType == Integer.class){
				    	value = Integer.parseInt(paramValue);
				    }else if(paramType == Time.class){
				    	value = Time.valueOf(paramValue);
				    }else if (paramType == float.class || paramType == Float.class) {
						value = Float.parseFloat(paramValue);
					}
					Method method = cls.getMethod(methodName, paramType);
					method.invoke(object, value);	
				} catch (NoSuchFieldException e) {
					System.out.println("NoSuchFieldException");
					e.printStackTrace();
				} catch (SecurityException e) {
					System.out.println("SecurityException");
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					System.out.println("NoSuchMethodException");
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}
			return (T) object;
		}
}
