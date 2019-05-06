package ru.bellintegrator.singglerr.practice.dao.doctype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.singglerr.practice.model.Country;
import ru.bellintegrator.singglerr.practice.model.DocType;

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
public class DocTypeDaoImpl implements DocTypeDao{

	private final EntityManager em;

	@Autowired
	public DocTypeDaoImpl(EntityManager em) {
		this.em = em;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<DocType> all() {
		TypedQuery<DocType> query = em.createQuery("SELECT d FROM DocType d", DocType.class);
		return query.getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DocType loadByCode(String code) {
		CriteriaQuery<DocType> criteria = buildCriteriaBy("code", code);
		TypedQuery<DocType> query = em.createQuery(criteria);
		return query.getSingleResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DocType loadByName(String name) {
		CriteriaQuery<DocType> criteria = buildCriteriaBy("name", name);
		TypedQuery<DocType> query = em.createQuery(criteria);
		return query.getSingleResult();
	}

	private <T> CriteriaQuery<DocType> buildCriteriaBy(String paramName, T param) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<DocType> criteria = builder.createQuery(DocType.class);

		Root<DocType> person = criteria.from(DocType.class);
		criteria.where(builder.equal(person.get(paramName), param));

		return criteria;
	}
}
