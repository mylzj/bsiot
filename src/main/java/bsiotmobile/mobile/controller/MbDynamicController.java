package bsiotmobile.mobile.controller;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.eo.MbDynamic;
import bsiotmobile.mobile.service.MbDynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Demo class
 *小区动态操作
 * @author drose
 * @date 2019/3/10 16:50
 */
@Controller
@CrossOrigin
@RequestMapping("/api/dynamic")
public class MbDynamicController {
    @Autowired
    private MbDynamicService mbDynamicService;

    //新增动态
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public RespMsg addDynamic(@RequestBody MbDynamic mbDynamic){
        RespMsg respMsg = mbDynamicService.addDynamic(mbDynamic);
        return respMsg;
    }
    //显示动态列表
    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public RespMsg showDynamicList(){
        RespMsg respMsg = mbDynamicService.showDynamicList();
        return respMsg;
    }

    //删除动态
    @ResponseBody
    @GetMapping("/delete")
    public RespMsg deleteDynamic(@RequestParam String id){
        RespMsg respMsg = mbDynamicService.deleteDynamic(id);
        return respMsg;
    }
}
