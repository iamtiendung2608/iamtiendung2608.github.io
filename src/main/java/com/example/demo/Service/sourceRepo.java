package com.example.demo.Service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.example.demo.database.source;

@NoRepositoryBean
public interface sourceRepo extends CrudRepository<source,Integer> {

}
