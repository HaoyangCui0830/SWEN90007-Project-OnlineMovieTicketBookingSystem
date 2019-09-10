package Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Time;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class Values {
	public static <T> T setValues(HttpServletRequest request, Class cls) {
		Object object = null;
		try {
			object = cls.getDeclaredConstructor().newInstance();
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			String paraValue = request.getParameter(paramName);
		//	System.out.println(paramName + "  " + paraValue);
			//组装方法名
			String methodName = "set"+paramName.substring(0,1).toUpperCase()+paramName.substring(1);
			//通过方法名和参数类型获得方法 n
			try {
				 Class paraType = cls.getDeclaredField(paramName).getType();
				 Object value = null;
				    if(paraType == String.class)
				    {
				    	value = paraValue;
				    }else if(paraType == int.class || paraType == Integer.class){
				    	value = Integer.parseInt(paraValue);
				    }else if(paraType == Time.class){
				    	value = Time.valueOf(paraValue);
				    }else if (paraType == float.class || paraType == Float.class) {
						value = Float.parseFloat(paraValue);
					}
				    Method method = cls.getMethod(methodName, paraType);
					method.invoke(object, value);
					
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
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
