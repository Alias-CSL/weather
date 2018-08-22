package cn.alias.weather.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;

/**
 * XML工具类
 * @author alias.Chen
 * @date 2018/8/22 17:24
 */
public class XmlBuilder {
    /**
     * 将XML字符串转换为对应的POJO对象
     * @param clazz
     * @param xmlStr
     * @return
     * @throws Exception
     */
    public static Object xmlStrToObject(Class<?> clazz,String xmlStr) throws Exception {
        Object xmlObject = null;
        Reader reader = null;

        JAXBContext context = JAXBContext.newInstance(clazz);

        //将Xml转成对象的核心接口
        Unmarshaller unmarshaller = context.createUnmarshaller();
        if(null != reader) {
            reader.close();
        }
        return xmlObject;
    }
}
