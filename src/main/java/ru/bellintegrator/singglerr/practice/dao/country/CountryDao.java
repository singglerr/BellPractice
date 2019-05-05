package ru.bellintegrator.singglerr.practice.dao.country;


import ru.bellintegrator.singglerr.practice.model.Country;

import java.util.List;

/**
 * DAO для работы с Country
 */
public interface CountryDao {

	/**
	 * Получить все объекты Country
	 *
	 * @return
	 */
	List<Country> all();

	/**
	 * Получить страну по названию
	 *
	 * @param name название страны
	 * @return
	 */
	Country loadByName(String name);

	/**
	 * Получить страну по цифровому коду страны
	 *
	 * @param code цифровой код страны
	 * @return
	 */
	Country loadByCode(String code);
}
