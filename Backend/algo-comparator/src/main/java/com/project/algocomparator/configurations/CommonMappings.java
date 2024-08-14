package com.project.algocomparator.configurations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.context.annotation.Configuration;

import com.project.algocomparator.models.dtos.ExecutionDetailsDTO;
import com.project.algocomparator.models.entities.AlgorithmEntity;
import com.project.algocomparator.models.entities.DataSetEntity;
import com.project.algocomparator.models.enums.AlgorithmType;
import com.project.algocomparator.models.enums.DataSetType;
import com.project.algocomparator.services.ThreadRunnerService;

@Configuration(value = "commonMappings")
public class CommonMappings {
//	public static final Map<String, AlgorithmEntity> algorithmEntitiesMap = new HashMap<String, AlgorithmEntity>();
//	public static final Map<String, List<DataSetType>> algorithmToDataSetTypeMap = new HashMap<String, List<DataSetType>>();
//	public static final Map<DataSetType, DataSetEntity> dataSetTypeEnumToObjectMap = new HashMap<DataSetType, DataSetEntity>();
	public static final Map<AlgorithmType, String> algorithmTypeEnumToStringMap = new HashMap<AlgorithmType, String>();
	
	public static ExecutionDetailsDTO ALGORITHM_EXECUTION_TIME_CACHE = new ExecutionDetailsDTO(0, new ConcurrentHashMap<String, Map<String,Long>>());
	public static final List<ThreadRunnerService> THREAD_RUNNER_CACHE = new ArrayList<ThreadRunnerService>();
	
	public static ReentrantLock LOCK = new ReentrantLock();
	public static ReentrantLock THREAD_LOCK = new ReentrantLock();
}
