package cn.alias.weather.service;

import cn.alias.weather.vo.City;

import java.util.List;

/**
 * @author alias.Chen
 * @date 2018/8/22 17:37
 */
public interface CityDataService {
    /**
     * 获取城市列表
     * @return
     * @throws Exception
     */
    List<City> listCity() throws Exception;
}
