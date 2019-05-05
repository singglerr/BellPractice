package ru.bellintegrator.singglerr.practice.controller.country;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.singglerr.practice.service.country.CountryService;
import ru.bellintegrator.singglerr.practice.view.CountryView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "CountryController", description = "Управление справочником стран")
@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class CountryController {

	private final CountryService countryService;

	@Autowired
	public CountryController(CountryService countryService) {
		this.countryService = countryService;
	}

	@ApiOperation(value = "Получить список всех стран", httpMethod = "GET")
	@GetMapping("/countries")
	public List<CountryView> countries(){
		return countryService.countries();
	}
}
