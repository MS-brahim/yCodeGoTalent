package com.pack.controller;

import com.user.config.Config;

public class ParticipationController {

	Config config;

	public ParticipationController() {
		config = new Config("jdbc:mysql://localhost/got_talent", "root", "");
	}
	
	
}