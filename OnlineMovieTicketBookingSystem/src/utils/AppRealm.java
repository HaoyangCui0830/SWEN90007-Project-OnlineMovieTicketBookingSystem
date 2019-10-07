package utils;
import domain.*;
import service.UserService;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class AppRealm extends JdbcRealm{
	
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException{
		UsernamePasswordToken userPassToken = (UsernamePasswordToken) token;
		final String username = userPassToken.getUsername();
		
		final User user = new UserService().getUserByUsername(username);
		if(user.getUsername() == null) {
			System.out.println("No account");
			return null;
		}
		
		return new SimpleAuthenticationInfo(user.getUserId(), user.getPassword(), getName());
		
	}
	
	protected AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
		Set<String> roles = new HashSet<String>();
		if(principals.isEmpty()) {
			System.out.println("principlas is empty");
			return null;
		}
		
		String username = (String) principals.getPrimaryPrincipal();
		final User user = new UserService().getUserByUsername(username);
		if(user.getUsername()==null) {
			System.out.println("no account for " + username);
		}
		
		if(user.getRole().equals("manager")) {
			roles.add(AppSession.MANAGER_ROLE);
		}else if (user.getRole().equals("customer")) {
			roles.add(AppSession.CUSTOMER_ROLE);
		}
		
		return new SimpleAuthorizationInfo(roles);
		
	}
	
	
	
}
