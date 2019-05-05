package ru.bellintegrator.singglerr.practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description = "Страна")
public class CountryView {

	@Size(max = 60)
	@NotEmpty(message = "name can't be null")
	@ApiModelProperty(value = "Название", example = "Россия")
	public String name;

	@Size(min = 3, max = 3)
	@NotEmpty(message = "code can't be null")
	@ApiModelProperty(value = "Код страны", example = "643")
	public String code;

	@Override
	public String toString() {
		return "{name:" + name + ";code:" + code + "}";
	}
}
