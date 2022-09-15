package com.weatherinfo.restapi.weatherinfoapi.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weatherinfo.restapi.weatherinfoapi.data.WeatherInfoData;
import com.weatherinfo.restapi.weatherinfoapi.service.WeatherInfoService;

@RestController
public class WeatherInfoController {

	private WeatherInfoService service;

	public WeatherInfoController(WeatherInfoService service) {
		this.service = service;
	}

	@RequestMapping(value = "/weather", method = RequestMethod.GET)
	public List<WeatherInfoData> retrievealldata() {
		// return repository.findAll();
		return service.retrivealldata();

	}

	@RequestMapping(value = "/weather", method = RequestMethod.POST)
	public ResponseEntity<WeatherInfoData> addweatherdata(@RequestBody WeatherInfoData weatherInfoData) {

		WeatherInfoData saved_data = service.addweatherdata(weatherInfoData);

		return new ResponseEntity<WeatherInfoData>(saved_data, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/weather/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> retrievebyId(@PathVariable Long id) {

		Optional<WeatherInfoData> retrived_data = service.findbyid(id);
		try {
			retrived_data.get();
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(retrived_data, HttpStatus.OK);
	}

	@RequestMapping(value = "/weather/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deletebyId(@PathVariable Long id) {
		try {
			service.deletebyid(id);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}
