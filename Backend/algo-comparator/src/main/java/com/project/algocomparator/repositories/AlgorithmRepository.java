package com.project.algocomparator.repositories;

import org.springframework.data.repository.CrudRepository;

import com.project.algocomparator.models.entities.AlgorithmEntity;
import com.project.algocomparator.models.entities.DataSetEntity;

public interface AlgorithmRepository extends CrudRepository<AlgorithmEntity, Integer> {
	AlgorithmEntity findByAlgorithmNameID(String algorithmNameID);
}
