package bsiotmobile.mobile.service;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.eo.MbComment;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/3/10 16:42
 */
public interface MbCardRecordService {

    //查看滴卡记录列表
    RespMsg findCardRecordList(String id);

    //删除滴卡记录
    RespMsg deleteCardRecordById(Integer id);

    //滴卡插入数据记
    void addCardRecord(String cardId);
}
