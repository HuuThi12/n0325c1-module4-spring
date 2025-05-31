package com.techzen.academy_n0325c1.Bai9.repository;

import com.techzen.academy_n0325c1.Bai9.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
    @Query(value = """
            select * from book 
            where title like concat('%', :title, '%')
            AND (:author IS NULL OR author like concat('%', :author, '%'))
            AND (:totalCopies IS NULL OR total_copies = :totalCopies)
            """, nativeQuery = true)
    Page<Book> findByAttr(@Param("title") String title,
                          @Param("author") String author,
                          @Param("totalCopies") Integer totalCopies,
                          Pageable pageable);

}
