package ru.bellintegrator.singglerr.practice.service.country;

import org.springframework.validation.annotation.Validated;
import ru.bellintegrator.singglerr.practice.view.CountryView;

import java.util.List;

@Validated
public interface CountryService {

	/**
	 * Получить список стран
	 * @return возвращает список стран
	 */
	List<CountryView> countries();
}
