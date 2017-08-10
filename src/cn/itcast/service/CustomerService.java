package cn.itcast.service;

import java.io.Serializable;
import java.util.List;
import cn.itcast.domain.Customer;
import cn.itcast.page.Pagination;

public interface CustomerService {

/*	public void saveCustomer(Customer customer);

	public void deleteCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public Customer findCustomerById(Long id);

	public List<Customer> findCustomerAll();*/
	
	public void findCustomerPageList(Pagination<Customer> pagination);
	
	public void save(Customer t);

	public void delete(Customer t);
	
	public void update(Customer t);
	
	public Customer findById(Class<Customer> clazz, Serializable id);
	
	public List<Customer> findAll(Class<Customer> clazz);

}
