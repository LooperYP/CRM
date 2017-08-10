package cn.itcast.page;

import java.util.List;
import java.util.Map;
@SuppressWarnings("unused")
public class Pagination<T> {
	//´«²Î
	private int page = 1;
	private int pageSize = 2;

	//²éÑ¯
	private Long totalCount;
	private Long totalPage;
	private List<T> resultList;
	private Map<String, String[]> parameterMap;
	//
	
	private int firstResult;
	private int maxResults;
	
	public Map<String, String[]> getParameterMap() {
		return parameterMap;
	}

	public void setParameterMap(Map<String, String[]> parameterMap) {
		this.parameterMap = parameterMap;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
		totalPage = (totalCount+pageSize-1)/pageSize;
		System.out.println(totalPage);
	}

	public int getFirstResult() {
		return (getPage()-1)*getPageSize();
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public int getMaxResults() {
		return getPageSize();
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

}
