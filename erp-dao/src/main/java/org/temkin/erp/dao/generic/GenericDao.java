package org.temkin.erp.dao.generic;

import java.io.Serializable;

public interface GenericDao<K extends Serializable,E> {
	void persist(E entity);
	public E getByPrimaryKey(K id);
	void delete(E entity);
}
