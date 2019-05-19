package ru.bellintegrator.singglerr.practice.dao.office;

import ru.bellintegrator.singglerr.practice.model.Office;
import ru.bellintegrator.singglerr.practice.model.Organization;

import java.util.List;

/**
 * DAO для работы с Office
 */
public interface OfficeDao {

    /**
     * Получить список Office конкретной Organization по частичному совпадению названия, телефону и статусу isActive
     * @param org - Organization, для которой нужно найти офисы
     * @param name - название офиса
     * @param phone - телеофонный номер офиса
     * @param isActive - активен ли офис
     * @return список Office
     */
    List<Office> loadListBy(Organization org, String name, String phone, Boolean isActive);

    /**
     * Получить Office по уникальному идентификатору
     * @param id - уникальный идентификатор
     * @return Office
     */
    Office loadById(Long id);

    /**
     * Сохранить Office
     * @param office - офис
     */
    void save(Office office);

    /**
     * Обновить Organization
     * @param id - идентификатор офиса, который нужно обновить
     * @param office - объект Office, содержащий данные для обновления
     */
    void update(Long id, Office office);
}
