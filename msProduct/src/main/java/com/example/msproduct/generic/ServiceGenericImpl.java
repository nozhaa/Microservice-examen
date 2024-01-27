package com.example.msproduct.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
@Component
public class ServiceGenericImpl<T, id> implements ServiceGeneric<T , id>{


    @Autowired
    private JpaRepository<T , id> jpaRepository ;

    @Override
    public T save(T entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public List<T> getAll() {
        return jpaRepository.findAll();
    }

    @Override
    public T getById(id i) {
        return jpaRepository.findById(i).orElse(null);
    }

    @Override
    public T update(id id, Map<Object, Object> fields) {
        T entity = getById(id) ;
        Assert.notNull(entity,"object not found with this id ");
        fields.forEach((key , value)-> {
            Field field = ReflectionUtils.findField((Class<T>) entity.getClass() , (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field,  (Class<T>) entity.getClass(),value);
        });
        return jpaRepository.save(entity);
    }


    @Override
    public void delete(id i) {
        jpaRepository.deleteById(i);

    }
}
