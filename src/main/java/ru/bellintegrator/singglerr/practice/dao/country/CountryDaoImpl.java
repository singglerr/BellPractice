package ru.bellintegrator.singglerr.practice.dao.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.singglerr.practice.model.Country;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class CountryDaoImpl implements CountryDao {

	private final EntityManager em;

	@Autowired
	public CountryDaoImpl(EntityManager em) {
		this.em = em;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Country> all() {
		TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c", Country.class);
		return query.getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Country loadByName(String name) {
		CriteriaQuery<Country> criteria = buildCriteriaBy("name", name);
		TypedQuery<Country> query = em.createQuery(criteria);
		return query.getSingleResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Country loadByCode(String code) {
		CriteriaQuery<Country> criteria = buildCriteriaBy("code", code);
		TypedQuery<Country> query = em.createQuery(criteria);
		return query.getSingleResult();
	}

	private <T> CriteriaQuery<Country> buildCriteriaBy(String paramName, T param) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Country> criteria = builder.createQuery(Country.class);

		Root<Country> person = criteria.from(Country.class);
		criteria.where(builder.equal(person.get(paramName), param));

		return criteria;
	}
}
