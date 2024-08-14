package com.project.algocomparator.services;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.algocomparator.configurations.CommonMappings;
import com.project.algocomparator.exception.InvalidRequestException;
import com.project.algocomparator.models.dtos.ComparisonRequestDTO;
import com.project.algocomparator.models.dtos.ExecutionDetailsDTO;
import com.project.algocomparator.models.entities.AlgorithmEntity;
import com.project.algocomparator.models.entities.DataSetEntity;
import com.project.algocomparator.repositories.AlgorithmRepository;
import com.project.algocomparator.repositories.DataSetRepository;

@Service
public class ComparisonRequestService {
	
	@Autowired
	private DataSetRepository datasetRepository;
	
	@Autowired
	private AlgorithmRepository algorithmRepository;
	
	public void compareAlgorithms(ComparisonRequestDTO requestDTO) throws InvalidRequestException {
		DataSetEntity dataSet = validateRequestAndGetDataSet(requestDTO);		
		if (dataSet == null) {
			throw new InvalidRequestException("Invalid Data Set Passed.");
		}
		
		CommonMappings.THREAD_LOCK.lock();
		if(!CommonMappings.THREAD_RUNNER_CACHE.isEmpty()) {
			CommonMappings.THREAD_LOCK.unlock();
			throw new InvalidRequestException("Other Comparision Request is already in process, try again later!");
		}
		CommonMappings.THREAD_LOCK.unlock();

		CommonMappings.LOCK.lock();
		CommonMappings.ALGORITHM_EXECUTION_TIME_CACHE = new ExecutionDetailsDTO(0, new ConcurrentHashMap<String, Map<String,Long>>());
		CommonMappings.LOCK.unlock();
		
		for(String ids : requestDTO.getAlgorithmNameIDs()) {
			ThreadRunnerService th = new ThreadRunnerService(dataSet, algorithmRepository.findByAlgorithmNameID(ids));
			th.start();
			CommonMappings.THREAD_LOCK.lock();
			CommonMappings.THREAD_RUNNER_CACHE.add(th);
			CommonMappings.THREAD_LOCK.unlock();
		}
	}
	
//	TODO: Reduce this for loops to a DB query
	public DataSetEntity validateRequestAndGetDataSet(ComparisonRequestDTO request){
		DataSetEntity ds = null;
		for (String id : request.getAlgorithmNameIDs()) {
			List<DataSetEntity> datasets = algorithmRepository.findByAlgorithmNameID(id).getUsableDataSets();
			for(DataSetEntity dataset: datasets) {
				if((ds != null && ds.getDataSetNameID().equalsIgnoreCase(request.getDataSetNameID())) || 
						(ds == null && dataset.getDataSetNameID().equalsIgnoreCase(request.getDataSetNameID()))) {
					ds = dataset;
					break;
				}
			}
		}
		return ds;
	}
}
