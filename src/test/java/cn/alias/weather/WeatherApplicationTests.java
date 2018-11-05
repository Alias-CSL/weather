package cn.alias.weather;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherApplicationTests {

    @Test
    public void contextLoads() {
        Jedis jedis = new Jedis("123.207.64.43",6379,132465);
        jedis.auth("8999958...***");
        jedis.set("key1212","value");
    }

}
