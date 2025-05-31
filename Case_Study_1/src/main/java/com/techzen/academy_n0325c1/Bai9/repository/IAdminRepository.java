package com.techzen.academy_n0325c1.Bai9.repository;

import com.techzen.academy_n0325c1.Bai9.model.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {
    @Query(value = """
            select * from admin 
            where full_name like concat('%', :fullName, '%')
            AND (:email IS NULL OR email = :email)
            """, nativeQuery = true)
    Page<Admin> findByAttr(@Param("fullName") String fullName,
                           @Param("email") String email,
                           Pageable pageable);

}
