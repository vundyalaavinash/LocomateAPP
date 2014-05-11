package com.locomate.java.beans;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
@Entity
@Table(name="pic")
public class UploadFilePO {
	@Id
	@GeneratedValue
	@Column(name="idpic")
	private long id;
	@Lob
	@Column(name="img",nullable=false, 
	columnDefinition="longblob")
	 private MultipartFile  file;
	 @Lob
	    private Blob content;
	public Blob getContent() {
		return content;
	}
	public void setContent(Blob content) {
		this.content = content;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	

}
