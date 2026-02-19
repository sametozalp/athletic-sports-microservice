package com.ozalp.healthy_eating_tip.business.services;

import com.ozalp.healthy_eating_tip.models.entities.BaseEntity;

public interface BaseService<T extends BaseEntity> {

    T findById(int id);

    T save(T t);

    void delete(int id);
}
