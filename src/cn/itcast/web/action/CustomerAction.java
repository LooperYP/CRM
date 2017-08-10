package cn.itcast.web.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

import cn.itcast.domain.BaseDict;
import cn.itcast.domain.Customer;
import cn.itcast.page.Pagination;
import cn.itcast.service.CustomerService;
import cn.itcast.utils.SystemConstant;
import cn.itcast.utils.UploadUtils;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

@SuppressWarnings({ "unused", "serial" })
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}

	private CustomerService customerService;
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	private File upLoad;
	private String upLoadContentType;
	private String upLoadFileName;
	
	public void setUpLoad(File upLoad) {
		this.upLoad = upLoad;
	}

	public void setUpLoadContentType(String upLoadContentType) {
		this.upLoadContentType = upLoadContentType;
	}

	public void setUpLoadFileName(String upLoadFileName) {
		this.upLoadFileName = upLoadFileName;
	}

	public String save() throws Exception{
		//1.0上传文件
		if (upLoad!=null) {
			String randonFileName = UploadUtils.generateRandonFileName(upLoadFileName);
			String randomDir = UploadUtils.generateRandomDir(randonFileName);
			
			String destFilePath = SystemConstant.FILE_UPLOAD_BASE_PATH + randomDir + "/" + randonFileName;
			FileUtils.copyFile(upLoad, new File(destFilePath));
			
			customer.setCust_filename(upLoadFileName);
			customer.setCust_filepath(randomDir + "/" + randonFileName);
		}
		
		//2.0保存数据
		customerService.save(customer);
		return "listAction";
	}
	
	public String delete(){
		//删除文件
		Customer findCustomer = customerService.findById(Customer.class,customer.getCust_id());
		String filepath = findCustomer.getCust_filepath();
		
		if (StringUtils.isNotBlank(filepath)) {
			String destFilePath = SystemConstant.FILE_UPLOAD_BASE_PATH + filepath;
			new File(destFilePath).delete();
		}
		
		//删除客户
		customerService.delete(findCustomer);
		return "listAction";
	}
	
	@InputConfig(resultName="editInput")
	public String edit() throws Exception{
		//更新文件
		if (upLoad!=null) {
			//旧的文件
			String oldfilepath = customer.getCust_filepath();
			String olddestFilePath = SystemConstant.FILE_UPLOAD_BASE_PATH + oldfilepath;
			
			//新的文件
			String randonFileName = UploadUtils.generateRandonFileName(upLoadFileName);
			String randomDir = UploadUtils.generateRandomDir(randonFileName);
			String destFilePath = SystemConstant.FILE_UPLOAD_BASE_PATH + randomDir + "/" + randonFileName;
			//生成新的文件
			FileUtils.copyFile(upLoad, new File(destFilePath));
			
			customer.setCust_filename(upLoadFileName);
			customer.setCust_filepath(randomDir + "/" + randonFileName);
			
			//删除旧的文件
			new File(olddestFilePath).delete();
		}
		
		//更新数据
		customerService.update(customer);
		return "listAction";
	}
	
	public String showEdit(){
		Customer findCustomer = customerService.findById(Customer.class,customer.getCust_id());
		ActionContext.getContext().getValueStack().push(findCustomer);
		return "showEdit";
	}
	
	public String showAdd(){
		return "showAdd";
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

	public String findCustomerList(){
		Pagination<Customer> pagination = new Pagination<Customer>();
		pagination.setPage(page);
		pagination.setPageSize(pageSize);
		
		Map<String, String[]> parameterMap = ServletActionContext.getRequest().getParameterMap();
		pagination.setParameterMap(parameterMap);
		
		customerService.findCustomerPageList(pagination);
		ActionContext.getContext().put("pagination", pagination);
		return "listjsp";
	}
	
	public String findAll() throws Exception {
		//查询
		List<Customer> customerList = customerService.findAll(Customer.class);
		//转换
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"linkMans","baseDictlevel","baseDictindustry","baseDictsource"});
		
		JSONArray jsonArray = JSONArray.fromObject(customerList,jsonConfig);
		//响应
		ServletActionContext.getResponse().setContentType("application/json;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().write(jsonArray.toString());
		return NONE;
	}
	
}