package bsiotmobile.mobile.mapper;

import bsiotmobile.mobile.eo.MbRepair;
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
public interface PcrRepairMapper {


    //查找报修记录列表
    List<MbRepair> findRepairList(@Param("eo") MbRepair mbRepair);

    //审核报修记录
    void updateRepairStatusByAdmin(@Param("status")String status,@Param("id")String id);

}
