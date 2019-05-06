package ru.bellintegrator.singglerr.practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(value = "Вид документа")
public class DocTypeView {

	@Size(min = 2, max = 2)
	@NotEmpty(message = "code can't be null")
	@ApiModelProperty(value = "Код вида документа", example = "21")
	public String code;

	@Size(max = 128)
	@NotEmpty(message = "name can't be null")
	@ApiModelProperty(value = "Название вида документа", example = "Паспорт гражданина РФ")
	public String name;

	@Override
	public String toString() {
		return "{code:" + code + ";name:" + name + "}";
	}
}
