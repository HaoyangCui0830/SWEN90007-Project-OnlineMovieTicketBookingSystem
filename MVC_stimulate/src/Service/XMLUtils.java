package Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class XMLUtils {
	
	//存储配置信息
	private static HashMap<String, ActionConfig> configMap = new HashMap<String, ActionConfig>();

	public static void init() {
		try {
			SAXReader reader =new SAXReader();
			//找到class里面的xml文件
			InputStream is = XMLUtils.class.getClassLoader().getResourceAsStream("controller.xml");
			Document doc = reader.read(is);
			//读取所有节点
			List<Node> actions = doc.selectNodes("actions/action");
			for (Node node : actions) {
				Element element = (Element)node;
				//取得所有属性
				String action = element.attributeValue("action");
				String beanClassName = element.attributeValue("beanClassName");
				String actionClassName = element.attributeValue("actionClassName");
				//存储到配置中
				ActionConfig actionConfig = new ActionConfig(action, actionClassName, beanClassName);
				configMap.put(action, actionConfig);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	/**
	 * @param action
	 * @return 取得封装数据对象
	 * @throws Exception
	 */
	public static String getBeanClassName(String action) throws Exception {
		ActionConfig config = configMap.get(action);
		if (config==null) {
			throw new Exception("未找到配置信息："+action);
		}else {
			return config.getBeanClassName();
		}
	}
	
	
	public static String getActionClassName(String action) throws Exception {
		ActionConfig config = configMap.get(action);
		if (config==null) {
			throw new Exception("未找到配置信息："+action);
		}else {
			return config.getActionClassName();
		}
	}
	
//	public static String getAction(String action) throws Exception {
//		ActionConfig config = configMap.get(action);
//		if (config==null) {
//			throw new Exception("未找到配置信息："+action);
//		}else {
//			return config.getAction();
//		}
//	}
}
