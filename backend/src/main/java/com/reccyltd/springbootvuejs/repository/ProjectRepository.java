package com.reccyltd.springbootvuejs.repository;


import com.reccyltd.springbootvuejs.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    List<Project> findByName(@Param("name") String name);
}
