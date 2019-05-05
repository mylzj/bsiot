package bsiotmobile.mobile.mapper;

import bsiotmobile.mobile.eo.PcHumit;
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
public interface PcHumitMapper {

    //插入
    void addHumitData(@Param("eo") PcHumit pcHumit);
    //查询
    List<PcHumit> findHumitDataList();
    //删除
    void deletedHumitById(@Param("id")String id);
}
