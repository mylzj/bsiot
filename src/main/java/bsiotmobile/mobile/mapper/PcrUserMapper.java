package bsiotmobile.mobile.mapper;

import bsiotmobile.mobile.eo.MbRepair;
import bsiotmobile.mobile.eo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/2/18 21:56
 */
@Mapper
@Component
public interface PcrUserMapper {


    //查找报修记录列表
    List<User> findUserList(@Param("eo")User user);

    //审核用户状态
    void updateStatusById(@Param("id")String id,@Param("status")String status,@Param("type")String type);

    //删除用户，逻辑删除
    void deleteUserById(@Param("id") String id);
}
