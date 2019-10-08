//package bsiotmobile.mobile.service.Impl;
//
//import bsiotmobile.mobile.common.GetUUID;
//import bsiotmobile.mobile.common.WebSocketServer;
//import bsiotmobile.mobile.eo.NbCard;
//import bsiotmobile.mobile.eo.PcHumit;
//import bsiotmobile.mobile.eo.PcTemp;
//import bsiotmobile.mobile.mapper.NbCardMapper;
//import bsiotmobile.mobile.mapper.PcHumitMapper;
//import bsiotmobile.mobile.mapper.PcTempMapper;
//import bsiotmobile.mobile.mapper.PcrUserMapper;
//import bsiotmobile.mobile.service.MbCardRecordService;
//import cn.usr.service.UsrcloudMqttCallback;
//import cn.usr.service.UsrcloudMqttClient;
//import org.eclipse.paho.client.mqttv3.MqttException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.util.Date;
//
///**
// * Demo class
// *
// * @author drose
// * @date 2019/2/26 22:51
// */
//@Service
//public class UsrCloudCallback implements UsrcloudMqttCallback {
//
//    private Logger logger= LoggerFactory.getLogger(this.getClass().getName());
//    @Lazy
//    @Autowired
//    private UsrcloudMqttClient usrcloudMqttClient;
//    @Autowired
//    private PcTempMapper pcTempMapper;
//    @Autowired
//    private PcHumitMapper pcHumitMapper;
//    @Autowired
//    private NbCardMapper nbCardMapper;
//    @Autowired
//    private MbCardRecordService mbCardRecordService;
//
//
//    //门禁设备ID
//    private String doorId="356566078222460";
//    //环境设备ID
//    private String envId="356566078215258";
//    private String temp=null;
//    private String humit=null;
//    @Autowired
//    private PcrUserMapper pcrUserMapper;
//    @Override
//    public void onConnectAck(int i, String s) {
//        logger.info("连接回调函数onConnectAck："+s);
//        try {
//            usrcloudMqttClient.subscribeForDevId(envId);
//            usrcloudMqttClient.subscribeForDevId(doorId);
//        } catch (MqttException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void onSubscribeAck(int i, String s, String s1, int i1) {
//        logger.info("订阅回调函数：onSubscribeAck"+s1);
//    }
//
//    @Override
//    public void onDisSubscribeAck(int i, String s, String s1, int i1) {
//        logger.info("取消订阅回调函数：onDisSubscribeAck"+s1);
//    }
//
//    //接收回调
//    @Override
//    public void onReceiveEvent(int i, String s, byte[] bytes) {
//
//        int length = bytes.length;
//        String str="";
//        char b;
//        //将接收到的字符数组转成字符串
//        for(int j=0;j<length;j++){
//           b =(char)bytes[j];
//            str+=b;
//        }
//        logger.info(str);//打印转好后的内容
//
//        PcTemp pcTemp=new PcTemp();
//        PcHumit pcHumit=new PcHumit();
//
//
//        //滴卡开门
//        if(str.contains("21D11A2E")||str.contains("520FF41C")){
//            NbCard nbCard = nbCardMapper.checkCard(str);
//            if(nbCard!=null){
////                byte[] bytes1 = nbCard.getUserName().getBytes();
//                byte[] open=new byte[10];
//                open[0]='-';
//                try {
////                    usrcloudMqttClient.publishForDevId("356566078222460",bytes1);
//                    usrcloudMqttClient.publishForDevId("356566078222460",open);
//                    logger.info("后台调用开锁函数");
//                    mbCardRecordService.addCardRecord(str);
//                } catch (MqttException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        //自定义的协议，&开头的数据包是门控，@开头的是温度数据，#开头的湿度数据,$是雨滴传感器
//        //温度数据，
//        if(str.contains("@")){
//            temp=str.replace("@","");
//            logger.info("温度："+temp);
//            //赋值并执行插入数据库
//            pcTemp.setCreatedAt(new Date());
//            pcTemp.setId(GetUUID.getUUID());
//            pcTemp.settData(temp);
//            pcTempMapper.addTempData(pcTemp);
//        }
//        //解析湿度数据
//        if(str.contains("#")){
//            humit=str.replace("#","");
//            logger.info("湿度："+humit);
//            //赋值并执行插入数据库
//            pcHumit.setCreatedAt(new Date());
//            pcHumit.setId(GetUUID.getUUID());
//            pcHumit.sethData(humit);
//            pcHumitMapper.addHumitData(pcHumit);
//        }
//        //解析雨滴传感器数据,雨滴只有0和1，只有状态改变才会收到数据
//        if(str.contains("$")){
////            str=str.replace("$","");
//            if(str.equals("1")){
//                logger.info("当前雨滴数据：有水");
//            }
//            if(str.equals("0")){
//                logger.info("当前雨滴数据：无水");
//            }
//        }
//        //通过websocket发送实时数据到前端页面
//        try {
//            WebSocketServer.BroadCastInfo(str);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public void onReceiveParsedEvent(int i, String s, String s1) {
//         logger.info("接收函数:onReceiveParsedEvent"+s1);
//    }
//
//    @Override
//    public void onPublishDataAck(int i, String s, boolean b) {
//        logger.info("发送回调：onPublishDataAck"+s);
//    }
//
//    @Override
//    public void onPublishDataResult(int i, String s) {
//        logger.info("发送回调：onPublishDataResult"+s);
//    }
//}
