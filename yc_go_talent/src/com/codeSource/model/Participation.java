package com.codeSource.model;

import java.io.File;
import java.sql.Timestamp;

public class Participation {
	
	private long id_user;
	private long id_category;
	private String description;
	private Timestamp  show_start_time;
	private Timestamp  show_end_time;
	private File attached_file;
	private boolean is_accepted;
	
	public Participation(long id_user, long id_category, String description, Timestamp show_start_time,
			Timestamp show_end_time, File attached_file, boolean is_accepted) {
		
		this.id_user = id_user;
		this.id_category = id_category;
		this.description = description;
		this.show_start_time = show_start_time;
		this.show_end_time = show_end_time;
		this.attached_file = attached_file;
		this.is_accepted = is_accepted;
	}
	
	public Participation() {}

	public long getId_user() {
		return id_user;
	}

	public void setId_user(long id_user) {
		this.id_user = id_user;
	}

	public long getId_category() {
		return id_category;
	}

	public void setId_category(long id_category) {
		this.id_category = id_category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getShow_start_time() {
		return show_start_time;
	}

	public void setShow_start_time(Timestamp show_start_time) {
		this.show_start_time = show_start_time;
	}

	public Timestamp getShow_end_time() {
		return show_end_time;
	}

	public void setShow_end_time(Timestamp show_end_time) {
		this.show_end_time = show_end_time;
	}

	public File getAttached_file() {
		return attached_file;
	}

	public void setAttached_file(File attached_file) {
		this.attached_file = attached_file;
	}

	public boolean isIs_accepted() {
		return is_accepted;
	}

	public void setIs_accepted(boolean is_accepted) {
		this.is_accepted = is_accepted;
	}

	@Override
	public String toString() {
		return "Participation [id_user =" + id_user + ", id_category =" + id_category + ", description =" + description
				+ ", show_start_time =" + show_start_time + ", show_end_time=" + show_end_time + ", attached_file="
				+ attached_file + ", is_accepted =" + is_accepted + "]";
	}
	
	public void addParticipation() {}
}
