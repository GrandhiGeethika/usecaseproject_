package com.weatherinfo.restapi.weatherinfoapi.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherDataRepository extends JpaRepository<WeatherInfoData, Long> {

}
