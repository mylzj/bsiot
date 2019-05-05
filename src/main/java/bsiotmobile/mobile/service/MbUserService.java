package bsiotmobile.mobile.service;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.eo.User;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/1/10 13:06
 */
public interface MbUserService {

    //注册函数
    RespMsg addUser(User user);

    //登录函数
    RespMsg login(String username,String password);

    //更新用户资料
    RespMsg updateInfoById(User user);

    //注册发送验证码
    RespMsg sendCheckCode(String phoneNum);

    //根据用户ID读取头像
    String getUserImgUrl(String id);
}
