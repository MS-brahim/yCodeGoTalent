package com.youcode.models;

import java.security.Timestamp;

public class Participation {

	private Long id_user;
	private Long id_category;
	private Timestamp show_start_time;
	private Timestamp show_end_time;
	private String attached_file;
	private boolean is_accepted;

	public Participation(Long id_user, Long id_category, Timestamp show_start_time, Timestamp show_end_time,
			String attached_file, boolean is_accepted) {
		this.id_user = id_user;
		this.id_category = id_category;
		this.show_start_time = show_start_time;
		this.show_end_time = show_end_time;
		this.attached_file = attached_file;
		this.is_accepted = is_accepted;
	}

	public Participation() {
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public Long getId_category() {
		return id_category;
	}

	public void setId_category(Long id_category) {
		this.id_category = id_category;
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

	public String getAttached_file() {
		return attached_file;
	}

	public void setAttached_file(String attached_file) {
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
		return "Participation [id_user=" + id_user + ", id_category=" + id_category + ", show_start_time="
				+ show_start_time + ", show_end_time=" + show_end_time + ", attached_file=" + attached_file
				+ ", is_accepted=" + is_accepted + "]";
	}

}
