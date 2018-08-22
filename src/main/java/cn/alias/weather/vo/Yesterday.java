package cn.alias.weather.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author alias.Chen
 * @date 2018/8/22 11:50
 */
@Data
public class Yesterday implements Serializable {
    private String date;
    private String high;
    private String windDirection;
    private String low;
    private String windPower;
}
