package bsiotmobile.mobile.controller;

import bsiotmobile.mobile.common.DateFormateUtils;
import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.common.ResultUtils;
import bsiotmobile.mobile.common.StringUtils;
import bsiotmobile.mobile.eo.MbRepair;
import bsiotmobile.mobile.service.MbUserRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Demo class
 *用户报修操作
 * @author drose
 * @date 2019/2/18 22:49
 */
@Controller
@CrossOrigin
@RequestMapping("/v1/user/repair")
public class MbUserRepairController {

    @Autowired
    private MbUserRepairService mbUserRepairService;

    //用户申请报修
    @RequestMapping(value = "/",method = RequestMethod.POST)
    @ResponseBody
    public RespMsg commitRepair(@RequestBody MbRepair mbRepair){
        return mbUserRepairService.commitRepair(mbRepair);
    }

    //查询报修记录
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public RespMsg findRepair(@RequestParam String userId,
                              @RequestParam String status,
                              @RequestParam(required = false,defaultValue = "1")Integer page,
                              @RequestParam(required = false,defaultValue = "10")Integer size){
        RespMsg repair = mbUserRepairService.findRepair(userId, status, page, size);
        return repair;
    }

    //查看记录详情
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public RespMsg findRepairDetail(@PathVariable String id){
        RespMsg repairDetail = mbUserRepairService.findRepairDetail(id);
        return repairDetail;
    }

    //维修师傅查看未确认报修列表
    @RequestMapping(value = "/order/list",method = RequestMethod.GET)
    @ResponseBody
    public RespMsg findRepairOrderByStatus(@RequestParam String status){
        RespMsg repairDetail = mbUserRepairService.findRepairOrderByStatus(status);
        return repairDetail;
    }

    //维修师傅更新报修订单状态
    @RequestMapping(value = "/order/confirm",method = RequestMethod.GET)
    @ResponseBody
    public RespMsg updateStatusByMaintainner(@RequestParam String status,@RequestParam String mid,@RequestParam String repairId){
        RespMsg respMsg = mbUserRepairService.updateRepairByMaintainer(status, mid, repairId);
        return respMsg;
    }

    //维修师傅查看已经完成的订单，只能查看该师傅确认的
    @RequestMapping(value = "/order/findComplete",method = RequestMethod.GET)
    @ResponseBody
    public RespMsg findCompleteRepair(@RequestParam String id){
        RespMsg respMsg = mbUserRepairService.findcompleteRepair(id);
        return respMsg;
    }
}
