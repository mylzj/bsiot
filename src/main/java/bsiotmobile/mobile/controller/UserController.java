package bsiotmobile.mobile.controller;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.common.ResultUtils;
import bsiotmobile.mobile.eo.User;
import bsiotmobile.mobile.extension.ApplicationException;
import bsiotmobile.mobile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Demo class
 *
 * @author drose
 * @date 2019/1/10 0:30
 */
@Controller
@CrossOrigin
//@RequestMapping(value = "/mobile/user")
public class UserController {

    @Autowired
    private UserService userService;

    //用户注册
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public RespMsg registerUser(@RequestBody User user, HttpSession session){
        if(user.getName()==null||user.getPassword()==null){
            throw new ApplicationException("用户名或者密码为空");
        }
        userService.addUser(user);
        session.setAttribute("username",user.getName());
        return ResultUtils.success();
    }
    //用户退出
    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpSession session){
        session.removeAttribute("username");
        return "200";
    }

    /** 
    * @Description: 用户登录验证
    * @Param: [name, password] 
    * @return: bsiotmobile.mobile.common.RespMsg 
    * @Author: rose
    * @Date: 2019/1/10 
    */

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public RespMsg logon(@RequestBody User user,HttpServletRequest request, HttpServletResponse response){
        RespMsg login = userService.login(user);
//        if(login.getCode()==200){
//            Cookie cookie=new Cookie("username",user.getName());
//            response.addCookie(cookie);
//        }
        System.out.println(request.getSession().getId());
        return ResultUtils.success(login);
    }

    //用户列表
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public RespMsg findUserById(@RequestParam String id){
        User user = userService.findUser(id);
        return ResultUtils.success(user);
    }

}
