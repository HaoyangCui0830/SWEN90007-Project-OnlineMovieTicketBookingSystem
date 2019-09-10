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
	
	//�洢������Ϣ
	private static HashMap<String, ActionConfig> configMap = new HashMap<String, ActionConfig>();

	public static void init() {
		try {
			SAXReader reader =new SAXReader();
			//�ҵ�class�����xml�ļ�
			InputStream is = XMLUtils.class.getClassLoader().getResourceAsStream("controller.xml");
			Document doc = reader.read(is);
			//��ȡ���нڵ�
			List<Node> actions = doc.selectNodes("actions/action");
			for (Node node : actions) {
				Element element = (Element)node;
				//ȡ����������
				String action = element.attributeValue("action");
				String beanClassName = element.attributeValue("beanClassName");
				String actionClassName = element.attributeValue("actionClassName");
				//�洢��������
				ActionConfig actionConfig = new ActionConfig(action, actionClassName, beanClassName);
				configMap.put(action, actionConfig);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	/**
	 * @param action
	 * @return ȡ�÷�װ���ݶ���
	 * @throws Exception
	 */
	public static String getBeanClassName(String action) throws Exception {
		ActionConfig config = configMap.get(action);
		if (config==null) {
			throw new Exception("δ�ҵ�������Ϣ��"+action);
		}else {
			return config.getBeanClassName();
		}
	}
	
	
	public static String getActionClassName(String action) throws Exception {
		ActionConfig config = configMap.get(action);
		if (config==null) {
			throw new Exception("δ�ҵ�������Ϣ��"+action);
		}else {
			return config.getActionClassName();
		}
	}
	
//	public static String getAction(String action) throws Exception {
//		ActionConfig config = configMap.get(action);
//		if (config==null) {
//			throw new Exception("δ�ҵ�������Ϣ��"+action);
//		}else {
//			return config.getAction();
//		}
//	}
}
