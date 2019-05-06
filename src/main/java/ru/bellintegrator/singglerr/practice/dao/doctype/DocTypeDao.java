package ru.bellintegrator.singglerr.practice.dao.doctype;

import ru.bellintegrator.singglerr.practice.model.DocType;

import java.util.List;

/**
 * DAO для работы с DocType
 */
public interface DocTypeDao {

	/**
	 * Получить все объекты DocType
	 * @return
	 */
	List<DocType> all();

	/**
	 * Получить DocType по коду вида документа
	 * @param code код вида документа
	 * @return
	 */
	DocType loadByCode(String code);

	/**
	 * Получить DocType по названию вида документа
	 * @param name название вида документа
	 * @return
	 */
	DocType loadByName(String name);
}
