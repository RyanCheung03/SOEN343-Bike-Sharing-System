package com.soen343.tbd.infrastructure.persistence.adapter;

import com.soen343.tbd.domain.model.Bike;
import com.soen343.tbd.domain.model.ids.BikeId;
import com.soen343.tbd.domain.repository.BikeRepository;
import com.soen343.tbd.infrastructure.persistence.mapper.BikeMapper;
import com.soen343.tbd.infrastructure.persistence.repo.SpringDataBikeRepo;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaBikeRepository implements BikeRepository {
    private final SpringDataBikeRepo springDataBikeRepo;
    private final BikeMapper bikeMapper;

    public JpaBikeRepository(SpringDataBikeRepo jpa, BikeMapper mapper) {
        this.springDataBikeRepo = jpa;
        this.bikeMapper = mapper;
    }

    @Override
    public Optional<Bike> findById(BikeId bikeId) {
        return springDataBikeRepo.findById(bikeId.value())
                .map(bikeMapper::toDomain);
    }

    @Override
    public void save(Bike bike) {
        springDataBikeRepo.save(bikeMapper.toEntity(bike));
    }

}
