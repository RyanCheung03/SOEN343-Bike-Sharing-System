package com.soen343.tbd.infrastructure.persistence.repository;

import com.soen343.tbd.infrastructure.persistence.entity.BikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBikeRepository extends JpaRepository<BikeEntity, Long> {
}
