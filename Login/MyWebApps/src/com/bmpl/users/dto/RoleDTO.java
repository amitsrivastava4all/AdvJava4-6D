package com.bmpl.users.dto;

import java.util.ArrayList;

public class RoleDTO {
	
	private String name;
	private String descr;
	private ArrayList<RightDTO> rightList;
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
	
	
	public ArrayList<RightDTO> getRightList() {
		return rightList;
	}
	public void setRightList(ArrayList<RightDTO> rightList) {
		this.rightList = rightList;
	}
	@Override
	public String toString() {
		return "RoleDTO [name=" + name + ", descr=" + descr + ", rightList=" + rightList + "]";
	}
	
	

}
