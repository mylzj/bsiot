package bsiotmobile.mobile.mapper;

import bsiotmobile.mobile.eo.MbDynamic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/3/10 16:30
 */
@Mapper
@Component
public interface MbDynamicMapper {
    //新增动态
    void addDynamic(@Param("eo")MbDynamic mbDynamic);

    //显示动态列表
    List<MbDynamic> showDynamicList();

    //删除动态
    void deleteDynamicById(@Param("id") String id);
}
