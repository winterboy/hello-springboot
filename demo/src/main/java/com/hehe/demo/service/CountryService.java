package com.hehe.demo.service;

import java.util.List;

import com.hehe.demo.model.Country;

public interface CountryService {

	List<Country> getAll();
	Country addCountry(Country country);
	Country updateCountry(Country country);
	void deleteCountryById(int id);
}
