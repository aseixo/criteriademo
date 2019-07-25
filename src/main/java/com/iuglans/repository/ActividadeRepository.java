/**
 * 
 */
package com.iuglans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iuglans.criteria.model.Actividade;

@Repository
@Transactional
public interface ActividadeRepository extends JpaRepository<Actividade, Long>{

//	public long insert(Actividade a);
//	public Optional<Actividade> find(long id);
//	public List<Actividade> findAll();
}
