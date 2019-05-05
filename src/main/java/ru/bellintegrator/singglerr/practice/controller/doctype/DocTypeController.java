package ru.bellintegrator.singglerr.practice.controller.doctype;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "DocTypeController", description = "Управление справочником видов документов")
@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class DocTypeController {


}
