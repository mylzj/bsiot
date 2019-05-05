package bsiotmobile.mobile.service;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.eo.MbRepair;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/2/18 22:21
 */
public interface MbUserRepairService {

    //提交报修
     RespMsg commitRepair(MbRepair mbRepair);

     //查找报修记录
    RespMsg findRepair(String userId,String status,Integer page,Integer size);

    //查看报修详情
    RespMsg findRepairDetail(String id);

    //查看所有报修订单,维修师傅用的
    RespMsg findRepairOrderByStatus(String status);

    //更新报修订单状态，维修师傅用的
    RespMsg updateRepairByMaintainer(String status,String mid,String id);

    //查看已完成报修订单，维修师傅用的
    RespMsg findcompleteRepair(String id);
}
