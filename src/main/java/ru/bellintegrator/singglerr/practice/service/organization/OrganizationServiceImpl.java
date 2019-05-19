package ru.bellintegrator.singglerr.practice.service.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.singglerr.practice.dao.organization.OrganizationDao;
import ru.bellintegrator.singglerr.practice.model.Organization;
import ru.bellintegrator.singglerr.practice.model.mapper.MapperFacade;
import ru.bellintegrator.singglerr.practice.view.OrganizationView;
import ru.bellintegrator.singglerr.practice.view.ResultView;
import ru.bellintegrator.singglerr.practice.view.SimpleOrganizationView;
import ru.bellintegrator.singglerr.practice.view.filter.OrganizationFilterView;

import javax.validation.Valid;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationDao dao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<SimpleOrganizationView> organizationsByFilter(@Valid OrganizationFilterView organizationFilter) {
        List<Organization> organizations = dao.loadListBy(organizationFilter.getName(), organizationFilter.getInn(), organizationFilter.isActive());
        return mapperFacade.mapAsList(organizations, SimpleOrganizationView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public OrganizationView organizationById(Long id) {
        Organization organization = dao.loadById(id);
        return mapperFacade.map(organization, OrganizationView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ResultView add(@Valid OrganizationView organization) {
        Organization newOrg = new Organization(
                organization.getName(),
                organization.getFullName(),
                organization.getInn(),
                organization.getKpp(),
                organization.getAddress(),
                organization.getPhone(),
                organization.isActive()
        );
        dao.save(newOrg);
        return new ResultView("success");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ResultView update(@Valid OrganizationView organization) {
        Organization newOrg = new Organization(
                organization.getName(),
                organization.getFullName(),
                organization.getInn(),
                organization.getKpp(),
                organization.getAddress(),
                organization.getPhone(),
                organization.isActive()
        );
        dao.update(organization.getId(), newOrg);
        return new ResultView("success");
    }
}
