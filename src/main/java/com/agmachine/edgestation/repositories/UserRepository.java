package com.agmachine.edgestation.repositories;

import com.agmachine.edgestation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findUserByUserName(String userName);
    boolean existsUserByUserName(String userName);
}
