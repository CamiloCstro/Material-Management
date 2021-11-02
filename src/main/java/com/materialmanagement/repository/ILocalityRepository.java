package com.materialmanagement.repository;

import com.materialmanagement.model.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocalityRepository extends JpaRepository<Locality, Integer> {
}
