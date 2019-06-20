package com.reccyltd.springbootvuejs.repository;


import com.reccyltd.springbootvuejs.domain.User;
import com.reccyltd.springbootvuejs.domain.Workspace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkspaceRepository extends CrudRepository<Workspace, Long> {

    List<User> getAllByName(@Param("name") String name);
}
