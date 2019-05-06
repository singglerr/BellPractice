package ru.bellintegrator.singglerr.practice.service.doctype;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.singglerr.practice.view.DocTypeView;

import java.util.List;

@Validated
public interface DocTypeService {

	/**
	 * Получит список видов документов
	 * @return
	 */
	List<DocTypeView> docTypes();
}
