package cn.itcast.dao.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import cn.itcast.dao.LinkManDAO;
import cn.itcast.domain.LinkMan;

@SuppressWarnings("unused")
public class LinkManDAOImpl extends BaseDAOImpl<LinkMan> implements LinkManDAO {

	/*@Override
	public Long findCount(DetachedCriteria criteria) {
		criteria.setProjection(Projections.rowCount());
		return (Long) getHibernateTemplate().findByCriteria(criteria).get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LinkMan> findPageList(DetachedCriteria criteria, int firstResult, int maxResults) {
		criteria.setProjection(null);
		return (List<LinkMan>) getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
	}*/

	/*public LinkMan findById(Long lkm_id) {
		return getHibernateTemplate().get(LinkMan.class, lkm_id);
	}

	public void update(LinkMan linkMan) {
		getHibernateTemplate().update(linkMan);
	}

	public void delete(LinkMan linkMan) {
		getHibernateTemplate().delete(linkMan);
	}
	
	public void save(LinkMan linkMan) {
		getHibernateTemplate().save(linkMan);
	}*/
}
