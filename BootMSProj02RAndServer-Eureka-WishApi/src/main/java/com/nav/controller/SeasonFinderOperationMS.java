package com.nav.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wish-api")
public class SeasonFinderOperationMS {

	@Value("${spring.application.instance-id:default}")
	private String instance_id;

	@GetMapping("/show-season")
	public ResponseEntity<String> showSeason() {
		LocalDateTime ldt = LocalDateTime.now();
		int month = ldt.getMonthValue();
		String seasonName;

		if (month >= 7 && month <= 10) {
			seasonName = "Rainy Season";
		} else if (month >= 3 && month <= 6) {
			seasonName = "Summer Season";
		} else {
			seasonName = "Winter Season";
		}

		seasonName = seasonName + " : " + instance_id;
		return new ResponseEntity<>(seasonName, HttpStatus.OK);
	}
}
