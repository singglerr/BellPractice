package ru.bellintegrator.singglerr.practice.dao.user;

import ru.bellintegrator.singglerr.practice.model.User;

import java.util.List;

/**
 * DAO для работы с User
 */
public interface UserDao {

	/**
	 * Получить список User конкретного Office по коду вида документа, коду страны, частичному совпадению имени,
	 * фамилии, отчества и названия должности
	 * @param officeId - ункальный идентификатор Office
	 * @param citizenshipCode - код страны
	 * @param docCode - код вида документа
	 * @param firstName - имя
	 * @param secondName - фамилия
	 * @param middleName - отчество
	 * @param position - название должности
	 * @return список User
	 */
	List<User> loadListBy(Long officeId, Integer citizenshipCode, Integer docCode, String firstName, String secondName,
						  String middleName, String position);

	/**
	 * Получить User по уникальному идентификатору
	 * @param id - уникальный идентификатор
	 * @return User
	 */
	User loadById(Long id);

	/**
	 * Сохранить User
	 * @param user - сотрудник
	 */
	void save(User user);

	/**
	 * Обновить User
	 * @param id - идентификатор user, информацию о котором нужно обновить
	 * @param user - объект User, содержащий данные для обновления
	 */
	void update(Long id, User user);
}
