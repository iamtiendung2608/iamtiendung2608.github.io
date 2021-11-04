package com.example.demo.Service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.database.source;


public interface sourceRepo extends CrudRepository<source,Integer> {
	@Query(value="SELECT *, 0 AS clazz_ FROM source "
			+ " WHERE Type = :type",nativeQuery=true)
	List<source>findAllItemsbyBrand(@Param("type")String type);
}


