package com.hehe.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.hehe.demo.model.Country;
import com.hehe.demo.service.CountryService;

@ExtendWith(MockitoExtension.class)
public class CountryControllerTest {

	@Mock
	private CountryService countryService;
	
	@InjectMocks
	private CountryController countryController = new CountryController();
	
	@Test
	public void testGetAllCountry() {
		Country country = Country.builder()
							.id(1).name("USA").build();
		List<Country> lstCountries = Arrays.asList(country);
		when(countryService.getAll()).thenReturn(lstCountries);
		
		assertEquals(countryController.getAllCountry().size(), lstCountries.size());
	}
}
