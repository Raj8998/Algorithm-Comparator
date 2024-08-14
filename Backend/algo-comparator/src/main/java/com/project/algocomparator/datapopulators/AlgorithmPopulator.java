package com.project.algocomparator.datapopulators;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.project.algocomparator.configurations.CommonMappings;
import static com.project.algocomparator.constants.GlobalConstants.*;
import com.project.algocomparator.models.entities.AlgorithmEntity;
import com.project.algocomparator.models.enums.AlgorithmType;
import com.project.algocomparator.models.enums.FileType;

//@Configuration(value = "algorithmPopulator")
//@DependsOn(value = { "commonMappings", "algorithmTypeToStringMapPopulator", "dataSetTypeToObjectMapPopulator",
//		"algorithmToDataSetTypeMapPopulator" })
public class AlgorithmPopulator {

//	public AlgorithmPopulator() {
//		CommonMappings.algorithmEntitiesMap.put(SSA_ID,
//				new AlgorithmEntity(SSA_ID, SELECTION_SORT_DISPLAYNAME, AlgorithmType.SORT,
//						CommonMappings.algorithmToDataSetTypeMap.get(SSA_ID),
//						SORTING_ALGO_PATH + SELECTION_SORT_ALGO_FILENAME, FileType.JAVA));
//
//		CommonMappings.algorithmEntitiesMap.put(MSA_ID,
//				new AlgorithmEntity(MSA_ID, MERGE_SORT_DISPLAYNAME, AlgorithmType.SORT,
//						CommonMappings.algorithmToDataSetTypeMap.get(MSA_ID),
//						SORTING_ALGO_PATH + MERGE_SORT_ALGO_FILENAME, FileType.JAVA));
//
//		CommonMappings.algorithmEntitiesMap.put(BSA_ID,
//				new AlgorithmEntity(BSA_ID, BUBBLE_SORT_DISPLAYNAME, AlgorithmType.SORT,
//						CommonMappings.algorithmToDataSetTypeMap.get(BSA_ID),
//						SORTING_ALGO_PATH + BUBBLE_SORT_ALGO_FILENAME, FileType.JAVA));
//
//		CommonMappings.algorithmEntitiesMap.put(LSeA_ID,
//				new AlgorithmEntity(LSeA_ID, LINEAR_SEARCH_DISPLAYNAME, AlgorithmType.SEARCH,
//						CommonMappings.algorithmToDataSetTypeMap.get(LSeA_ID),
//						SEARCHING_ALGO_PATH + LINEAR_SEARCH_ALGO_FILENAME, FileType.JAVA));
//
//		CommonMappings.algorithmEntitiesMap.put(BSeA_ID,
//				new AlgorithmEntity(BSeA_ID, BINARY_SEARCH_DISPLAYNAME, AlgorithmType.SEARCH,
//						CommonMappings.algorithmToDataSetTypeMap.get(BSeA_ID),
//						SEARCHING_ALGO_PATH + BINARY_SEARCH_ALGO_FILENAME, FileType.JAVA));
//
//		CommonMappings.algorithmEntitiesMap.put(BrKSA_ID,
//				new AlgorithmEntity(BrKSA_ID, BRUTE_FORCE_KNAP_SACK_DISPLAYNAME, AlgorithmType.KNAPSACK,
//						CommonMappings.algorithmToDataSetTypeMap.get(BrKSA_ID),
//						KNAP_SACK_ALGO_PATH + BRUTE_FORCE_KNAP_SACK_ALGO_FILENAME, FileType.JAVA));
//
//		CommonMappings.algorithmEntitiesMap.put(GrKSA_ID,
//				new AlgorithmEntity(GrKSA_ID, GREEDY_KNAP_SACK_DISPLAYNAME, AlgorithmType.KNAPSACK,
//						CommonMappings.algorithmToDataSetTypeMap.get(GrKSA_ID),
//						KNAP_SACK_ALGO_PATH + GREEDY_KNAP_SACK_ALGO_FILENAME, FileType.JAVA));
//
//		CommonMappings.algorithmEntitiesMap.put(DyKSA_ID,
//				new AlgorithmEntity(DyKSA_ID, DYNAMIC_KNAP_SACK_DISPLAYNAME, AlgorithmType.KNAPSACK,
//						CommonMappings.algorithmToDataSetTypeMap.get(DyKSA_ID),
//						KNAP_SACK_ALGO_PATH + DYNAMIC_KNAP_SACK_ALGO_FILENAME, FileType.JAVA));
//	}
}
