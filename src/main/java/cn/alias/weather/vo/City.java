package cn.alias.weather.vo;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author alias.Chen
 * @date 2018/8/22 17:14
 */
@XmlRootElement(name ="c")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class City {
    @XmlAttribute(name="d1")
    private String cityId;

    @XmlAttribute(name="d2")
    private String cityName;

    @XmlAttribute(name="d3")
    private String cityCode;

    @XmlAttribute(name="d4")
    private String privince;
}
