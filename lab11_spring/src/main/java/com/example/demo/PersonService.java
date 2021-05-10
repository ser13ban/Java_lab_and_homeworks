package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepo repository;

    public List<Person> listAll(){
        return repository.findAll();
    }

    public void save(Person person) {
        repository.save(person);
    }

    public Person get(Integer id){
        return repository.findById(id).get();
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
}
