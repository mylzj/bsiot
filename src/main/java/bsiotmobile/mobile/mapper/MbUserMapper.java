package bsiotmobile.mobile.mapper;

import bsiotmobile.mobile.eo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/2/17 21:27
 */
@Mapper
@Component
public interface MbUserMapper {
    //注册函数
    void addUser(@Param("eo")User user);

    //登录函数
    User login(@Param("username")String username,@Param("password")String password);

    //更新用户资料
    void updateInfoById(@Param("eo") User user);

    //读取用户头像
    String findUserImgUrlById(@Param("id")String id);

    //根据卡号查找用户信息
    User findUserByCardId(@Param("cardId")String id);
}
