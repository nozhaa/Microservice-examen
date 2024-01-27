package com.example.msproduct.generic;

import java.util.List;
import java.util.Map;

public interface ServiceGeneric<T , id>{

    T save (T entity) ;

    List<T> getAll () ;

    T getById(id i );

    T update(id id , Map<Object,Object > fields);

    void delete ( id i);


}
