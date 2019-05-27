package ru.bellintegrator.singglerr.practice.controller.office;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.singglerr.practice.service.office.OfficeService;
import ru.bellintegrator.singglerr.practice.view.office.SaveOfficeView;
import ru.bellintegrator.singglerr.practice.view.office.OfficeView;
import ru.bellintegrator.singglerr.practice.view.ResultView;
import ru.bellintegrator.singglerr.practice.view.office.SimpleOfficeView;
import ru.bellintegrator.singglerr.practice.view.office.OfficeFilterView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OfficeController", description = "Управление информацией об офисах")
@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @ApiOperation(value = "Получить список офисов", httpMethod = "POST")
    @PostMapping(value = "/list")
    public List<SimpleOfficeView> officeList(@RequestBody OfficeFilterView officeFilter){
        return officeService.officesByFilter(officeFilter);
    }

    @ApiOperation(value = "Получить офис по уникальному идентификатору", httpMethod = "GET")
    @GetMapping(value = "/{id}")
    public OfficeView office(@PathVariable Long id){
        return officeService.officeById(id);
    }

    @ApiOperation(value = "Обновить данные офиса", httpMethod = "POST")
    @PostMapping(value = "/update")
    public ResultView updateOffice(@RequestBody OfficeView office){
        return officeService.update(office);
    }

    @ApiOperation(value = "Добавить новый офис", httpMethod = "POST")
    @PostMapping(value = "/save")
    public ResultView addOffice(@RequestBody SaveOfficeView office){
        return officeService.add(office);
    }
}
