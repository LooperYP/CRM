package cn.itcast.service;

import cn.itcast.domain.SaleVisit;
import cn.itcast.page.Pagination;

public interface SaleVisitService {

	public void findSaleVisitPageList(Pagination<SaleVisit> pagination);

	public void save(SaleVisit saleVisit);
}
