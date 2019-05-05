package bsiotmobile.mobile.mapper;

import bsiotmobile.mobile.eo.PcAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/4/23 15:47
 */
@Mapper
@Component
public interface PcAdminMapper {

    //新增
    void addAdmin(@Param("eo")PcAdmin pcAdmin);
    //查看列表
    List<PcAdmin>findAdminList();
    //更新
    void updateAdminById(@Param("eo")PcAdmin pcAdmin);
    //登录校验
    PcAdmin loginAdmin(@Param("name")String name);
    //删除
    void deleteAdminById(@Param("id")Integer id);
}
