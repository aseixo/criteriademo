package com.iuglans.repository;

import java.util.List;

import com.iuglans.criteria.model.Corrupto;

public interface CorruptoRepository {

	public long insert(Corrupto c);
	public Corrupto find(long id);
	public List<Corrupto> findAll();
}
