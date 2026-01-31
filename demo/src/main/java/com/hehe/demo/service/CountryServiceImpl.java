package com.hehe.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hehe.demo.model.Country;
import com.hehe.demo.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	@Override
	public List<Country> getAll() {
		return countryRepository.findAll();
	}

	@Override
	public Country addCountry(Country country) {
		String name = country.getName();
		return countryRepository.save(new Country(name));
//		countryRepository.save(null);
//		return null;
	}

	@Override
	public Country updateCountry(Country country) {
		return countryRepository.save(country);
	}

	@Override
	public void deleteCountryById(int id) {
		countryRepository.deleteById(id);
	}

}
