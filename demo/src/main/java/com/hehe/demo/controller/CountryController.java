package com.hehe.demo.controller;

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

import com.hehe.demo.model.Country;
import com.hehe.demo.service.CountryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping(value = "/country")
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	/**
	 * Get list of Countries
	 * @return
	 */
	@Operation(summary = "Get all Countries", description = "Retrieves a list of all available Countries.")
	@GetMapping("/countries")
	public List<Country> getAllCountry() {
		return countryService.getAll();
	}
	
	/**
	 * Create new Country
	 * @param country
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<Object> saveCountry(@RequestBody Country country) {
		countryService.addCountry(country);
		return new ResponseEntity<Object>("Country was created successfully", HttpStatus.OK);
	}
	
	/**
	 * Update Country by id
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<Object> updateCountry(@PathVariable("id") int id, @RequestBody Country country) {
		country.setId(id);
		countryService.updateCountry(country);
		return new ResponseEntity<Object>("Country was updated successfully", HttpStatus.OK);
	}
	
	/**
	 * Delete Country by id
	 */
	@Operation(summary = "Delete a Country", description = "Delete a Country from database.")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> updateCountry(@Parameter(description = "ID of a Country") @PathVariable("id") int id) {
		countryService.deleteCountryById(id);
		return new ResponseEntity<Object>("Country was deleted successfully", HttpStatus.OK);
	}
}
