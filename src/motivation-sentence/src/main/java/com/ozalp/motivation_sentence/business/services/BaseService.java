package com.ozalp.motivation_sentence.business.services;

import com.ozalp.motivation_sentence.models.entities.BaseEntity;

public interface BaseService<T extends BaseEntity> {

    T findById(int id);

    T save(T t);

    void delete(int id);
}
