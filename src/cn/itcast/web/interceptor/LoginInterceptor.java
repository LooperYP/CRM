package cn.itcast.web.interceptor;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@SuppressWarnings("serial")
public class LoginInterceptor extends MethodFilterInterceptor{

	@SuppressWarnings("static-access")
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("LoginInterceptor....");
		if (ServletActionContext.getRequest().getSession().getAttribute("user")==null) {
			ActionSupport action = (ActionSupport) invocation.getAction();
			action.addActionError("Äú»¹Ã»ÓÐµÇÂ¼,ÇëµÇÂ¼!");
			
			return action.LOGIN;
		}
		return invocation.invoke();
	}
	
}
