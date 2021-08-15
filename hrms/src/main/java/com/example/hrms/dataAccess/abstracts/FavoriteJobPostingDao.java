package com.example.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entities.concretes.FavoriteJobPosting;

public interface FavoriteJobPostingDao extends JpaRepository<FavoriteJobPosting, Integer> {

}
