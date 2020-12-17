package com.codeSource.model;

public class AdminSession {

	private long id;
	private long id_admin;
	private boolean isConnected;
	
	public AdminSession(long id, long id_admin, boolean isConnected) {
		super();
		this.id = id;
		this.id_admin = id_admin;
		this.isConnected = isConnected;
	}
	
	public AdminSession() {}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId_admin() {
		return id_admin;
	}
	
	public void setId_admin(long id_admin) {
		this.id_admin = id_admin;
	}
	
	public boolean isConnected() {
		return isConnected;
	}
	
	public void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}
	
	@Override
	public String toString() {
		return "AdminSession [id=" + id + ", id_admin=" + id_admin + ", isConnected=" + isConnected + "]";
	}
}
