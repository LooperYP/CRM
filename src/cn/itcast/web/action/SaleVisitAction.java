package cn.itcast.web.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import cn.itcast.domain.SaleVisit;
import cn.itcast.page.Pagination;
import cn.itcast.service.SaleVisitService;

@SuppressWarnings("serial")
public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {
	private SaleVisit saleVisit = new SaleVisit();

	@Override
	public SaleVisit getModel() {
		return saleVisit;
	}
	
	private int page = 1;
	private int pageSize = 10;
	
	public void setPage(int page) {
		this.page = page;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	private SaleVisitService saleVisitService;
	
	public void setSaleVisitService(SaleVisitService saleVisitService) {
		this.saleVisitService = saleVisitService;
	}

	public String save() {
		saleVisitService.save(saleVisit);
		return "listAction";
	}
	
	public String showAdd() {
		return "showAdd";
	}
	public String findSaleVisitList() {
		Pagination<SaleVisit> pagination = new Pagination<SaleVisit>();
		pagination.setPage(page);
		pagination.setPageSize(pageSize);
		
		Map<String, String[]> parameterMap = ServletActionContext.getRequest().getParameterMap();
		pagination.setParameterMap(parameterMap);
		
		saleVisitService.findSaleVisitPageList(pagination);
		ActionContext.getContext().put("pagination", pagination);
		return "listjsp";
	}
}
