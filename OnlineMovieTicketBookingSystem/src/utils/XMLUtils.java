package utils;


import java.io.FileReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import service.ActionConfig;

public class XMLUtils {

		//store 
		private static HashMap<String, ActionConfig> configMap = new HashMap<String, ActionConfig>();
		
		public static void init() {
			try {
				SAXReader reader = new SAXReader();
				InputStream is = XMLUtils.class.getClassLoader().getResourceAsStream("frontController.xml");
				Document doc = reader.read(is);
				List<Node> actions = doc.selectNodes("actions/action");
				for (Node node : actions) {
					Element element = (Element)node;
					//取得所有属性
					String action = element.attributeValue("action");
					String beanClassName = element.attributeValue("beanClassName");
					String actionClassName = element.attributeValue("actionClassName");
					//存储到配置中
					ActionConfig actionConfig = new ActionConfig(action, beanClassName, actionClassName);
					configMap.put(action, actionConfig);
				}
			} catch (Exception e) {
				System.out.println("can not find the configuration file");
			}
			
			
		}

		public static String getBeanClassName(String action) throws Exception {
			ActionConfig config = configMap.get(action);
			if (config ==null) {
				throw new Exception("can not find "+ action+ "'s configuration");
			} else {
				return config.getBeanClassName();
			}
		}

		public static String getActionClassName(String action) throws Exception {
			ActionConfig config = configMap.get(action);
			if (config ==null) {
				throw new Exception("can not find "+ action+ "'s configuration");
			} else {
				return config.getActionClassName();
			}
		}

}
