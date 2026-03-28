package org.ozalp.managers;

import lombok.RequiredArgsConstructor;
import org.ozalp.models.entites.BaseEntity;
import org.ozalp.services.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public abstract class BaseImpl<T extends BaseEntity> implements BaseService<T> {

    protected abstract JpaRepository<T, Integer> getRepository();

    @Override
    public T findById(int id) {
        return getRepository().findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }

    @Override
    public T save(T t) {
        return getRepository().save(t);
    }

    @Override
    public void delete(int id) {
        T entity = findById(id);
        entity.markAsDelete();
        getRepository().save(entity);
    }
}