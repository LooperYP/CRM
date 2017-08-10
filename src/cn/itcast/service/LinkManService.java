package cn.itcast.service;

import cn.itcast.domain.LinkMan;
import cn.itcast.page.Pagination;

public interface LinkManService {

	public void saveLinkMan(LinkMan linkMan);

	public void findLinkManPageList(Pagination<LinkMan> pagination);

	public LinkMan findLinkManById(Long lkm_id);

	public void updateLinkMan(LinkMan linkMan);

	public void deleteLinkMan(LinkMan linkMan);

}
