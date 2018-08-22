package cn.alias.weather.service.impl;

import cn.alias.weather.service.CityDataService;
import cn.alias.weather.utils.XmlBuilder;
import cn.alias.weather.vo.City;
import cn.alias.weather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * 城市数据服务
 * @author alias.Chen
 * @date 2018/8/22 17:38
 */
@Service
public class CityDataServiceImpl implements CityDataService{
    /**
     * 获取城市数据
     * @return
     * @throws Exception
     */
    @Override
    public List<City> listCity() throws Exception {
        //读取XML文件
        Resource resource = new ClassPathResource("static/citylist.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while((line = br.readLine()) != null) {
            buffer.append(line);
        }
        br.close();
        //将xml转为Java对象
        CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class,buffer.toString());
        return cityList.getCityList();
    }
}
