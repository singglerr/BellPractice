package ru.bellintegrator.singglerr.practice.service.organization;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.singglerr.practice.view.organization.OrganizationView;
import ru.bellintegrator.singglerr.practice.view.ResultView;
import ru.bellintegrator.singglerr.practice.view.organization.SimpleOrganizationView;
import ru.bellintegrator.singglerr.practice.view.organization.OrganizationFilterView;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис CRUD для Organization
 */
@Validated
public interface OrganizationService {

    /**
     * Получение списока организаций по фильтру
     * @param organizationFilter - фильтр
     * @return список организаций
     */
    List<SimpleOrganizationView> organizationsByFilter(@Valid OrganizationFilterView organizationFilter);

    /**
     * Получение организации по её уникальному идентификатору
     * @param id - уникальный идентификатор организации
     * @return OrganizationView
     */
    OrganizationView organizationById(Long id);

    /**
     * Добавление новой организации в БД
     * @param organization - организация
     * @return результат выполнения операции
     */
    ResultView add(@Valid OrganizationView organization);

    /**
     * Обновить информацию об организации в БД
     * @param organization - организация
     * @return результат выполнения операции
     */
    ResultView update(@Valid OrganizationView organization);
}
