package com.example.demo.Service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.example.demo.database.source;

@NoRepositoryBean
public interface sourceRepo extends CrudRepository<source,Integer> {
	@Query(value="SELECT * FROM source WHERE Type = : type")
	List<source>getSourcebyType(String type);
}


