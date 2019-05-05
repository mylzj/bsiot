package bsiotmobile.mobile.mapper;

import bsiotmobile.mobile.eo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/1/10 12:08
 */
@Mapper
@Component
public interface UserMapper {

    //新增用户
    void addUser(@Param("eo")User user);

    //根据ID查找用户
    User findUser(@Param("id") String id);

    //根据用户名查找用户（用于登录验证）
    User findUserByName(@Param("name")String name);
}
