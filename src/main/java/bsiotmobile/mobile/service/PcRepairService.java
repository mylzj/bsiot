package bsiotmobile.mobile.service;

import bsiotmobile.mobile.common.RespMsg;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/2/25 11:39
 */
public interface PcRepairService {

    //查找报修列表
    RespMsg findRepairList(String name,String phoneNum);
}
