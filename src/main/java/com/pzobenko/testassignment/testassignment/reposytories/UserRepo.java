package com.pzobenko.testassignment.testassignment.reposytories;

import com.pzobenko.testassignment.testassignment.entitys.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {

}
