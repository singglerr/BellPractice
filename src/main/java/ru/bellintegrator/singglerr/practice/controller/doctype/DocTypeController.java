package ru.bellintegrator.singglerr.practice.controller.doctype;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.singglerr.practice.service.doctype.DocTypeService;
import ru.bellintegrator.singglerr.practice.view.DocTypeView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "DocTypeController", description = "Управление справочником видов документов")
@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class DocTypeController {

	private final DocTypeService docTypeService;

	@Autowired
	public DocTypeController(DocTypeService docTypeService) {
		this.docTypeService = docTypeService;
	}

	@ApiOperation(value = "Получить список всех видов документов", httpMethod = "GET")
	@GetMapping("/docs")
	public List<DocTypeView> docTypes(){
		return docTypeService.docTypes();
	}
}
