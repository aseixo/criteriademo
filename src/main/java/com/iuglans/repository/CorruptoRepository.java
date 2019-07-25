package com.iuglans.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iuglans.criteria.model.Corrupto;

public interface CorruptoRepository extends JpaRepository<Corrupto, Long> {

//	public long insert(Corrupto c);
//	public Corrupto find(long id);
//	public List<Corrupto> findAll();
}
