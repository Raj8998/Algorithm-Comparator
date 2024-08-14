package com.project.algocomparator.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

import com.project.algocomparator.algorithms.knapsack.BruteForce;
import com.project.algocomparator.algorithms.knapsack.GreedyApproach;
import com.project.algocomparator.algorithms.knapsack.OptimizedDynamicApproach;
import com.project.algocomparator.algorithms.searching.BinarySearch;
import com.project.algocomparator.algorithms.searching.LinearSearch;
import com.project.algocomparator.algorithms.sorting.BubbleSort;
import com.project.algocomparator.algorithms.sorting.MergeSort;
import com.project.algocomparator.algorithms.sorting.SelectionSort;
import com.project.algocomparator.configurations.CommonMappings;
import com.project.algocomparator.constants.GlobalConstants;
import com.project.algocomparator.models.entities.AlgorithmEntity;
import com.project.algocomparator.models.entities.DataSetEntity;
import com.project.algocomparator.models.enums.AlgorithmType;
import com.project.algocomparator.models.enums.DataType;

public class ThreadRunnerService extends Thread {

	private DataSetEntity dataSet;
	private AlgorithmEntity algorithmEntity;

	public ThreadRunnerService(DataSetEntity dataSet, AlgorithmEntity algorithmEntity) {
		super();
		this.dataSet = dataSet;
		this.algorithmEntity = algorithmEntity;
	}

