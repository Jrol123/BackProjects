package com.example.p4.repository;

import com.example.p4.entity.test_table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface test extends JpaRepository<test_table, Long> {
}
