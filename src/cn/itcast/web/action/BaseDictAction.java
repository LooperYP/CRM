package cn.itcast.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import cn.itcast.domain.BaseDict;
import cn.itcast.service.BaseDictService;
import net.sf.json.JSONArray;


public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {
	private BaseDict baseDict = new BaseDict();
	@Override
	public BaseDict getModel() {
		return baseDict;
	}

	private BaseDictService baseDictService;
	
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}

	public String listByTypeCode() throws Exception {
		List<BaseDict> list = baseDictService.findBaseDictByTypeCode(baseDict.getDict_type_code());
		JSONArray jsonArray = JSONArray.fromObject(list);
		
		System.out.println(baseDict.getDict_type_code());
		
		ServletActionContext.getResponse().setContentType("application/json;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().write(jsonArray.toString());
		return NONE;
	}
}
