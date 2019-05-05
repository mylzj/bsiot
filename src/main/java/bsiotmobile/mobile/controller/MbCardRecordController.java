package bsiotmobile.mobile.controller;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.eo.PcAdmin;
import bsiotmobile.mobile.service.MbCardRecordService;
import bsiotmobile.mobile.service.PcAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Demo class
 *移动端用户滴卡记录操作函数
 * @author drose
 * @date 2019/4/23 15:57
 */
@Controller
@RequestMapping("/card")
@CrossOrigin
public class MbCardRecordController {
    @Autowired
    private MbCardRecordService mbCardRecordService;


    //查看列表
    @GetMapping("/list")
    @ResponseBody
    public RespMsg findAdminList(@RequestParam String id){
        RespMsg respMsg = mbCardRecordService.findCardRecordList(id);
        return respMsg;
    }


    //删除
    @GetMapping("/delete")
    @ResponseBody
    public RespMsg deleteAdminById(@RequestParam String id){
        RespMsg respMsg = mbCardRecordService.deleteCardRecordById(Integer.parseInt(id));
        return respMsg;
    }
}
