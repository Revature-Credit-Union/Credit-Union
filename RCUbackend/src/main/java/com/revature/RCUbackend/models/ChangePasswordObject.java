package com.revature.RCUbackend.models;

import java.util.Objects;

public class ChangePasswordObject {
	
	String currentPassword;
	String newPassword;
	String confirmNewPassword;
	String username;
	public String getCurrentPassword() {
		return currentPassword;
	}
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}
	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public int hashCode() {
		return Objects.hash(confirmNewPassword, currentPassword, newPassword, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChangePasswordObject other = (ChangePasswordObject) obj;
		return Objects.equals(confirmNewPassword, other.confirmNewPassword)
				&& Objects.equals(currentPassword, other.currentPassword)
				&& Objects.equals(newPassword, other.newPassword) && Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "ChangePasswordObject [currentPassword=" + currentPassword + ", newPassword=" + newPassword
				+ ", confirmNewPassword=" + confirmNewPassword + ", username=" + username + "]";
	}
	public ChangePasswordObject(String currentPassword, String newPassword, String confirmNewPassword,
			String username) {
		super();
		this.currentPassword = currentPassword;
		this.newPassword = newPassword;
		this.confirmNewPassword = confirmNewPassword;
		this.username = username;
	}
	
	public ChangePasswordObject()
	{
		super();
	}

}
