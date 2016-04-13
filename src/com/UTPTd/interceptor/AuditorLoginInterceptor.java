package com.UTPTd.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuditorLoginInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		//取HighTeacher和Technical中的值
		Map<String, Object> session = ActionContext.getContext().getSession();
		Object auditor = session.get("Auditor");
		Object highteacher = session.get("HighTeacher");
		Object technical = session.get("Technical");
		if (auditor != null) {
			if (highteacher != null) {
				session.remove("HighTeacher");
			}
			if (technical != null) {
				session.remove("Technical");
			}
			return arg0.invoke();
		} else {
			return Action.LOGIN;
		}
		
	}

}
