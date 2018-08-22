package cn.alias.weather.vo;

import cn.alias.weather.vo.City;
import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author alias.Chen
 * @date 2018/8/22 17:22
 */
@Data
@XmlRootElement(name="c")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {
    @XmlElement(name = "d")
    private List<City> cityList;
}
