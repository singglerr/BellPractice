package ru.bellintegrator.singglerr.practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

@ApiModel(value = "Результат выполнения операции")
public class ResultView {

    @NotEmpty(message = "result cant't be null")
    @ApiModelProperty(value = "Результат", example = "success")
    private String result;

    public ResultView() {
    }

    public ResultView(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "{result:" + result + "}";
    }
}