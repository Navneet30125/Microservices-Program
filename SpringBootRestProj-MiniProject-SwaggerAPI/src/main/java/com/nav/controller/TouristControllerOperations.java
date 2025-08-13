package com.nav.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nav.entity.Tourist;
import com.nav.service.ITouristMgmtService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/tourist")
@Tag(name="Tourist", description="Tourist Operations controller")
public class TouristControllerOperations {
	@Autowired
	private ITouristMgmtService service;

	@Operation(summary="save the toursit info", description="persist the tourist info")
	@ApiResponses(value= {
			@ApiResponse(responseCode="201", description="toursit saved", 
					content= {@Content(mediaType="application/json",
					schema= @Schema(implementation=Tourist.class))})})
	@PostMapping("/register")
	public ResponseEntity<String> regTourist(@RequestBody Tourist toursit) {
		try {
			String msg = service.registerTourist(toursit);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("problem in tourist enrollment", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> getAllTourist() {
		try {
			List<Tourist> tList= service.fetchAllTourist();
			return new ResponseEntity<List<Tourist>>(tList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("problem in fetching tourist", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getTourist(@PathVariable Integer id) {
		   try {
			   Tourist fetchTouristById = service.fetchTouristById(id);
			return new ResponseEntity<Tourist>(fetchTouristById, HttpStatus.OK);
		   }
		 catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateTourist(@RequestBody Tourist tourist){
		   try {
			  String msg = service.updateTouristDetails(tourist);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		   }
		 catch (Exception e) {
			 e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/findByName/{name}")
	public ResponseEntity<?> findTouristByName(@PathVariable String name){
		   try {
			  List<Tourist> listTouristByName = service.findAllTouristDetailsByName(name);
			return new ResponseEntity<List<Tourist>>(listTouristByName, HttpStatus.OK);
		   }
		 catch (Exception e) {
			 e.printStackTrace();
			return new ResponseEntity<String>("Name is not found...", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updateBudget/{tid}/{hikePercentage}")
	public ResponseEntity<?> updateTouristBudget(@PathVariable int tid, @PathVariable double hikePercentage){
		   try {
			String updateBudgetById = service.updateBudgetById(tid, hikePercentage);
			return new ResponseEntity<String>(updateBudgetById, HttpStatus.OK);
		   }
		 catch (Exception e) {
			 e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/deleteTourist/{id}")
	public ResponseEntity<String> deleteTouristById(@PathVariable int id){
		  try {
				String deleteById = service.removeTouristById(id);
				return new ResponseEntity<String>(deleteById, HttpStatus.OK);
			   }
			 catch (Exception e) {
				 e.printStackTrace();
				return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
}