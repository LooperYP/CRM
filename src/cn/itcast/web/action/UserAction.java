package cn.itcast.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.Customer;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	
	public User getModel() {
		return user;
	}
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() {
		User loginUser = userService.findUser(user);
		if (loginUser==null) {
			addActionError("��������˻������������");
			return LOGIN;
		} else {
			ServletActionContext.getRequest().getSession().setAttribute("user", loginUser);
			return SUCCESS;
		}
	}
	
	public String findAll() throws Exception {
		//��ѯ
		List<User> userList = userService.findAll(User.class);
		//ת��
		JSONArray jsonArray = JSONArray.fromObject(userList);
		//��Ӧ
		ServletActionContext.getResponse().setContentType("application/json;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().write(jsonArray.toString());
		return NONE;
	}
	
}
