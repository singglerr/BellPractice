package ru.bellintegrator.singglerr.practice.service.user;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.singglerr.practice.view.ResultView;
import ru.bellintegrator.singglerr.practice.view.user.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Сервис CRUD для User
 */
@Validated
public interface UserService {

    /**
     * Получение списока сотрудников по фильтру
     * @param userFilter - фильтр
     * @return список сотрудников
     */
    List<SimpleUserView> usersByFilter(@Valid UserFilterView userFilter);

    /**
     * Получение сотрудника по его уникальному идентификатору
     * @param id - уникальный идентификатор сотрудника
     * @return UserView
     */
    UserView userById(Long id);

    /**
     * Добавление нового сотрудника в БД
     * @param userView - данные для добавления нового сотрудника
     * @return результат выполнения операции
     */
    ResultView add(@Valid SaveUserView userView);

    /**
     * Обновить информацию об офисе в БД
     * @param userView - данные для обновления информации об офисе
     * @return результат выполнения операции
     */
    ResultView update(@Valid UpdateUserView userView);
}
