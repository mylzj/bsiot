package bsiotmobile.mobile.service.Impl;

import bsiotmobile.mobile.common.*;
import bsiotmobile.mobile.eo.User;
import bsiotmobile.mobile.extension.ApplicationException;
import bsiotmobile.mobile.mapper.MbUserMapper;
import bsiotmobile.mobile.mapper.UserMapper;
import bsiotmobile.mobile.service.MbUserService;
import bsiotmobile.mobile.service.UserService;
import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/1/10 13:07
 */
@Service
public class MbUserServiceImpl implements MbUserService {

    @Autowired
    private MbUserMapper mbUserMapper;
    @Autowired
    private SendSmsUtils sendSmsUtils;
    @Autowired
    private RedisService redisService;
    @Override
    public RespMsg addUser(User user) {
        //调用校验验证码函数
        Boolean flag = checkSmsCode(user.getPhoneNum(), user.getCheckCode());
        if(!flag){
            return ResultUtils.error("验证码已过期或不存在",500);
        }
        //设置32位UUID主键
        user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        //性别默认是男
        if(user.getSex()==null){
            user.setSex(1);
        }
        //默认角色是普通用户，审核之后才是住户
        user.setType("passerby");
        user.setStatus("under_review");
        user.setCreatedAt(new Date());
        //对注册的密码进行MD5加密
        String pw = MD5Utils.MD5(user.getPassword());
        user.setPassword(pw);

        try{
            mbUserMapper.addUser(user);
        }catch (Exception e){
            return ResultUtils.error("注册失败,请重新再试",500);
        }
        return ResultUtils.success();
    }

    @Override
    public RespMsg login(String username, String password) {
        if(username==null||password==null){
            return ResultUtils.error("用户名密码为空",500);
        }
        User login = mbUserMapper.login(username, password);
        if(login==null){
            return ResultUtils.error("用户名或者密码错误",500);
        }
        return ResultUtils.success(login);
    }

    @Override
    public RespMsg updateInfoById(User user) {
        try {
            mbUserMapper.updateInfoById(user);
        }catch (Exception e){
            throw new ApplicationException("上传失败，请重试");
        }
        return ResultUtils.success();
    }

    @Override
    public RespMsg sendCheckCode(String phoneNum) {
        //随机生成6为验证码
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        //调用阿里云 发送验证码
        CommonResponse commonResponse = sendSmsUtils.sendCheckCode(phoneNum, checkCode);
        //将返回的json数据转成map形式，为了获取状态码
        Map responMap =(Map) JSON.parseObject(commonResponse.getData());
        if(!responMap.get("Code").equals("OK")){
            return ResultUtils.error("发送验证码失败",500);
        }
        //将手机号作为键，生成的验证码作为值，为了后续的校验
        redisService.setRedis(phoneNum,checkCode,300L);
        return ResultUtils.success();
    }

    @Override
    public String getUserImgUrl(String id) {

        return null;
    }

    //校验注册时的验证码是否正确
    public Boolean checkSmsCode(String phonenNum,String checkCode){
        String redisCode = redisService.getRedis(phonenNum);
        if(redisCode==null){
            return false;
        }
        if(checkCode.equals(redisCode)){
            redisService.deleteRedis(phonenNum);
            return true;
        }
        return false;
    }
}
