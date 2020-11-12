package com.project.backend.repository;

import com.project.backend.entity.FeatureRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeatureRequestRepository extends JpaRepository<FeatureRequest, Integer> {
    List<FeatureRequest> findByClientId(Integer clientId);

}
