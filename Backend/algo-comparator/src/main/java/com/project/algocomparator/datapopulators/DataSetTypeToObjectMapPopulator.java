package com.project.algocomparator.datapopulators;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.project.algocomparator.configurations.CommonMappings;
import com.project.algocomparator.models.entities.DataSetEntity;
import com.project.algocomparator.models.enums.DataSetType;
import com.project.algocomparator.models.enums.DataType;

//@Configuration(value = "dataSetTypeToObjectMapPopulator")
//@DependsOn(value = { "commonMappings" })
public class DataSetTypeToObjectMapPopulator {
//	public DataSetTypeToObjectMapPopulator() {
//		CommonMappings.dataSetTypeEnumToObjectMap.put(DataSetType.RANDOM_UNIQUE_POSITIVE_INT,
//				new DataSetEntity("RUPI", "Random and Unique Positive Integers", DataSetType.RANDOM_UNIQUE_POSITIVE_INT,
//						"datasets/random/unique/positive", DataType.INT));
//		CommonMappings.dataSetTypeEnumToObjectMap.put(DataSetType.RANDOM_UNIQUE_NEGATIVE_INT,
//				new DataSetEntity("RUNI", "Random and Unique Negative Integers", DataSetType.RANDOM_UNIQUE_NEGATIVE_INT,
//						"datasets/random/unique/negative", DataType.INT));
//		CommonMappings.dataSetTypeEnumToObjectMap.put(DataSetType.RANDOM_UNIQUE_MIX_INT,
//				new DataSetEntity("RUMI", "Random and Unique Positive and Negative Integers",
//						DataSetType.RANDOM_UNIQUE_MIX_INT, "datasets/random/unique/mix", DataType.INT));
//		CommonMappings.dataSetTypeEnumToObjectMap.put(DataSetType.RANDOM_UNIQUE_FLOAT,
//				new DataSetEntity("RUF", "Random and Unique Positive and Negative Floats",
//						DataSetType.RANDOM_UNIQUE_FLOAT, "datasets/random/unique/float", DataType.FLOAT));
//
//		CommonMappings.dataSetTypeEnumToObjectMap.put(DataSetType.RANDOM_REPEATIVE_POSITIVE_INT,
//				new DataSetEntity("RRPI", "Random and Repeative Positive Integers",
//						DataSetType.RANDOM_REPEATIVE_POSITIVE_INT, "datasets/random/repeative/positive", DataType.INT));
//		CommonMappings.dataSetTypeEnumToObjectMap.put(DataSetType.RANDOM_REPEATIVE_NEGATIVE_INT,
//				new DataSetEntity("RRNI", "Random and Repeative Negative Integers",
//						DataSetType.RANDOM_REPEATIVE_NEGATIVE_INT, "datasets/random/repeative/negative", DataType.INT));
//		CommonMappings.dataSetTypeEnumToObjectMap.put(DataSetType.RANDOM_REPEATIVE_MIX_INT,
//				new DataSetEntity("RRMI", "Random and Repeative Positive and Negative Integers",
//						DataSetType.RANDOM_REPEATIVE_MIX_INT, "datasets/random/repeative/mix", DataType.INT));
//		CommonMappings.dataSetTypeEnumToObjectMap.put(DataSetType.RANDOM_REPEATIVE_FLOAT,
//				new DataSetEntity("RRF", "Random and Repeative Positive and Negative Floats",
//						DataSetType.RANDOM_REPEATIVE_FLOAT, "datasets/random/repeative/float", DataType.FLOAT));
//
//		CommonMappings.dataSetTypeEnumToObjectMap.put(DataSetType.SORTED_UNIQUE_POSITIVE_INT,
//				new DataSetEntity("SUPI", "Sorted and Unique Positive Integers", DataSetType.SORTED_UNIQUE_POSITIVE_INT,
//						"datasets/sorted/unique/positive", DataType.INT));
//		CommonMappings.dataSetTypeEnumToObjectMap.put(DataSetType.SORTED_UNIQUE_NEGATIVE_INT,
//				new DataSetEntity("SUNI", "Sorted and Unique Negative Integers", DataSetType.SORTED_UNIQUE_NEGATIVE_INT,
//						"datasets/sorted/unique/negative", DataType.INT));
//		CommonMappings.dataSetTypeEnumToObjectMap.put(DataSetType.SORTED_UNIQUE_MIX_INT,
//				new DataSetEntity("SUMI", "Sorted and Unique Positive and Negative Integers",
//						DataSetType.SORTED_UNIQUE_MIX_INT, "datasets/sorted/unique/mix", DataType.INT));
//		CommonMappings.dataSetTypeEnumToObjectMap.put(DataSetType.SORTED_UNIQUE_FLOAT,
//				new DataSetEntity("SUF", "Sorted and Unique Positive and Negative Floats",
//						DataSetType.SORTED_UNIQUE_FLOAT, "datasets/sorted/unique/float", DataType.FLOAT));
//
//		CommonMappings.dataSetTypeEnumToObjectMap.put(DataSetType.SORTED_REPEATIVE_POSITIVE_INT,
//				new DataSetEntity("SRPI", "Sorted and Repeative Positive Integers",
//						DataSetType.SORTED_REPEATIVE_POSITIVE_INT, "datasets/sorted/repeative/positive", DataType.INT));
//		CommonMappings.dataSetTypeEnumToObjectMap.put(DataSetType.SORTED_REPEATIVE_NEGATIVE_INT,
//				new DataSetEntity("SRNI", "Sorted and Repeative Negative Integers",
//						DataSetType.SORTED_REPEATIVE_NEGATIVE_INT, "datasets/sorted/repeative/negative", DataType.INT));
//		CommonMappings.dataSetTypeEnumToObjectMap.put(DataSetType.SORTED_REPEATIVE_MIX_INT,
//				new DataSetEntity("SRMI", "Sorted and Repeative Positive and Negative Integers",
//						DataSetType.SORTED_REPEATIVE_MIX_INT, "datasets/sorted/repeative/mix", DataType.INT));
//		CommonMappings.dataSetTypeEnumToObjectMap.put(DataSetType.SORTED_REPEATIVE_FLOAT,
//				new DataSetEntity("SRF", "Sorted and Repeative Positive and Negative Floats",
//						DataSetType.SORTED_REPEATIVE_FLOAT, "datasets/sorted/repeative/float", DataType.FLOAT));
//		
//		CommonMappings.dataSetTypeEnumToObjectMap.put(DataSetType.UNRELATED_KNAPSACK_PROBLEM,
//				new DataSetEntity("UKP", "Unrelated KnapSack Problem",
//						DataSetType.UNRELATED_KNAPSACK_PROBLEM, "datasets/knapSack/unrelated", DataType.INT));
//		CommonMappings.dataSetTypeEnumToObjectMap.put(DataSetType.WEAKLY_CORELATED_KNAPSACK_PROBLEM,
//				new DataSetEntity("WCKP", "Weakly Corelated KnapSack Problem",
//						DataSetType.WEAKLY_CORELATED_KNAPSACK_PROBLEM, "datasets/knapSack/weaklyCorelated", DataType.INT));
//		CommonMappings.dataSetTypeEnumToObjectMap.put(DataSetType.STRONGLY_CORELATED_KNAPSACK_PROBLEM,
//				new DataSetEntity("SCKP", "Strongly Corelated KnapSack Problem",
//						DataSetType.STRONGLY_CORELATED_KNAPSACK_PROBLEM, "datasets/knapSack/stronglyCorelated", DataType.INT));
//	}
}
