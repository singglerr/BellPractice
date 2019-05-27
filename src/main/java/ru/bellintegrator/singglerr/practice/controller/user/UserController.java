package ru.bellintegrator.singglerr.practice.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.singglerr.practice.service.user.UserService;
import ru.bellintegrator.singglerr.practice.view.ResultView;
import ru.bellintegrator.singglerr.practice.view.user.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "UserController", description = "Управление информацией о людях")
@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Получить список людей", httpMethod = "POST")
    @PostMapping(value = "/list")
    public List<SimpleUserView> officeList(@RequestBody UserFilterView userFilter){
        return userService.usersByFilter(userFilter);
    }

    @ApiOperation(value = "Получить офис по уникальному идентификатору", httpMethod = "GET")
    @GetMapping(value = "/{id}")
    public UserView office(@PathVariable Long id){
        return userService.userById(id);
    }

    @ApiOperation(value = "Обновить данные офиса", httpMethod = "POST")
    @PostMapping(value = "/update")
    public ResultView updateOffice(@RequestBody UpdateUserView user){
        return userService.update(user);
    }

    @ApiOperation(value = "Добавить новый офис", httpMethod = "POST")
    @PostMapping(value = "/save")
    public ResultView addOffice(@RequestBody SaveUserView user){
        return userService.add(user);
    }

}
