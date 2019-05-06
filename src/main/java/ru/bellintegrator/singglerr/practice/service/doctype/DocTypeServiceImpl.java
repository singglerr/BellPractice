package ru.bellintegrator.singglerr.practice.service.doctype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.singglerr.practice.dao.doctype.DocTypeDao;
import ru.bellintegrator.singglerr.practice.model.mapper.MapperFacade;
import ru.bellintegrator.singglerr.practice.view.DocTypeView;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class DocTypeServiceImpl implements DocTypeService{

	private final DocTypeDao dao;
	private final MapperFacade mapperFacade;

	@Autowired
	public DocTypeServiceImpl(DocTypeDao dao, MapperFacade mapperFacade) {
		this.dao = dao;
		this.mapperFacade = mapperFacade;
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(readOnly = true)
	@Override
	public List<DocTypeView> docTypes() {
		return mapperFacade.mapAsList(dao.all(), DocTypeView.class);
	}
}
