package com.UTPTd.interceptor;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@Component
public class LoginOrNotInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		//判断是否已经登录
		Map<String, Object> session = ActionContext.getContext().getSession();
		Object auditor = session.get("Auditor");
		Object highteacher = session.get("HighTeacher");
		Object technical = session.get("Technical");
		if (auditor != null) {
			return arg0.invoke();
		} else if (highteacher != null) {
			return arg0.invoke();
		} else if (technical != null) {
			return arg0.invoke();
		} else {
			return Action.LOGIN;
		}
	}

}
