package org.temkin.erp.dao.hib.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.temkin.erp.dao.generic.GenericDao;

public class GenericHibernateDao<K extends Serializable, E> implements GenericDao<K, E> {

	private Class<E> entityClass;

	@Autowired
	protected SessionFactory sessionFactory;

	public GenericHibernateDao() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass
				.getActualTypeArguments()[1];
	}

	protected Session session() {
		return sessionFactory.getCurrentSession();
	}
	
	public void persist(E entity) {
		session().persist(entity);
	}

	public void delete(E entity) {
		session().delete(entity);
	}

	public E getByPrimaryKey(K id) {
		return (E)session().get(entityClass, id);
	}

}
