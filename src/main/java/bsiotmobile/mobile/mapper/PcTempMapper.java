package bsiotmobile.mobile.mapper;

import bsiotmobile.mobile.eo.PcTemp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/3/11 12:13
 */
@Mapper
@Component
public interface PcTempMapper {

    //插入
    void addTempData(@Param("eo")PcTemp pcTemp);

    //查询
    List<PcTemp> findTempDataList();

    //删除
    void deletedTempById(@Param("id")String id);
}
