package ru.bellintegrator.singglerr.practice.dao.organization;

import ru.bellintegrator.singglerr.practice.model.Organization;

import java.util.List;

/**
 * DAO для работы с Organization
 */
public interface OrganizationDao {

    /**
     * Получить список Organization по частичному совпадению названия, по совпадению ИНН и статусу isActive
     * @param name - название
     * @param inn - ИНН
     * @param isActive - активна ли организация
     * @return
     */
    List<Organization> loadListBy(String name, String inn, Boolean isActive);

    /**
     * Получить Organization по уникальному идентификатору
     * @param id - уникальный идентификатор
     * @return
     */
    Organization loadById(Long id);

    /**
     * Сохранить Organization
     * @param organization - организация
     */
    void save(Organization organization);

    /**
     * Обновить Organization
     * @param id - идентификатор
     * @param organization - организация
     */
    void update(Long id, Organization organization);
}
