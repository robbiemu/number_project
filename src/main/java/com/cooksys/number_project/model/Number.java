package com.cooksys.number_project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Number")
public class Number extends Model {
	@Column(columnDefinition = "INT") Integer nindex;
	@Column(columnDefinition = "INT") Integer nnumber;
	

	public Integer getNindex() {
		return nindex;
	}
	public void setNindex(Integer nindex) {
		this.nindex = nindex;
	}
	
	public Integer getNnumber() {
		return nnumber;
	}
	public void setNnumber(Integer nnumber) {
		this.nnumber = nnumber;
	}
	
	public int increment(){
		return ++nnumber;
	}
	public int decrement(){
		return --nnumber;
	}
	
}
