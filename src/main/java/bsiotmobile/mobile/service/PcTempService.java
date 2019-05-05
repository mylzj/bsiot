package bsiotmobile.mobile.service;

import bsiotmobile.mobile.common.RespMsg;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/1/10 13:06
 */
public interface PcTempService {

    //获取温度数据列表
    RespMsg showTempDataList(Integer page,Integer size);
    //删除
    RespMsg deletedTempById(String id);
}
