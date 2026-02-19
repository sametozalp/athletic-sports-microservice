package com.ozalp.organization.business.services;

import com.ozalp.organization.models.entities.BaseEntity;

public interface BaseService<T extends BaseEntity> {

    T findById(int id);

    T save(T t);

    void delete(int id);
}
