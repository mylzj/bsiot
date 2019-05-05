package bsiotmobile.mobile.controller;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.service.PcRepairService;
import bsiotmobile.mobile.service.PcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Demo class
 *后台管理端对用户的操作
 * @author drose
 * @date 2019/2/18 22:49
 */
@Controller
@CrossOrigin
@RequestMapping("/v1/admin/user")
public class PcUserController {

    @Autowired
    private PcUserService pcUserService;

    //查询用户列表
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public RespMsg findUserList(@RequestParam(required = false) String name,
                              @RequestParam(required = false) String phoneNum,
                              @RequestParam(required = false,defaultValue = "1")Integer page,
                              @RequestParam(required = false,defaultValue = "10")Integer size){
        RespMsg userList = pcUserService.findUserList(name, phoneNum);
        return userList;
    }

    //审核用户
    @RequestMapping(value = "/updated",method = RequestMethod.GET)
    @ResponseBody
    public RespMsg updatedStatusByid(@RequestParam String id,
                                @RequestParam String status){
        RespMsg respMsg = pcUserService.updateStatusById(id, status);
        return respMsg;
    }

    //删除用户
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    @ResponseBody
    public RespMsg deleteUserById(@RequestParam String id){
        RespMsg respMsg = pcUserService.deleteUserById(id);
        return respMsg;
    }

}
