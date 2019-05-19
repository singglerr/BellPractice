package ru.bellintegrator.singglerr.practice.controller.organization;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.singglerr.practice.service.organization.OrganizationService;
import ru.bellintegrator.singglerr.practice.view.OrganizationView;
import ru.bellintegrator.singglerr.practice.view.ResultView;
import ru.bellintegrator.singglerr.practice.view.SimpleOrganizationView;
import ru.bellintegrator.singglerr.practice.view.filter.OrganizationFilterView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


//TODO Разобраться как сделать полное соответствие названий полей классов и JSON в запросе/ответе (в частности isActive класса Organization)

@Api(value = "OrganizationController", description = "Управление информацией об организациях")
@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @ApiOperation(value = "Получить список организаций, удовлетворяющих фильтру", httpMethod = "POST")
    @PostMapping(value = "/list")
    public List<SimpleOrganizationView> organizationList(@RequestBody OrganizationFilterView organizationFilter){
        return organizationService.organizationsByFilter(organizationFilter);
    }

    @ApiOperation(value = "Получить организацию по уникальному идентификатору", httpMethod = "GET")
    @GetMapping(value = "/{id}")
    public OrganizationView organization(@PathVariable Long id){
        return organizationService.organizationById(id);
    }

    @ApiOperation(value = "Обновить данные организации", httpMethod = "POST")
    @PostMapping(value = "/update")
    public ResultView updateOrganization(@RequestBody OrganizationView organization){
        return organizationService.update(organization);
    }

    @ApiOperation(value = "Добавить новую организацию", httpMethod = "POST")
    @PostMapping(value = "/save")
    public ResultView addOrganization(@RequestBody OrganizationView organization){
        return organizationService.add(organization);
    }
}
