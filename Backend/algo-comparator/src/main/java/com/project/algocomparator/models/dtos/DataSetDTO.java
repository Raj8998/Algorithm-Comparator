package com.project.algocomparator.models.dtos;

public class DataSetDTO {
	private String dataSetID;
	private String dataSetDisplayName;
	
	public DataSetDTO(String dataSetID, String dataSetDisplayName) {
		super();
		this.dataSetID = dataSetID;
		this.dataSetDisplayName = dataSetDisplayName;
	}

	public String getDataSetID() {
		return dataSetID;
	}

	public void setDataSetID(String dataSetID) {
		this.dataSetID = dataSetID;
	}

	public String getDataSetDisplayName() {
		return dataSetDisplayName;
	}

	public void setDataSetDisplayName(String dataSetDisplayName) {
		this.dataSetDisplayName = dataSetDisplayName;
	}

	@Override
	public String toString() {
		return "DataSetDTO [dataSetID=" + dataSetID + ", dataSetDisplayName=" + dataSetDisplayName + "]";
	}
}
