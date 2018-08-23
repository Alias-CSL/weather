package cn.alias.weather.job;

import cn.alias.weather.service.CityDataService;
import cn.alias.weather.service.WeatherDataService;
import cn.alias.weather.vo.City;
import cn.alias.weather.vo.Weather;
import cn.alias.weather.vo.WeatherResponse;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * @author alias.Chen
 * @date 2018/8/22 16:54
 */
public class WeatherDataSyncJob extends QuartzJobBean {
    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);
    @Autowired
    private CityDataService cityDataServiceImpl;

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("测试数据同步");
        //读取城市列表
        List<City> cityList = null;
        try {
            cityList = cityDataServiceImpl.listCity();
        } catch (Exception e) {
            logger.info("获取城市信息异常！",e);
            //e.printStackTrace();
        }
        for (City city : cityList) {
            String cityId = city.getCityId();
            logger.info("天气数据同步任务中，cityId："+cityId);
            //根据城市ID获取天气
            weatherDataService.syncDataByCityId(cityId);
        }
        logger.info("End 天气数据同步任务");
    }
}
