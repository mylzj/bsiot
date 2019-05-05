package bsiotmobile.mobile.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/4/14 13:07
 */
@Service
public class RedisService {

    private Logger logger= LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    //插入缓存
    public void setRedis(String k,String v,Long s){
        redisTemplate.opsForValue().set(k,v,s, TimeUnit.SECONDS);
        logger.info("插入缓存成功");
    }

    //取缓存
    public String getRedis(String k){
        String s = redisTemplate.opsForValue().get(k);
        logger.info("取出缓存成功,该缓存信息的值为："+s);
        return s;
    }

    //清楚缓存
    public void deleteRedis(String k){
        Boolean flag = redisTemplate.delete(k);
        if(flag){
            logger.info("删除缓存成功");
        }else{
            logger.info("删除缓存失败");
        }
    }
}
