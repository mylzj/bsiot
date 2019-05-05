package bsiotmobile.mobile.controller;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.service.PcHumitService;
import bsiotmobile.mobile.service.PcTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Demo class
 *温湿度数据的操作函数
 * @author drose
 * @date 2019/3/11 17:26
 */
@Controller
@RequestMapping("/common/")
@CrossOrigin
public class CommonDataController {

    @Autowired
    private PcTempService pcTempService;
    @Autowired
    private PcHumitService pcHumitService;

    //返回温度数据并分页
    @GetMapping("/temp/list")
    @ResponseBody
    public RespMsg showTempList(@RequestParam(required = false,defaultValue = "1") Integer page,
                                @RequestParam(required = false,defaultValue = "10") Integer size){
        RespMsg respMsg = pcTempService.showTempDataList(page, size);
        return respMsg;
    }

    //返回湿度数据并分页
    @GetMapping("/humit/list")
    @ResponseBody
    public RespMsg showHumitList(@RequestParam(required = false,defaultValue = "1") Integer page,
                                @RequestParam(required = false,defaultValue = "10") Integer size){
        RespMsg respMsg = pcHumitService.showHumitDataList(page, size);
        return respMsg;
    }
    //删除温度数据
    @GetMapping("/temp/delete")
    @ResponseBody
    public RespMsg deleteTemp(@RequestParam String id){
        RespMsg respMsg = pcTempService.deletedTempById(id);
        return respMsg;
    }
    //删除湿度数据
    @GetMapping("/humit/delete")
    @ResponseBody
    public RespMsg deleteHumit(@RequestParam String id){
        RespMsg respMsg =pcHumitService.deletedHumitById(id);
        return respMsg;
    }
}
