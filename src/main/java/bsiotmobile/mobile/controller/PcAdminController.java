package bsiotmobile.mobile.controller;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.eo.PcAdmin;
import bsiotmobile.mobile.service.PcAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Demo class
 *后台管理端增加管理员
 * @author drose
 * @date 2019/4/23 15:57
 */
@Controller
@RequestMapping("/admin")
@CrossOrigin
public class PcAdminController {
    @Autowired
    private PcAdminService pcAdminService;

    //新增
    @PostMapping("/add")
    @ResponseBody
    public RespMsg addAdmin(@RequestBody PcAdmin pcAdmin){
        RespMsg respMsg = pcAdminService.addAdmin(pcAdmin);
        return respMsg;
    }

    //查看列表
    @GetMapping("/list")
    @ResponseBody
    public RespMsg findAdminList(){
        RespMsg respMsg = pcAdminService.findAdminList();
        return respMsg;
    }

    //编辑
    @PostMapping("/updated")
    @ResponseBody
    public RespMsg updateAdminById(@RequestBody PcAdmin pcAdmin){
        RespMsg respMsg = pcAdminService.updateAdminById(pcAdmin);
        return respMsg;
    }

    //登录
    @PostMapping("/login")
    @ResponseBody
    public RespMsg login(@RequestBody PcAdmin pcAdmin){
        RespMsg respMsg = pcAdminService.loginAdmin(pcAdmin);
        return respMsg;
    }

    //删除
    @GetMapping("/delete")
    @ResponseBody
    public RespMsg deleteAdminById(@RequestParam String id){
        RespMsg respMsg = pcAdminService.deleteAdminById(Integer.parseInt(id));
        return respMsg;
    }
}
