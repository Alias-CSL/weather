package cn.alias.weather.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author alias.Chen
 * @date 2018/8/22 11:56
 */
@Data
public class WeatherResponse implements Serializable {
    private Weather data;
    private String status;
    private String desc;
}
