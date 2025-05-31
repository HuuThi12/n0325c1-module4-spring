package com.techzen.academy_n0325c1.repository;

import com.techzen.academy_n0325c1.model.Student;
import com.techzen.academy_n0325c1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
