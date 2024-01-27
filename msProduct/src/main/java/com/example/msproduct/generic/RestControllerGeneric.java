package com.example.msproduct.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public class RestControllerGeneric <T,id>{


    @Autowired()
    ServiceGeneric<T,id> ServiceGeneric;


    @GetMapping
    public List<T>  getAll(){
        return ServiceGeneric.getAll();
    }



    @PostMapping
    public String add(@RequestBody T x){
        ServiceGeneric.save(x);
        return "Add : True";
    }



    @GetMapping("/{id}")
    public T findOne(@PathVariable("id") id id) {
        return ServiceGeneric.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") id id) {
        ServiceGeneric.delete(id);
        return "Deleted : True";
    }

    @PatchMapping("/{id}")
    public T update(@PathVariable("id") id id , @RequestBody Map<Object,Object> fields) {

        return ServiceGeneric.update(id,fields);
    }







}
