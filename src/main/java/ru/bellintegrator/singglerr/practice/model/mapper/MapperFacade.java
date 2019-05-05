package ru.bellintegrator.singglerr.practice.model.mapper;

import java.util.List;

/**
 * Фасад для преобразования между моделями БД и фронтэнда
 */
public interface MapperFacade {

	/**
	 * Преобразование sourceObject в экземпляр класса destinationClass
	 *
	 * @param sourceObject     исходный объект
	 * @param destinationClass класс, в который надо преобразовать объект
	 * @param <S>              тип исходного объекта
	 * @param <D>              тип объекта, к которому надо преобразовать исходный объект
	 * @return экземпляр класса D с данными из sourceObject
	 */
	<S, D> D map(S sourceObject, Class<D> destinationClass);

	/**
	 * Запись занных из sourceObject в destinationObject
	 *
	 * @param sourceObject		исходный объект
	 * @param destinationObject	объект, в который будут записаны данные из sourceObject
	 * @param <S>				тип исходного объекта
	 * @param <D>				тип объекта, в который будут записаны данные
	 */
	<S, D> void map(S sourceObject, D destinationObject);

	/**
	 * Преобразование коллекции оъектов
	 *
	 * @param source			исходный Iterable объект, содержащий объекты для преобразования
	 * @param destinationClass	класс, в который надо преобразовать объект
	 * @param <S>				тип исходных объектов
	 * @param <D>				тип объектов, к корому надо преобразовать исходные
	 * @return список, содержащий объекты класса D с данными из объектов source
	 */
	<S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass);
}
