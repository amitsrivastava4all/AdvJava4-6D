package com.bmpl.users.dto;

public class UserDTO {
	
	private String userid;
	private String password;
	private String userName;
	private RoleDTO roleDTO;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public RoleDTO getRoleDTO() {
		return roleDTO;
	}
	public void setRoleDTO(RoleDTO roleDTO) {
		this.roleDTO = roleDTO;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserDTO [userid=" + userid +" UserName  "+userName+" ,  password=" + password + ", roleDTO=" + roleDTO + "]";
	}
	
	

}
