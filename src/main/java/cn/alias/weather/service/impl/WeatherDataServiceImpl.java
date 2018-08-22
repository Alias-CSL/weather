package cn.alias.weather.service.impl;

import cn.alias.weather.service.WeatherDataService;
import cn.alias.weather.vo.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author alias.Chen
 * @date 2018/8/22 13:41
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    org.slf4j.Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final String WEATHER_API = "http://wthrcdn.etouch.cn/weather_mini";
    //缓存超时时间
    private final Long TIME_OUT = 1800L;
    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_API + "?citykey=" +cityId;
        return this.doGetWeatherData(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_API + "?cityname" +cityName;
        return this.doGetWeatherData(uri);
    }


    private WeatherResponse doGetWeatherData(String uri) {
        ValueOperations<String,String> ops = this.stringRedisTemplate.opsForValue();
        //将调用的uri作为缓存的key
        String key = uri;
        String strBody = null;
        //先查缓存，如果没有再查服务
        if(!stringRedisTemplate.hasKey(key)) {
            logger.info("未找到key："+key);
            ResponseEntity<String> response = restTemplate.getForEntity(uri,String.class);
            if(response.getStatusCodeValue() == 200){
                strBody = response.getBody();
            }
            ops.set(key,strBody,TIME_OUT, TimeUnit.SECONDS);
        }else{
            logger.info("找到key "+key+" value= "+ops.get(key));
            strBody = ops.get(key);
        }
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weatherResponse = null;
        try {
            weatherResponse = mapper.readValue(strBody,WeatherResponse.class);
        } catch (IOException e) {
            logger.error("Json反序列化异常",e);
            //e.printStackTrace();
        }
        return weatherResponse;
        /*ResponseEntity<String> response = restTemplate.getForEntity(uri,String.class);
        String strBody = "";
        if(response.getStatusCodeValue() == 200) {
            try {
                strBody = response.getBody();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResponse weatherResponse = null;
        try {
            weatherResponse = objectMapper.readValue(strBody,WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherResponse;*/
    }

    
}
