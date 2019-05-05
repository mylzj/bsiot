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
public interface MbUserRepairMapper {

    //申请报修
    void addRepair(@Param("eo")MbRepair mbRepair);

    //查找报修记录
    List<MbRepair> findRepair(@Param("eo")MbRepair mbRepair);

    //查看报修记录详情
    MbRepair findRepairDetail(@Param("id") String id);

    List<MbRepair> findAllRepairByStatus(@Param("status")String status);

    //维修师傅修改报修状态
    void updateRepairByMaintainer(@Param("status")String status,@Param("mid")String mid,@Param("id")String id);

    //维修师傅查看已完成报修订单
    List<MbRepair> findcompleteRepair(@Param("mid")String mid);
}
