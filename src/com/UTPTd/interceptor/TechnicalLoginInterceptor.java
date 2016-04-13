package com.UTPTd.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TechnicalLoginInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Object auditor = session.get("Auditor");
		Object highteacher = session.get("HighTeacher");
		Object technical = session.get("Technical");
		if (technical != null) {
			if (auditor != null) {
				session.remove("Auditor");
			}
			if (highteacher != null) {
				session.remove("HighTeacher");
			}
			return arg0.invoke();
		} else {
			return Action.LOGIN;
		}
	}

}
