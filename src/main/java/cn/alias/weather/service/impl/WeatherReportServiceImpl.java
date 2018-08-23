package cn.alias.weather.service.impl;

import cn.alias.weather.service.WeatherDataService;
import cn.alias.weather.service.WeatherReportService;
import cn.alias.weather.vo.Weather;
import cn.alias.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {
    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public Weather getDataByCityId(String cityID) {
        WeatherResponse response = weatherDataService.getDataByCityId(cityID);
        return response.getData();
    }
}
