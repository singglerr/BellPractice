package ru.bellintegrator.singglerr.practice.dao.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.singglerr.practice.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Organization> loadListBy(String name, String inn, Boolean isActive) {
        CriteriaQuery<Organization> criteriaQuery = buildCriteriaBy(name, inn, isActive);
        TypedQuery<Organization> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public Organization loadById(Long id) {
        return em.find(Organization.class, id);
    }

    @Override
    public void save(Organization organization) {
        em.persist(organization);
    }

    @Override
    public void update(Long id, Organization newOrganization) {
        Organization organization = loadById(id);
        organization.setActive(newOrganization.getActive());
        organization.setAddress(newOrganization.getAddress());
        organization.setFullName(newOrganization.getFullName());
        organization.setInn(newOrganization.getInn());
        organization.setKpp(newOrganization.getKpp());
        organization.setName(newOrganization.getName());
        organization.setPhone(newOrganization.getPhone());
    }

    private CriteriaQuery<Organization> buildCriteriaBy(String name, String inn, Boolean isActive){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Organization> query = cb.createQuery(Organization.class);
        Root<Organization> org = query.from(Organization.class);
        query.select(org);
        Predicate mainPred = cb.like(cb.lower(org.get("name")), "%" + name.toLowerCase() + "%");
        if (inn != null && !inn.equals("")){
            mainPred = cb.and(mainPred, cb.equal(org.get("inn"), inn));
        }
        if (isActive != null){
            mainPred = cb.and(mainPred, cb.equal(org.get("isActive"), isActive));
        }
        query.where(mainPred);
        return query;
    }
}
