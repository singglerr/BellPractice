package ru.bellintegrator.singglerr.practice.service.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.singglerr.practice.dao.country.CountryDao;
import ru.bellintegrator.singglerr.practice.model.mapper.MapperFacade;
import ru.bellintegrator.singglerr.practice.view.CountryView;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class CountryServiceImpl implements CountryService {

	private final CountryDao dao;
	private final MapperFacade mapperFacade;

	@Autowired
	public CountryServiceImpl(CountryDao dao, MapperFacade mapperFacade) {
		this.dao = dao;
		this.mapperFacade = mapperFacade;
	}

	@Override
	@Transactional(readOnly = true)
	public List<CountryView> countries() {
		return mapperFacade.mapAsList(dao.all(), CountryView.class);
	}
}
