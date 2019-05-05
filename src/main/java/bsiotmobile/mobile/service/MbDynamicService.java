package bsiotmobile.mobile.service;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.eo.MbDynamic;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/3/10 16:42
 */
public interface MbDynamicService {

    //新增动态
    RespMsg addDynamic(MbDynamic mbDynamic);

    //显示动态列表
    RespMsg showDynamicList();

    //删除动态
    RespMsg deleteDynamic(String id);
}
