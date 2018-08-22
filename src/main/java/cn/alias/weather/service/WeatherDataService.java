package cn.alias.weather.service;

import cn.alias.weather.vo.WeatherResponse;

/**
 * 天氣數據服務
 * @author alias.Chen
 * @date 2018/8/22 11:59
 */
public interface WeatherDataService {
    /**
     * 根据city ID获取天气数据
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);
    /**
     * 根据city Name获取天气数据
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);
}
