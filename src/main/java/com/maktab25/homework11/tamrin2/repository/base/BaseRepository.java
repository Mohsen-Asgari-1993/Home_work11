package com.maktab25.homework11.tamrin2.repository.base;

import java.io.Serializable;

public interface BaseRepository<E extends Serializable> {

    void create(E e);

    E update(E e);

    E read(Serializable id);

    void delete(Serializable id);

}
