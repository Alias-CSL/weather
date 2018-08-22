package cn.alias.weather.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author alias.Chen
 * @date 2018/8/22 11:47
 */
@Data
public class Weather implements Serializable {
   private  String city;
   private String aqi;
   private String wendu;
   private String ganmao;
   private Yesterday yesterday;
   private List<Forecast> forecast;
}
