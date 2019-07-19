/**
 * 
 */
package com.iuglans.repository;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iuglans.criteria.model.Actividade;

/**
 * @author arturo
 *
 */
@Repository
@Transactional
public class ActividadeRepositoryImpl implements ActividadeRepository{
	
	private static Logger logger = LoggerFactory.getLogger(ActividadeRepository.class); 
	@PersistenceContext
	EntityManager em;

	@Override
	public long insert(Actividade a) {
		logger.info("inserindo novo rexisto " + a.toString());
		return 0;
	}

	@Override
	public Optional<Actividade> find(long id) {
		logger.info("a procurar rexisto por id = {}", id);

		return null;
	}

	@Override
	public List<Actividade> findAll() {
		logger.info("a listar todos");
		try {
			Query acts = em.createNamedQuery("Actividade.todos", Actividade.class);
			return acts.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
