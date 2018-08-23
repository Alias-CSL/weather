package cn.alias.weather.service;

import cn.alias.weather.vo.Weather;

public interface WeatherReportService {
    /**
     * 根据城市ID获取数据
     * @param cityID
     * @return
     */
    Weather getDataByCityId(String cityID);
}
