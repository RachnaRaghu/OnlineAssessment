package com.wipro.bed2.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.bed2.entity.Test;
@Repository
public interface TestRepository extends CrudRepository<Test, String>{

}
