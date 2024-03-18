package com.sms.app.repository;

import com.sms.app.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School,Long> {

    @Query("SELECT s FROM School s WHERE s.name LIKE %:keyword%")
    List<School> findByName(@Param("keyword") String keyword);
}
