package service;

/**
 * @author jaxzhao
 * Configuration for action
 */
public class ActionConfig {
	
	private String action;
	private String beanClassName;
	private String actionClassName;
	public ActionConfig(String action, String beanClassName, String actionClassName) {
		super();
		this.action = action;
		this.beanClassName = beanClassName;
		this.actionClassName = actionClassName;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getBeanClassName() {
		return beanClassName;
	}
	public void setBeanClassName(String beanClassName) {
		this.beanClassName = beanClassName;
	}
	public String getActionClassName() {
		return actionClassName;
	}
	public void setActionClassName(String actionClassName) {
		this.actionClassName = actionClassName;
	}
	
	
	
	
}
