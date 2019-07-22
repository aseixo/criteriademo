package com.iuglans.criteria;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.junit4.SpringRunner;

import com.iuglans.criteria.model.Actividade;
import com.iuglans.criteria.model.Corrupto;
import com.iuglans.repository.ActividadeRepository;
import com.iuglans.repository.CorruptoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CriteriaappApplicationTests {

	@PersistenceContext
	EntityManager em;

	@Autowired
	private CorruptoRepository corruptos;
	
	@Autowired (required= true)
	private ActividadeRepository actividadeRepository;
	
	Logger logger = LoggerFactory.getLogger(CriteriaappApplicationTests.class);

	/*
	 * @Test public void contextLoads() { }
	 * 
	 * @Test public void basicCriteriaTest() {
	 * 
	 * CriteriaBuilder cb = em.getCriteriaBuilder();
	 * 
	 * CriteriaQuery<Corrupto> cq = cb.createQuery(Corrupto.class); Root<Corrupto>
	 * corrupto = cq.from(Corrupto.class); //Predicate namePredicate =
	 * cb.equal(corrupto.get("nome"), "Ortega"); //Predicate partidoPredicate =
	 * cb.like(corrupto.get("partido"), "%BC%");
	 * 
	 * //cq.where(partidoPredicate); TypedQuery<Corrupto> query =
	 * em.createQuery(cq); List<Corrupto> corruptos = query.getResultList();
	 * for(Corrupto c: corruptos) { System.out.println(c.toString()); } assert(query
	 * != null); }
	 * 
	 * @Test public void likeCriteriaTest() {
	 * 
	 * CriteriaBuilder cb = em.getCriteriaBuilder();
	 * 
	 * CriteriaQuery<Corrupto> cq = cb.createQuery(Corrupto.class); Root<Corrupto>
	 * corrupto = cq.from(Corrupto.class); //Predicate namePredicate =
	 * cb.equal(corrupto.get("nome"), "Ortega"); Predicate partidoPredicate =
	 * cb.like(corrupto.get("partido"), "%B%");
	 * 
	 * cq.where(partidoPredicate); TypedQuery<Corrupto> query = em.createQuery(cq);
	 * List<Corrupto> corruptos = query.getResultList(); for(Corrupto c: corruptos)
	 * { System.out.println(c.toString()); } assert(query != null); }
	 */
	@Test
	@Ignore
	public void fromCriteriaTest() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Corrupto> cq = cb.createQuery(Corrupto.class);
		Root<Corrupto> from = cq.from(Corrupto.class);
		// Predicate namePredicate = cb.equal(corrupto.get("nome"), "Ortega");
		Predicate partidoPredicate = cb.like(from.get("partido"), "%B%");

		cq.where(partidoPredicate);
		cq.orderBy(cb.asc(from.get("nome")));
		TypedQuery<Corrupto> query = em.createQuery(cq);

		List<Corrupto> corruptos = query.getResultList();
		assert (query != null);
		logger.info("fromCriteria");

		for (Corrupto c : corruptos) {
			//assertNotNull(c);
			logger.info(c.toString());
		}
		
	}

	@Test
	@Ignore
	public void insertionEntityTest() {

		Long old = corruptos.count();
		Corrupto c = new Corrupto();
		c.setAsunto("Xenofobia, misoxinia, homofobia");
		c.setCondena(2L);
		// c.setCorruptoId(3000L);
		c.setNome("Andalucín");
		c.setPartido("BOX");
		corruptos.save(c);
		assert(corruptos.count() > old);
	}

	@Test
	@Ignore
	public void insertionCorruptoActividadesTest() {

		Long old = corruptos.count();
		Corrupto c = new Corrupto();
		c.setAsunto("xenofobia, odio, homofobia, fascismo, autoritarismo");
		c.setCondena(2L);
		c.setNome("Andalucín");
		c.setPartido("BOX");
		corruptos.save(c);
		assert (corruptos.count() > old);
	}

	
	@Test
	@Ignore
	public void findAllEntityTest() {

		List<Corrupto> corruptoList = corruptos.findAll();
		assertNotNull(corruptoList);
		assertTrue(corruptoList.size() > 0);
		logger.info("findAllEntityTest");
		for (Corrupto c : corruptoList) {
			logger.info(c.toString());
		}
	}
	
	@Test
	@Ignore
	public void findAllActividadesTest() {

		List<Actividade> actividades = actividadeRepository.findAll();
		assertNotNull(actividades);
		assertTrue(actividades.size() > 0);
		logger.info("findAllActividades");

		for (Actividade c : actividades) {
			logger.info(c.toString());
		}
	}

	@Test
	@Ignore
	public void tupleSelectTest() {

		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteria = builder.createTupleQuery();
		Root<Corrupto> corruptoRoot = criteria.from(Corrupto.class);
		criteria.select(builder.tuple(corruptoRoot.get("nome"), corruptoRoot.get("partido")));
		TypedQuery<Tuple> qr = em.createQuery(criteria);
		List<Tuple> lc = qr.getResultList();
		for (Tuple t : lc) {
			assertNotNull(t.get(0));
		}
	}
	
	@Test
	@Ignore
	public void corruptoSelectTest() {
		logger.info("corruptoSelectTest");
		String hql = "from Corrupto c";
		Query query = em.createQuery(hql);
		logger.info(query.getResultList().toString());
	}
	
	@Test
	@Ignore
	public void connectionPoolTest() {
		logger.info("test para DataSource");

		String url = "jdbc:mysql://localhost:3306/corrupciondb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";
		String user = "arturo";
		String pwd = "";
		String sqlQuery = "select * from corruptos";
		List<Corrupto> corruptos = new ArrayList<>();
//		HikariConfig config = new HikariConfig();
//		HikariDataSource ds;
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(pwd);
		assertNotNull(ds);
		try {
			Connection con = ds.getConnection();
			PreparedStatement pst = con.prepareStatement(sqlQuery);
			ResultSet rs = pst.executeQuery();
			Corrupto c;
			while (rs.next()) {
				logger.info(rs.getString("nome") + " " + rs.getString("partido"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void addCorrupto() {
		
		logger.info("add Corrupt info");
		Long old = corruptos.count();
		Optional<Actividade> a = actividadeRepository.findById(8L);
		List<Actividade> acts = new ArrayList<>();
		acts.add(a.get());
		Corrupto c = new Corrupto(101L, "Candianinha", "BeBé", "suborno a deputado provincial", 0L, acts);
		corruptos.save(c);
		logger.info(c.toString());
		assert(corruptos.count() > old);
		logger.info("finishing add Corrupt");
	}
}
