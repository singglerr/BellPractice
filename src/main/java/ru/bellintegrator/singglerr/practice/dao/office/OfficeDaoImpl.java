package ru.bellintegrator.singglerr.practice.dao.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.singglerr.practice.model.Office;
import ru.bellintegrator.singglerr.practice.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Office> loadListBy(Organization org, String name, String phone, Boolean isActive) {
        CriteriaQuery<Office> criteriaQuery = buildCriteriaBy(org, name, phone, isActive);
        TypedQuery<Office> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Office loadById(Long id) {
        return em.find(Office.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Office office) {
        em.persist(office);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Long id, Office office) {
        Office renewableOffice = loadById(id);
        renewableOffice.setName(office.getName());
        renewableOffice.setAddress(office.getAddress());
        renewableOffice.setPhone(office.getPhone());
        renewableOffice.setActive(office.isActive());
    }

    private CriteriaQuery<Office> buildCriteriaBy(Organization org, String name, String phone, Boolean isActive){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Office> query = builder.createQuery(Office.class);
        Root<Office> office = query.from(Office.class);
        query.select(office);
        Predicate mainPredicate = builder.equal(office.get("organization"), org);
        if (name != null && !name.equals("")){
            Predicate officeNameLikeName = builder.like(builder.lower(office.get("name")), "%" + name.toLowerCase() + "%");
            mainPredicate = builder.and(mainPredicate, officeNameLikeName);
        }
        if (phone != null && !phone.equals("")){
            Predicate officePhoneLikePhone = builder.like(office.get("phone"), "%" + phone + "%");
            mainPredicate = builder.and(mainPredicate, officePhoneLikePhone);
        }
        if (isActive != null) {
            Predicate officeIsActive = builder.equal(office.get("isActive"), isActive);
            mainPredicate = builder.and(mainPredicate, officeIsActive);
        }
        query.where(mainPredicate);
        return query;
    }
}
