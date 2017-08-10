package cn.itcast.dao.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import cn.itcast.dao.UserDAO;
import cn.itcast.domain.User;

@SuppressWarnings("unchecked")
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {

	@Override
	public User findByCodeAndPassword(String user_code, String user_password) {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("user_code", user_code));
		criteria.add(Restrictions.eq("user_password", user_password));
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(criteria);
		return list.isEmpty()?null:list.get(0);
	}

}
