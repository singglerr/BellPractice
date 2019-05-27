package ru.bellintegrator.singglerr.practice.service.office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.singglerr.practice.dao.office.OfficeDao;
import ru.bellintegrator.singglerr.practice.dao.organization.OrganizationDao;
import ru.bellintegrator.singglerr.practice.model.Office;
import ru.bellintegrator.singglerr.practice.model.Organization;
import ru.bellintegrator.singglerr.practice.model.mapper.MapperFacade;
import ru.bellintegrator.singglerr.practice.view.SaveOfficeView;
import ru.bellintegrator.singglerr.practice.view.OfficeView;
import ru.bellintegrator.singglerr.practice.view.ResultView;
import ru.bellintegrator.singglerr.practice.view.SimpleOfficeView;
import ru.bellintegrator.singglerr.practice.view.filter.OfficeFilterView;

import javax.validation.Valid;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao officeDao;
    private final OrganizationDao organizationDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao, OrganizationDao organizationDao, MapperFacade mapperFacade) {
        this.officeDao = officeDao;
        this.organizationDao = organizationDao;
        this.mapperFacade = mapperFacade;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<SimpleOfficeView> officesByFilter(@Valid OfficeFilterView officeFilter) {
        Organization org = organizationDao.loadById(officeFilter.getOrgId());
        String name = officeFilter.getName();
        String phone = officeFilter.getPhone();
        Boolean isActive = officeFilter.getActive();
        List<Office> officeList = officeDao.loadListBy(org, name, phone, isActive);
        return mapperFacade.mapAsList(officeList, SimpleOfficeView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public OfficeView officeById(Long id) {
        return mapperFacade.map(officeDao.loadById(id), OfficeView.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ResultView add(@Valid SaveOfficeView office) {
        Organization org = organizationDao.loadById(office.getOrgId());
        Office officeToSave = new Office(
                office.getName(),
                office.getAddress(),
                office.getPhone(),
                office.getActive(),
                org
        );
        officeDao.save(officeToSave);
        return new ResultView("success");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public ResultView update(@Valid OfficeView office) {
        Long id = office.getId();
        Office officeToUpdate = new Office(
                office.getName(),
                office.getAddress(),
                office.getPhone(),
                office.getActive(),
                null
        );
        officeDao.update(id, officeToUpdate);
        return new ResultView("success");
    }
}
