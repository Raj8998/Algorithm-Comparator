package com.project.algocomparator.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.algocomparator.configurations.CommonMappings;
import com.project.algocomparator.models.dtos.AlgorithmDTO;
import com.project.algocomparator.models.dtos.DataSetDTO;
import com.project.algocomparator.models.entities.AlgorithmEntity;
import com.project.algocomparator.models.entities.DataSetEntity;
import com.project.algocomparator.repositories.AlgorithmRepository;

@Service
public class AlgorithmDetailsService {
	
	@Autowired
	private AlgorithmRepository algorithmRepository;

	public List<AlgorithmDTO> getAlgorithmDetails() {
		List<AlgorithmDTO> algorithmsList = new ArrayList<AlgorithmDTO>();
		for(AlgorithmEntity entity: algorithmRepository.findAll()) {
			List<DataSetDTO> dataSets = new ArrayList<DataSetDTO>();
			entity.getUsableDataSets().forEach((dataset) -> {
				DataSetDTO dataSetDTO = new DataSetDTO(dataset.getDataSetNameID(), dataset.getDataSetDisplayName());
				dataSets.add(dataSetDTO);
			});
			algorithmsList.add(new AlgorithmDTO(entity.getAlgorithmNameID(), entity.getAlgorithmDisplayName(),
					entity.getAlgorithmType(), dataSets));
		}
		return algorithmsList;
	}
}
