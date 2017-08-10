package cn.itcast.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import cn.itcast.dao.CustomerDAO;
import cn.itcast.domain.Customer;
import cn.itcast.page.Pagination;
import cn.itcast.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDAO customerDAO;
	
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	
	@Override
	public void findCustomerPageList(Pagination<Customer> pagination) {
		//Ìõ¼þ
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		Map<String, String[]> parameterMap = pagination.getParameterMap();
		
		String cust_name = parameterMap.get("cust_name")==null?"":parameterMap.get("cust_name")[0];
		String cust_mobile = parameterMap.get("cust_mobile")==null?"":parameterMap.get("cust_mobile")[0];
		if (StringUtils.isNotBlank(cust_name)) {
			criteria.add(Restrictions.like("cust_name", cust_name, MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotBlank(cust_mobile)) {
			criteria.add(Restrictions.eq("cust_mobile", cust_mobile));
		}
		
		//²éÑ¯
		long totalCount = customerDAO.findCountByCriteria(criteria);
		pagination.setTotalCount(totalCount);
		List<Customer> resultList = customerDAO.findByCriteria(criteria, pagination.getFirstResult()
				, pagination.getMaxResults());
		pagination.setResultList(resultList);
	}


	/*@Override
	public void saveCustomer(Customer customer) {
		customerDAO.save(customer);
	}
	
	@Override
	public void deleteCustomer(Customer customer) {
		customerDAO.delete(customer);
	}

	@Override
	public Customer findCustomerById(Long id) {
		return customerDAO.findById(Customer.class,id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDAO.update(customer);
	}

	@Override
	public List<Customer> findCustomerAll() {
		return customerDAO.findAll(Customer.class);
	}*/
	
	@Override
	public void save(Customer t) {
		customerDAO.save(t);
		
	}

	@Override
	public void delete(Customer t) {
		customerDAO.delete(t);
		
	}

	@Override
	public void update(Customer t) {
		customerDAO.update(t);
	}

	@Override
	public Customer findById(Class<Customer> clazz,Serializable id) {
		return customerDAO.findById(clazz,id);
	}

	@Override
	public List<Customer> findAll(Class<Customer> clazz) {
		return customerDAO.findAll(clazz);
	}
}
