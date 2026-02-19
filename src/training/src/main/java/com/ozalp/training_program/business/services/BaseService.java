package com.ozalp.training_program.business.services;


import com.ozalp.training_program.models.entities.BaseEntity;

public interface BaseService<T extends BaseEntity> {

    T findById(int id);

    T save(T t);

    void delete(int id);
}
