package com.chf.common.core.persistence;

import java.io.Serializable;
import java.util.Collection;

public interface AbstractDao<T, I extends Serializable> {

	T get(I id);

	void add(T model);

	void update(T model);

	void delete(String id);

	Collection<T> getAll();

}
