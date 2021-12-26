package com.example.springbootbackend.repository;

import com.example.springbootbackend.model.Emploee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploeeRepository extends JpaRepository<Emploee,Long> {
}
