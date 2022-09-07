package com.weatherinfo.restapi.weatherinfoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.weatherinfo.restapi.weatherinfoapi.data.WeatherDataRepository;
import com.weatherinfo.restapi.weatherinfoapi.data.WeatherInfoData;

@Service
public class WeatherInfoService {

	private WeatherDataRepository repository;

	public WeatherInfoService(WeatherDataRepository repository) {
		this.repository = repository;
	}

	public List<WeatherInfoData> retrivealldata() {
		return repository.findAll();

	}

	public WeatherInfoData addweatherdata(WeatherInfoData weatherinfodata) {
		WeatherInfoData saved = repository.save(weatherinfodata);
		return saved;
	}

	public Optional<WeatherInfoData> findbyid(Long id) {
		boolean data = repository.existsById(id);
		if (!data)
			return null;
		else {
			Optional<WeatherInfoData> weatherinfodata = repository.findById(id);
			return weatherinfodata;
		}
	}

	public boolean deletebyid(Long id) {
		boolean data = repository.existsById(id);
		if (data)
			repository.deleteById(id);
		return data;
	}
}
