package com.ozalp.membership.business.services;

import com.ozalp.membership.models.entities.BaseEntity;

public interface BaseService<T extends BaseEntity> {

    T findById(int id);

    T save(T t);

    void delete(int id);
}
