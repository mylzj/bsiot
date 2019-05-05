package bsiotmobile.mobile.service.Impl;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.common.ResultUtils;
import bsiotmobile.mobile.eo.User;
import bsiotmobile.mobile.mapper.UserMapper;
import bsiotmobile.mobile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/1/10 13:07
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    
    /** 
    * @Description: 用户注册 
    * @Param: [user] 
    * @return: void 
    * @Author: rose
    * @Date: 2019/1/10 
    */
    @Override
    public void addUser(User user) {
        user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        userMapper.addUser(user);
    }

    @Override
    public User findUser(String id) {
        User user = userMapper.findUser(id);
        return user;
    }

    /** 
    * @Description: 登录验证 
    * @Param: [name, password] 
    * @return: bsiotmobile.mobile.common.RespMsg 
    * @Author: rose
    * @Date: 2019/1/10 
    */
    @Override
    public RespMsg login(User user) {
        User user1 = userMapper.findUserByName(user.getName());
        if(user1==null){
            return ResultUtils.error("用户名错误",500);
        }
        if(!user1.getPassword().equals(user.getPassword())){
            return ResultUtils.error("用户名错误或密码",500);
        }

        return ResultUtils.success(user1);
    }



}
