package com.project.algocomparator.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.project.algocomparator.models.entities.AlgorithmEntity;
import com.project.algocomparator.models.entities.DataSetEntity;

public interface DataSetRepository extends CrudRepository<DataSetEntity, Integer> {
	DataSetEntity findByDataSetNameID(Integer dataSetNameID);
	
//	@Query("SELECT * FROM dataset WHERE DATASET_NAME_ID = :dataSetNameID AND ID IN (SELECT DATASET_ID FROM algorithm_dataset_mapping WHERE ALGORITHM_ID = :algorithmid)")
//	DataSetEntity findByAlgorithmAndDataSetNameID(@Param("algorithmid") String algorithmId, @Param("dataSetNameID") String dataSetNameID);
}
