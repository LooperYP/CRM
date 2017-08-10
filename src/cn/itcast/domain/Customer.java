package cn.itcast.domain;

import java.util.Set;

public class Customer {
	private Long cust_id;
	private String cust_name;
	private String cust_phone;
	private String cust_mobile;
	//
	private String cust_filename;
	private String cust_filepath;
	//
	private BaseDict baseDictsource;
	private BaseDict baseDictindustry;
	private BaseDict baseDictlevel;
	//
	private Set<LinkMan> linkMans;
	
	public Set<LinkMan> getLinkMans() {
		return linkMans;
	}

	public void setLinkMans(Set<LinkMan> linkMans) {
		this.linkMans = linkMans;
	}

	public String getCust_filename() {
		return cust_filename;
	}

	public void setCust_filename(String cust_filename) {
		this.cust_filename = cust_filename;
	}

	public String getCust_filepath() {
		return cust_filepath;
	}

	public void setCust_filepath(String cust_filepath) {
		this.cust_filepath = cust_filepath;
	}

	public Long getCust_id() {
		return cust_id;
	}

	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public BaseDict getBaseDictsource() {
		return baseDictsource;
	}

	public void setBaseDictsource(BaseDict baseDictsource) {
		this.baseDictsource = baseDictsource;
	}

	public BaseDict getBaseDictindustry() {
		return baseDictindustry;
	}

	public void setBaseDictindustry(BaseDict baseDictindustry) {
		this.baseDictindustry = baseDictindustry;
	}

	public BaseDict getBaseDictlevel() {
		return baseDictlevel;
	}

	public void setBaseDictlevel(BaseDict baseDictlevel) {
		this.baseDictlevel = baseDictlevel;
	}

	public String getCust_phone() {
		return cust_phone;
	}

	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}

	public String getCust_mobile() {
		return cust_mobile;
	}

	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}

}
