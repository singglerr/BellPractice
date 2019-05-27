package ru.bellintegrator.singglerr.practice.service.office;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.singglerr.practice.view.*;
import ru.bellintegrator.singglerr.practice.view.office.OfficeFilterView;
import ru.bellintegrator.singglerr.practice.view.office.OfficeView;
import ru.bellintegrator.singglerr.practice.view.office.SaveOfficeView;
import ru.bellintegrator.singglerr.practice.view.office.SimpleOfficeView;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис CRUD для Office
 */
@Validated
public interface OfficeService {

    /**
     * Получение списока офисов по фильтру
     * @param officeFilter - фильтр
     * @return список офисов
     */
    List<SimpleOfficeView> officesByFilter(@Valid OfficeFilterView officeFilter);

    /**
     * Получение офиса по его уникальному идентификатору
     * @param id - уникальный идентификатор офиса
     * @return OfficeView
     */
    OfficeView officeById(Long id);

    /**
     * Добавление нового офиса в БД
     * @param office - данные для добавления нового офиса
     * @return результат выполнения операции
     */
    ResultView add(@Valid SaveOfficeView office);

    /**
     * Обновить информацию об офисе в БД
     * @param office - данные для обновления информации об офисе
     * @return результат выполнения операции
     */
    ResultView update(@Valid OfficeView office);
}
