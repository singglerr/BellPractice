package ru.bellintegrator.singglerr.practice.service.doctype;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.singglerr.practice.view.DocTypeView;

import java.util.List;

/**
 * Сервис CRUD для DocType
 */
@Validated
public interface DocTypeService {

	/**
	 * Получение списока видов документов
	 * @return
	 */
	List<DocTypeView> docTypes();
}
