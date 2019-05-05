package bsiotmobile.mobile.controller;

import cn.usr.service.UsrcloudApi;
import cn.usr.service.UsrcloudMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Demo class
 *移动和管理端对底层的数据通信
 * @author drose
 * @date 2019/2/26 22:34
 */
@Controller
@CrossOrigin
@RequestMapping("/v1/admin/usrCloud")
public class PcUsrCloudController {
    private Logger logger= LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private UsrcloudMqttClient usrcloudMqttClient;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    private String deviceId="356566078215258";

    //连接函数，暂时不用
    @RequestMapping(value = "/connect",method = RequestMethod.POST)
    @ResponseBody
    public void connect() throws MqttException {
        usrcloudMqttClient.connect();

    }
    //订阅函数
    @RequestMapping(value = "/sub",method = RequestMethod.POST)
    @ResponseBody
    public void sub() throws MqttException {
        usrcloudMqttClient.subscribeForDevId(deviceId);
    }
    //开锁
    @RequestMapping(value = "/onClock",method = RequestMethod.POST)
    @ResponseBody
    public void onClock() throws MqttException {
        byte[] bytes=new byte[10];
        //这里与底层自定义的协议一致，发动个-字符代表开门
        bytes[0]='-';
        //调用有人物联云发送接口，参数要求要有设备号和内容
        usrcloudMqttClient.publishForDevId("356566078222460",bytes);

    }

    //上锁
    @RequestMapping(value = "/unClock",method = RequestMethod.POST)
    @ResponseBody
    public void unClock() throws MqttException {
        byte[] bytes=new byte[10];
        bytes[0]='+';
        usrcloudMqttClient.publishForDevId("356566078222460",bytes);

    }

    //测试用的
    @RequestMapping(value = "/confirm",method = RequestMethod.POST)
    @ResponseBody
    public void confirm() throws MqttException {
//        byte[] bytes=new byte[10];
//        bytes[0]='$';
//        usrcloudMqttClient.publishForDevId("356566078222460",bytes);
        redisTemplate.opsForValue().set("user","lzj");
    }
}
