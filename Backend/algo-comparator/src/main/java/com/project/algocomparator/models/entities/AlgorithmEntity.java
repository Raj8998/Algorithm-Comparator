package com.project.algocomparator.models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "algorithm")
public class AlgorithmEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "ALGORITHM_NAME_ID")
	private String algorithmNameID;
	
	@Column(name = "ALGORITHM_NAME")
	private String algorithmDisplayName;
	
	@Column(name = "ALGORITHM_TYPE")
	private String algorithmType;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="algorithm_dataset_mapping", joinColumns = @JoinColumn(name = "algorithm_id"), inverseJoinColumns = @JoinColumn(name = "dataset_id"))
	private List<DataSetEntity> datasets;
	
	@Column(name = "FILE_NAME")
	private String fileName;
	
	@Column(name = "FILE_TYPE")
	private String fileType;
	
	@Column(name = "FILE_PATH")
	private String filePath;
	
	
	public AlgorithmEntity() {
		super();
	}

	public AlgorithmEntity(String algorithmNameID, String algorithmDisplayName, String algorithmType,
			List<DataSetEntity> datasets, String fileName, String fileType, String filePath) {
		super();
		this.algorithmNameID = algorithmNameID;
		this.algorithmDisplayName = algorithmDisplayName;
		this.algorithmType = algorithmType;
		this.datasets = datasets;
		this.fileName = fileName;
		this.fileType = fileType;
		this.filePath = filePath;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAlgorithmNameID() {
		return algorithmNameID;
	}

	public void setAlgorithmNameID(String algorithmNameID) {
		this.algorithmNameID = algorithmNameID;
	}

	public String getAlgorithmDisplayName() {
		return algorithmDisplayName;
	}

	public void setAlgorithmDisplayName(String algorithmDisplayName) {
		this.algorithmDisplayName = algorithmDisplayName;
	}

	public String getAlgorithmType() {
		return algorithmType;
	}

	public void setAlgorithmType(String algorithmType) {
		this.algorithmType = algorithmType;
	}

	public List<DataSetEntity> getUsableDataSets() {
		return datasets;
	}

	public void setUsableDataSets(List<DataSetEntity> datasets) {
		this.datasets = datasets;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "AlgorithmEntity [id=" + id + ", algorithmNameID=" + algorithmNameID + ", algorithmDisplayName="
				+ algorithmDisplayName + ", algorithmType=" + algorithmType + ", usableDataSetTypes="
				+ datasets + ", fileName=" + fileName + ", fileType=" + fileType + ", filePath=" + filePath
				+ "]";
	}
}
