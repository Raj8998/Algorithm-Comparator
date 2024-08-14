package com.project.algocomparator.models.dtos;

import java.util.List;

public class AlgorithmDTO {
	private String algorithmNameID;
	private String algorithmName;
	private String algorithmTypeDisplayName;
	private List<DataSetDTO> usableDataSets;
	
	public AlgorithmDTO(String algorithmNameID, String algorithmName, String algorithmTypeDisplayName,
			List<DataSetDTO> usableDataSets) {
		super();
		this.algorithmNameID = algorithmNameID;
		this.algorithmName = algorithmName;
		this.algorithmTypeDisplayName = algorithmTypeDisplayName;
		this.usableDataSets = usableDataSets;
	}

	public String getAlgorithmNameID() {
		return algorithmNameID;
	}

	public void setAlgorithmNameID(String algorithmNameID) {
		this.algorithmNameID = algorithmNameID;
	}

	public String getAlgorithmName() {
		return algorithmName;
	}

	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}

	public String getAlgorithmTypeDisplayName() {
		return algorithmTypeDisplayName;
	}

	public void setAlgorithmTypeDisplayName(String algorithmTypeDisplayName) {
		this.algorithmTypeDisplayName = algorithmTypeDisplayName;
	}

	public List<DataSetDTO> getUsableDataSets() {
		return usableDataSets;
	}

	public void setUsableDataSets(List<DataSetDTO> usableDataSets) {
		this.usableDataSets = usableDataSets;
	}

	@Override
	public String toString() {
		return "AlgorithmDTO [algorithmNameID=" + algorithmNameID + ", algorithmName=" + algorithmName
				+ ", algorithmTypeDisplayName=" + algorithmTypeDisplayName + ", usableDataSets=" + usableDataSets + "]";
	}	
}
