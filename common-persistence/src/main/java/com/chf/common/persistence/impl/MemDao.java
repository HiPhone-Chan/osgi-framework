package com.chf.common.persistence.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.chf.common.core.persistence.AbstractDao;

public abstract class MemDao<T, I extends Serializable> implements AbstractDao<T, I> {

	protected Map<I, T> storeMap;

	public MemDao() {
		storeMap = new HashMap<>();
	}

	@Override
	public T get(I id) {
		return storeMap.get(id);
	}

	@Override
	public void add(T model) {
		update(model);
	}

	@Override
	public void delete(String id) {
		storeMap.remove(id);
	}

	@Override
	public Collection<T> getAll() {
		return new ArrayList<>(storeMap.values());
	}

}
