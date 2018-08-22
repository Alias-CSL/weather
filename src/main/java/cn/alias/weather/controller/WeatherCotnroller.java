package cn.alias.weather.controller;

import cn.alias.weather.service.WeatherDataService;
import cn.alias.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alias.Chen
 * @date 2018/8/22 13:53
 */
@RestController
@RequestMapping("/weather")
public class WeatherCotnroller {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("cityId/{cityId}")
    public WeatherResponse getReportByCityId(@PathVariable("cityId")String cityId) {
        return weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("cityName/{cityName}")
    public WeatherResponse getReportByCityName(@PathVariable("cityName")String cityName) {
        return weatherDataService.getDataByCityName(cityName);
    }

}
