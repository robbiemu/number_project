package com.cooksys.number_project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.Version;

@MappedSuperclass
public class Model {
	@Id
	@GeneratedValue
	@Column(columnDefinition = "INT UNSIGNED", unique=true, nullable=false)
	long id;

    @Version
    @Column(name = "version", columnDefinition = "TINYINT")
    private int version = 0;
 
    @Column(name = "last_updated", insertable = false, updatable = false,
    		columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Generated(value=GenerationTime.ALWAYS) 
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated; 

    @Column(name="created", insertable=false, updatable=false, 
    		columnDefinition= "TIMESTAMP DEFAULT CURRENT_TIMESTAMP") 
    @Generated(value = GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP) 
    private Date created;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	public Date getLastUpdated() {
		return lastUpdated;
	}
	
	public Date getCreated() {
		return created;
	}
	
	
}
