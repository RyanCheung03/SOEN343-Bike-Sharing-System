package com.soen343.tbd.infrastructure.persistence.repo;

import com.soen343.tbd.infrastructure.persistence.entity.BikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataBikeRepo extends JpaRepository<BikeEntity, Long> {
}
