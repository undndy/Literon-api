package com.lib.litron10release.DAO;

import org.springframework.data.domain.Sort;

import java.util.List;

public interface GeneralDAO<T> {
    List<T> getAll();

    // поиск записей с любым количествомм параметров
    List<T> search(String searchString);

    // получение объекта по id
    T get(long id);

    // save - обновляет или добавляет объект (один метод на 2 действия)
    T save(T obj);

    // удаление объекта
    void delete(T object);

    // получение всех записей с сортировкой результата
    List<T> getAll(Sort sort);

}
