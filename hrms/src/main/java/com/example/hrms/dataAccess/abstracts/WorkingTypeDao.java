package com.example.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entities.concretes.WorkingType;

public interface WorkingTypeDao extends JpaRepository<WorkingType, Integer> {

}
