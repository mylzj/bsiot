package bsiotmobile.mobile.mapper;

import bsiotmobile.mobile.eo.MbCardRecord;
import bsiotmobile.mobile.eo.NbCard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/2/17 21:27
 */
@Mapper
@Component
public interface MbCardRecordMapper {


    //新增滴卡记录
    void addCardRecord(@Param("eo")MbCardRecord mbCardRecord);

    //查看列表
    List<MbCardRecord> findCardRecordList(@Param("userId")String id);

    //删除
    void deleteCardRecordById(@Param("id")Integer id);
}
