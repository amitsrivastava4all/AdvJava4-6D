package com.bmpl.users.dto;

public class RightDTO {
	private String name;
	private String descr;
	private String url;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "RightDTO [name=" + name + ", descr=" + descr + ", url=" + url + "]";
	}
	
}
