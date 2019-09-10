package Service;

public class ActionConfig {
	private String action;
	private String actionClassName;
	private String beanClassName;
	public ActionConfig(String action, String actionClassName, String beanClassName) {
		this.action = action;
		this.actionClassName = actionClassName;
		this.beanClassName = beanClassName;
	}
	public ActionConfig() {
		
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getActionClassName() {
		return actionClassName;
	}
	public void setActionClassName(String actionClassName) {
		this.actionClassName = actionClassName;
	}
	public String getBeanClassName() {
		return beanClassName;
	}
	public void setBeanClassName(String beanClassName) {
		this.beanClassName = beanClassName;
	}
	
	
}
