package com.iuglans.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iuglans.criteria.model.Corrupto;
import com.iuglans.loggerutils.LoggerMarker;

@Repository
@Transactional
public class CorruptoRepositoryImpl implements CorruptoRepository {
	
	private static Logger logger = LoggerFactory.getLogger(CorruptoRepository.class); 
	@PersistenceContext
	EntityManager em;

	@Override
	public long insert(Corrupto c) {
	
		logger.info(/*LoggerMarker.persitanceMarker,*/ "A persistir información na BD");
		em.persist(c);
		//em.merge(c);
		return c.getCorruptoId();
	}

	@Override
	public Corrupto find(long id) {
		logger.info("A pesquisar información na BD");
		return em.find(Corrupto.class, id);
	}

	@Override
	public List<Corrupto> findAll() {
		logger.info("Lista completa de itens");
		Query query = em.createNamedQuery("Corrupto.todosPorPartido", Corrupto.class);
		return query.getResultList();
	}

}
