/**
 * 
 */
package com.iuglans.repository;

import java.util.List;
import java.util.Optional;

import com.iuglans.criteria.model.Actividade;

/**
 * @author arturo
 *
 */
public interface ActividadeRepository {

	public long insert(Actividade a);
	public Optional<Actividade> find(long id);
	public List<Actividade> findAll();
}
