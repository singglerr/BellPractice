package ru.bellintegrator.singglerr.practice.service.country;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.singglerr.practice.view.CountryView;

import java.util.List;

/**
 * Сервис CRUD для Country
 */
@Validated
public interface CountryService {

	/**
	 * Получение списока стран
	 * @return
	 */
	List<CountryView> countries();
}
