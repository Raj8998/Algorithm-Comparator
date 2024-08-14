package com.project.algocomparator.models.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dataset")
public class DataSetEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "DATASET_NAME_ID")
	private String dataSetNameID;
	
	@Column(name =  "DATASET_DISPLAY_NAME")
	private String dataSetDisplayName;
	
	@Column(name = "FILE_PATH")
	private String filePath;
	
	@Column(name = "FILE_NAME")
	private String fileName;
	
	@Column(name = "DATA_TYPE")
	private String dataType;
	
	@ManyToMany(mappedBy = "datasets")
	private List<AlgorithmEntity> algorithms;
	
	public DataSetEntity() {
		super();
	}

	public DataSetEntity(Integer id, String dataSetNameID, String dataSetDisplayName,
			String filePath, String fileName, String dataType, List<AlgorithmEntity> algorithms) {
		super();
		this.id = id;
		this.dataSetNameID = dataSetNameID;
		this.dataSetDisplayName = dataSetDisplayName;
		this.filePath = filePath;
		this.fileName = fileName;
		this.dataType = dataType;
		this.algorithms = algorithms;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataSetNameID() {
		return dataSetNameID;
	}

	public void setDataSetNameID(String dataSetNameID) {
		this.dataSetNameID = dataSetNameID;
	}

	public String getDataSetDisplayName() {
		return dataSetDisplayName;
	}

	public void setDataSetDisplayName(String dataSetDisplayName) {
		this.dataSetDisplayName = dataSetDisplayName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public List<AlgorithmEntity> getAlgorithms() {
		return algorithms;
	}

	public void setAlgorithms(List<AlgorithmEntity> algorithms) {
		this.algorithms = algorithms;
	}

	@Override
	public String toString() {
		return "DataSetEntity [id=" + id + ", dataSetNameID=" + dataSetNameID + ", dataSetDisplayName="
				+ dataSetDisplayName + ", filePath=" + filePath + ", fileName="
				+ fileName + ", dataType=" + dataType + ", algorithms=" + algorithms + "]";
	}
}
