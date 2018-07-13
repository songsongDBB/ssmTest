package com.dss.ssm.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dss.ssm.entity.User;

public class LoginInterceptor implements HandlerInterceptor {

private List<String> allowPaths;
	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		
		String urlString = request.getRequestURI();
		
		if(urlString.matches(".*/((login/toLogin)|((login/goLogin))|(static)).*")){
			return true;
		}
		
		for(int i=0; i<this.allowPaths.size(); i++){
			if(urlString.endsWith(this.allowPaths.get(i))){
				return true;
			}
		}
		
		String contextPath=request.getContextPath();
		User user = (User) request.getSession().getAttribute("user");
		if(user == null){
            response.sendRedirect(contextPath + "/login/toLogin");  
            return false;
		}
		
		return true;
	}

	public void setAllowPaths(List<String> allowPaths) {
		this.allowPaths = allowPaths;
	}

}