	@Override
	public void run() {
		List<String> filePaths = getFileNames(getDataSet().getFilePath());
		CommonMappings.LOCK.lock();
		CommonMappings.ALGORITHM_EXECUTION_TIME_CACHE.setTestCases(filePaths.size());
		CommonMappings.LOCK.unlock();
		boolean isIntTypeData = getDataSet().getDataType().compareTo(DataType.INT) == 0 ? true : false;
		boolean isKnapSackProblem = getAlgorithmEntity().getAlgorithmType().compareTo(AlgorithmType.KNAPSACK) == 0 ? true
				: false;
		Long totalExecutionTime = 0L;
		for (String filePath : filePaths) {
			System.out.println(getAlgorithmEntity().getAlgorithmDisplayName() + ": " + filePath);
			Long start = System.currentTimeMillis();
			Map<String, String> knapSackData = new HashMap<String, String>();
			int[] data = new int[] { 1 };
			float[] dataFloat = new float[] { (float) 1.0 };
			try {
				if (isKnapSackProblem)
					knapSackData = getKnapSackData(filePath);
				else if (isIntTypeData)
					data = getIntData(filePath);
				else
					dataFloat = getFloatData(filePath);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			if (getAlgorithmEntity().getAlgorithmType().compareTo(AlgorithmType.SORT) == 0) {
				if (isIntTypeData)
					handleSortingAlgo(data);
				else
					handleSortingAlgo(dataFloat);
			} else if (getAlgorithmEntity().getAlgorithmType().compareTo(AlgorithmType.SEARCH) == 0) {
				if (isIntTypeData)
					handleSearchingAlgo(data);
				else
					handleSearchingAlgo(dataFloat);
			} else {
				handleKnapSackAlgo(knapSackData);
			}
			Long end = System.currentTimeMillis();
			Long executionTime = end - start;
			totalExecutionTime += executionTime;
			if (totalExecutionTime < 60000L) {
				CommonMappings.LOCK.lock();
				if (CommonMappings.ALGORITHM_EXECUTION_TIME_CACHE.getExecutionTimeMap()
						.containsKey(getAlgorithmEntity().getAlgorithmNameID()))
					if (!isKnapSackProblem) {
						CommonMappings.ALGORITHM_EXECUTION_TIME_CACHE.getExecutionTimeMap()
								.get(getAlgorithmEntity().getAlgorithmNameID())
								.put(String.valueOf(isIntTypeData? data.length : dataFloat.length), executionTime);
					} else {
						CommonMappings.ALGORITHM_EXECUTION_TIME_CACHE.getExecutionTimeMap()
								.get(getAlgorithmEntity().getAlgorithmNameID())
								.put(String.valueOf(knapSackData.get(GlobalConstants.MAX_ELEM)), executionTime);
					}
				else {
					Map<String, Long> executionTimeMap = new ConcurrentHashMap<String, Long>();
					if (!isKnapSackProblem) {
						executionTimeMap.put(String.valueOf(isIntTypeData? data.length : dataFloat.length), executionTime);
					} else {
						executionTimeMap.put(String.valueOf(knapSackData.get(GlobalConstants.MAX_ELEM)), executionTime);
					}
					CommonMappings.ALGORITHM_EXECUTION_TIME_CACHE.getExecutionTimeMap()
							.put(getAlgorithmEntity().getAlgorithmNameID(), executionTimeMap);
				}
				CommonMappings.LOCK.unlock();
			} else {
				System.out.println("Stopping thread due to timeout");
				break;
			}
		}
		System.out.println(getAlgorithmEntity().getAlgorithmDisplayName() + ": " + "Exitted");
	}

	public List<String> getFileNames(String path) {
		System.out.println(path);
		File[] listOfFiles = new File(new ClassPathResource(path).getPath()).listFiles();
		List<String> fileNames = new ArrayList<String>();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				fileNames.add(file.getPath());
			}
		}
		return fileNames;
	}

	public int[] getIntData(String path) throws IOException {
		@SuppressWarnings("deprecation")
		String[] data = FileUtils.readFileToString(new File(new ClassPathResource(path).getPath())).split(",");
		int[] intData = new int[data.length];
		for (int i = 0; i < data.length; i++) {
			intData[i] = Integer.parseInt(data[i]);
		}
		return intData;
	}

	public float[] getFloatData(String path) throws IOException {
		@SuppressWarnings("deprecation")
		String[] data = FileUtils.readFileToString(new File(new ClassPathResource(path).getPath())).split(",");
		float[] intData = new float[data.length];
		for (int i = 0; i < data.length; i++) {
			intData[i] = Float.parseFloat(data[i]);
		}
		return intData;
	}

	public Map<String, String> getKnapSackData(String path) throws FileNotFoundException {
		Map<String, String> knapSackData = new HashMap<String, String>();
		BufferedReader knapSackFile = new BufferedReader(
				new FileReader(new File(new ClassPathResource(path).getPath())));
		boolean isFirstLine = true;
		boolean isFirstvalue = true;
		String weights = "";
		String values = "";
		for (String line : knapSackFile.lines().collect(Collectors.toList())) {
			String[] data = line.split(" ");
			if (isFirstLine) {
				knapSackData.put(GlobalConstants.MAX_ELEM, data[0]);
				knapSackData.put(GlobalConstants.MAX_WEIGHT, data[1]);
				isFirstLine = false;
			} else {
				if (!isFirstvalue) {
					values = values + ",";
					weights = weights + ",";
				}
				isFirstvalue = false;
				values = values + data[0];
				weights = weights + data[1];
			}
		}
		knapSackData.put(GlobalConstants.WEIGHT, weights);
		knapSackData.put(GlobalConstants.VALUE, values);
		return knapSackData;
	}

	public void handleSortingAlgo(int[] data) {
		switch (getAlgorithmEntity().getAlgorithmNameID()) {
		case GlobalConstants.SSA_ID:
			SelectionSort.sort(data);
			break;
		case GlobalConstants.MSA_ID:
			MergeSort.sort(data, 0, data.length - 1);
			break;
		case GlobalConstants.BSA_ID:
			BubbleSort.sort(data, data.length);
			break;
		}
	}

	public void handleSortingAlgo(float[] data) {
		switch (getAlgorithmEntity().getAlgorithmNameID()) {
		case GlobalConstants.SSA_ID:
			SelectionSort.sort(data);
			break;
		case GlobalConstants.MSA_ID:
			MergeSort.sort(data, 0, data.length - 1);
			break;
		case GlobalConstants.BSA_ID:
			BubbleSort.sort(data, data.length);
			break;
		}
	}

	public void handleSearchingAlgo(int[] data) {
		switch (getAlgorithmEntity().getAlgorithmNameID()) {
		case GlobalConstants.LSeA_ID:
			LinearSearch.search(data, data.length, data[data.length - 1]);
			break;
		case GlobalConstants.BSeA_ID:
			BinarySearch.search(data, 0, data.length - 1, data[data.length - 1]);
			break;
		}
	}

	public void handleSearchingAlgo(float[] data) {
		switch (getAlgorithmEntity().getAlgorithmNameID()) {
		case GlobalConstants.LSeA_ID:
			LinearSearch.search(data, data.length, data[data.length - 1]);
			break;
		case GlobalConstants.BSeA_ID:
			BinarySearch.search(data, 0, data.length - 1, data[data.length - 1]);
			break;
		}
	}

	public void handleKnapSackAlgo(Map<String, String> knapSackData) {
		int maxWeight = Integer.parseInt(knapSackData.get(GlobalConstants.MAX_WEIGHT));
		int maxElem = Integer.parseInt(knapSackData.get(GlobalConstants.MAX_ELEM));
		int[] weights = new int[maxElem];
		int[] values = new int[maxElem];

		int i = 0;
		for (String weight : knapSackData.get(GlobalConstants.WEIGHT).split(",")) {
			weights[i] = Integer.parseInt(weight);
			i++;
		}

		i = 0;
		for (String value : knapSackData.get(GlobalConstants.VALUE).split(",")) {
			values[i] = Integer.parseInt(value);
			i++;
		}

		switch (getAlgorithmEntity().getAlgorithmNameID()) {
		case GlobalConstants.BrKSA_ID:
			BruteForce.knapSack(maxWeight, weights, values, maxElem);
			break;
		case GlobalConstants.GrKSA_ID:
			GreedyApproach.knapSack(maxWeight, weights, values, maxElem);
			break;
		case GlobalConstants.DyKSA_ID:
			OptimizedDynamicApproach.knapSack(maxWeight, weights, values, maxElem);
			break;
		}
	}

	public DataSetEntity getDataSet() {
		return dataSet;
	}

	public void setDataSet(DataSetEntity dataSet) {
		this.dataSet = dataSet;
	}

	public AlgorithmEntity getAlgorithmEntity() {
		return algorithmEntity;
	}

	public void setAlgorithmEntity(AlgorithmEntity algorithmEntity) {
		this.algorithmEntity = algorithmEntity;
	}

}
