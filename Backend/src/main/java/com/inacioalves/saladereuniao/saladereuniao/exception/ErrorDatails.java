package com.inacioalves.saladereuniao.saladereuniao.exception;

import java.util.Date;

public class ErrorDatails {
	
	private Date timestanp;
	private String messagen;
	private String datails;
	
	public ErrorDatails(Date timestanp, String messagen, String datails) {
		super();
		this.timestanp = timestanp;
		this.messagen = messagen;
		this.datails = datails;
	}

	public Date getTimestanp() {
		return timestanp;
	}

	public void setTimestanp(Date timestanp) {
		this.timestanp = timestanp;
	}

	public String getMessagen() {
		return messagen;
	}

	public void setMessagen(String messagen) {
		this.messagen = messagen;
	}

	public String getDatails() {
		return datails;
	}

	public void setDatails(String datails) {
		this.datails = datails;
	}
	
	
	

}
