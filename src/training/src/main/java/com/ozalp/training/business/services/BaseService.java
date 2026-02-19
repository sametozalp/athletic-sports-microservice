package com.ozalp.training.business.services;


import com.ozalp.training.models.entities.BaseEntity;

public interface BaseService<T extends BaseEntity> {

    T findById(int id);

    T save(T t);

    void delete(int id);
}
