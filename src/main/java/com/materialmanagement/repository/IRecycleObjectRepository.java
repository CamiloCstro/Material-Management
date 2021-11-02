package com.materialmanagement.repository;

import com.materialmanagement.model.RecycleObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRecycleObjectRepository extends JpaRepository<RecycleObject, Integer> {
}
