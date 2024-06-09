package com.bloomberg.fxdealanalyzer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloomberg.fxdealanalyzer.model.FXDealEntity;

@Repository
public interface FXDealRepository extends JpaRepository<FXDealEntity, Long> {
    boolean existsByDealUniqueId(String dealUniqueId);
}

