package com.ozalp.auth.business.services;

import com.ozalp.auth.models.entities.BaseEntity;

public interface BaseService<T extends BaseEntity> {

    T findById(int id);

    T save(T t);

    void delete(int id);
}
