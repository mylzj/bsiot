package bsiotmobile.mobile.controller;

import bsiotmobile.mobile.common.*;
import bsiotmobile.mobile.eo.User;
import bsiotmobile.mobile.extension.ApplicationException;
import bsiotmobile.mobile.service.MbUserService;
//import com.sun.deploy.net.URLEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Demo class
 *移动端用户操作
 * @author drose
 * @date 2019/2/17 21:12
 */
@Controller
@CrossOrigin
@RequestMapping("/user")
public class MbUserController {

    private Logger logger= LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private MbUserService mbUserService;
    @Value("${cbs.imagesPath}")
    private String urlPath;


    //注册函数
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public RespMsg resgisterUser(@RequestBody User user) throws UnsupportedEncodingException {
        RespMsg respMsg = mbUserService.addUser(user);
        return respMsg;
    }

    //登录
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    public RespMsg login(@RequestParam String name,
                         @RequestParam String password) throws UnsupportedEncodingException {

        String pw =  MD5Utils.MD5(password);
        logger.info("登录加密后的密码:"+pw);
        RespMsg respMsg = mbUserService.login(name,pw);
        return respMsg;
    }

    //上传图片
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public RespMsg uploadImg(@RequestParam("file" )MultipartFile file,HttpServletRequest request) throws IOException {
        String s = ImagesUtils.imgUpload(file);
        logger.info(s);
        return ResultUtils.success(s);
    }
    //更新资料
    @RequestMapping(value = "/updatedInfo",method = RequestMethod.POST)
    @ResponseBody
    public RespMsg uploadInfo(@RequestBody User user){
        RespMsg respMsg = mbUserService.updateInfoById(user);
        return respMsg;
    }

    //发送短信验证码
    @RequestMapping(value = "/sendCheckCode",method = RequestMethod.GET)
    @ResponseBody
    public RespMsg sendCheckCode(@RequestParam String phoneNum){
        RespMsg respMsg = mbUserService.sendCheckCode(phoneNum);
        return respMsg;
    }
}
