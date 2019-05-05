package bsiotmobile.mobile.controller;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.eo.MbRepair;
import bsiotmobile.mobile.service.MbUserRepairService;
import bsiotmobile.mobile.service.PcRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Demo class
 *后台管理端用户报修操作
 * @author drose
 * @date 2019/2/18 22:49
 */
@Controller
@CrossOrigin
@RequestMapping("/v1/admin/repair")
public class PcRepairController {

    @Autowired
    private PcRepairService pcRepairService;


    //查询报修记录
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public RespMsg findRepair(@RequestParam(required = false) String name,
                              @RequestParam(required = false) String phoneNum,
                              @RequestParam(required = false,defaultValue = "1")Integer page,
                              @RequestParam(required = false,defaultValue = "10")Integer size){
        RespMsg repairList = pcRepairService.findRepairList(name, phoneNum);
        return repairList;
    }

//    //查看记录详情
//    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
//    @ResponseBody
//    public RespMsg findRepairDetail(@PathVariable String id){
//        RespMsg repairDetail = mbUserRepairService.findRepairDetail(id);
//        return repairDetail;
//    }
}
