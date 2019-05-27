package ru.bellintegrator.singglerr.practice.view.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "Упрощённое представление сотрудника")
public class SimpleUserView {

    @NotNull
    @ApiModelProperty(value = "Уникальный идентификатор")
    private Integer id;

    @NotEmpty
    @Size(max = 50)
    @ApiModelProperty(value = "Имя")
    private String firstName;

    @Size(max = 50)
    @ApiModelProperty(value = "Фамилия")
    private String secondName;

    @Size(max = 50)
    @ApiModelProperty(value = "Отчество")
    private String middleName;

    @NotEmpty(message = "position can't be null")
    @Size(max = 100)
    @ApiModelProperty(value = "Занимаемая должность")
    private String position;

    public SimpleUserView() {
    }

    public SimpleUserView(@NotNull Integer id,
                          @NotEmpty @Size(max = 50) String firstName,
                          @Size(max = 50) String secondName,
                          @Size(max = 50) String middleName,
                          @NotEmpty @Size(max = 100) String position) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
