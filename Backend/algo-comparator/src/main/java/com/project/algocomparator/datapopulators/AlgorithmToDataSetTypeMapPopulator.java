package com.project.algocomparator.datapopulators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.project.algocomparator.configurations.CommonMappings;
import com.project.algocomparator.constants.GlobalConstants;
import com.project.algocomparator.models.enums.DataSetType;

//@Configuration(value = "algorithmToDataSetTypeMapPopulator")
public class AlgorithmToDataSetTypeMapPopulator {

//	public AlgorithmToDataSetTypeMapPopulator() {
//		List<DataSetType> dataSetTypesForSorting = generateDataSetTypesForSorting();
//		CommonMappings.algorithmToDataSetTypeMap.put(GlobalConstants.SSA_ID, dataSetTypesForSorting);
//		CommonMappings.algorithmToDataSetTypeMap.put(GlobalConstants.MSA_ID, dataSetTypesForSorting);
//		CommonMappings.algorithmToDataSetTypeMap.put(GlobalConstants.BSA_ID, dataSetTypesForSorting);
//
//		List<DataSetType> dataSetTypesForSearching = generateDataSetTypesForSearching();
//		CommonMappings.algorithmToDataSetTypeMap.put(GlobalConstants.LSeA_ID, dataSetTypesForSearching);
//		CommonMappings.algorithmToDataSetTypeMap.put(GlobalConstants.BSeA_ID, dataSetTypesForSearching);
//
//		List<DataSetType> dataSetTypesForKnapSack = generateDataSetTypesForKnapSack();
//		CommonMappings.algorithmToDataSetTypeMap.put(GlobalConstants.BrKSA_ID, dataSetTypesForKnapSack);
//		CommonMappings.algorithmToDataSetTypeMap.put(GlobalConstants.GrKSA_ID, dataSetTypesForKnapSack);
//		CommonMappings.algorithmToDataSetTypeMap.put(GlobalConstants.DyKSA_ID, dataSetTypesForKnapSack);
//	}
//
//	public List<DataSetType> generateDataSetTypesForSorting() {
//		List<DataSetType> dataSetTypesForSorting = new ArrayList<DataSetType>();
//		dataSetTypesForSorting.add(DataSetType.RANDOM_UNIQUE_POSITIVE_INT);
//		dataSetTypesForSorting.add(DataSetType.RANDOM_UNIQUE_NEGATIVE_INT);
//		dataSetTypesForSorting.add(DataSetType.RANDOM_UNIQUE_MIX_INT);
//		dataSetTypesForSorting.add(DataSetType.RANDOM_UNIQUE_FLOAT);
//		dataSetTypesForSorting.add(DataSetType.RANDOM_REPEATIVE_POSITIVE_INT);
//		dataSetTypesForSorting.add(DataSetType.RANDOM_REPEATIVE_NEGATIVE_INT);
//		dataSetTypesForSorting.add(DataSetType.RANDOM_REPEATIVE_MIX_INT);
//		dataSetTypesForSorting.add(DataSetType.RANDOM_REPEATIVE_FLOAT);
//
//		dataSetTypesForSorting.add(DataSetType.SORTED_UNIQUE_POSITIVE_INT);
//		dataSetTypesForSorting.add(DataSetType.SORTED_UNIQUE_NEGATIVE_INT);
//		dataSetTypesForSorting.add(DataSetType.SORTED_UNIQUE_MIX_INT);
//		dataSetTypesForSorting.add(DataSetType.SORTED_UNIQUE_FLOAT);
//		dataSetTypesForSorting.add(DataSetType.SORTED_REPEATIVE_POSITIVE_INT);
//		dataSetTypesForSorting.add(DataSetType.SORTED_REPEATIVE_NEGATIVE_INT);
//		dataSetTypesForSorting.add(DataSetType.SORTED_REPEATIVE_MIX_INT);
//		dataSetTypesForSorting.add(DataSetType.SORTED_REPEATIVE_FLOAT);
//
//		return dataSetTypesForSorting;
//	}
//
//	public List<DataSetType> generateDataSetTypesForSearching() {
//		List<DataSetType> dataSetTypesForSearching = new ArrayList<DataSetType>();
//		dataSetTypesForSearching.add(DataSetType.SORTED_UNIQUE_POSITIVE_INT);
//		dataSetTypesForSearching.add(DataSetType.SORTED_UNIQUE_NEGATIVE_INT);
//		dataSetTypesForSearching.add(DataSetType.SORTED_UNIQUE_MIX_INT);
//		dataSetTypesForSearching.add(DataSetType.SORTED_UNIQUE_FLOAT);
//		dataSetTypesForSearching.add(DataSetType.SORTED_REPEATIVE_POSITIVE_INT);
//		dataSetTypesForSearching.add(DataSetType.SORTED_REPEATIVE_NEGATIVE_INT);
//		dataSetTypesForSearching.add(DataSetType.SORTED_REPEATIVE_MIX_INT);
//		dataSetTypesForSearching.add(DataSetType.SORTED_REPEATIVE_FLOAT);
//		return dataSetTypesForSearching;
//	}
//
//	public List<DataSetType> generateDataSetTypesForKnapSack() {
//		List<DataSetType> dataSetTypesForKnapSack = new ArrayList<DataSetType>();
//		dataSetTypesForKnapSack.add(DataSetType.UNRELATED_KNAPSACK_PROBLEM);
//		dataSetTypesForKnapSack.add(DataSetType.WEAKLY_CORELATED_KNAPSACK_PROBLEM);
//		dataSetTypesForKnapSack.add(DataSetType.STRONGLY_CORELATED_KNAPSACK_PROBLEM);
//		return dataSetTypesForKnapSack;
//	}

}
