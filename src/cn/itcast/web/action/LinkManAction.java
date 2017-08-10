package cn.itcast.web.action;

import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import cn.itcast.page.Pagination;
import cn.itcast.service.CustomerService;
import cn.itcast.service.LinkManService;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
	private LinkMan linkMan = new LinkMan();
	@Override
	public LinkMan getModel() {
		return linkMan;
	}
	private LinkManService linkManService;
	
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public String showAdd() {
		List<Customer> listCustomer = customerService.findAll(Customer.class);
		//ActionContext.getContext().getValueStack().set("list", listCustomer);
		ActionContext.getContext().put("list", listCustomer);
		return "showAdd";
	}

	public String save() {
		linkManService.saveLinkMan(linkMan);
		return "listAction";
	}
	
	private int page = 1;
	private int pageSize = 2;
	
	public void setPage(int page) {
		if (page<=0) {
			page = 1;
		}
		this.page = page;
	}

	public void setPageSize(int pageSize) {
		if (pageSize<=0) {
			pageSize = 2;
		}
		this.pageSize = pageSize;
	}
	
	public String delete() {
		linkManService.deleteLinkMan(linkMan);
		return "listAction";
	}
	
	public String edit() {
		linkManService.updateLinkMan(linkMan);
		return "listAction";
	}
	
	public String showEdit() {
		List<Customer> listCustomer = customerService.findAll(Customer.class);
		ActionContext.getContext().put("list", listCustomer);
		
		LinkMan findLinkMan = linkManService.findLinkManById(linkMan.getLkm_id());
		ActionContext.getContext().getValueStack().push(findLinkMan);
		return "showEdit";
	}

	public String findLinkManList() {
		Pagination<LinkMan> pagination = new Pagination<LinkMan>();
		pagination.setPage(page);
		pagination.setPageSize(pageSize);
		
		Map<String, String[]> parameterMap = ServletActionContext.getRequest().getParameterMap();
		pagination.setParameterMap(parameterMap);
		
		linkManService.findLinkManPageList(pagination);
		ActionContext.getContext().put("pagination", pagination);
		return "listjsp";
	}
	
}
