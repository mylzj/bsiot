package bsiotmobile.mobile.controller;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.eo.MbComment;
import bsiotmobile.mobile.eo.MbDynamic;
import bsiotmobile.mobile.service.MbCommentService;
import bsiotmobile.mobile.service.MbDynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Demo class
 *小区动态评论操作
 * @author drose
 * @date 2019/3/10 16:50
 */
@Controller
@CrossOrigin
@RequestMapping("/api/comment")
public class MbCommentController {
    @Autowired
    private MbCommentService mbCommentService;

    //新增动态
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public RespMsg addComment(@RequestBody MbComment mbComment){
        RespMsg respMsg = mbCommentService.addComment(mbComment);
        return respMsg;
    }
//    //显示动态列表
//    @ResponseBody
//    @RequestMapping(value = "/list",method = RequestMethod.GET)
//    public RespMsg showDynamicList(){
//        RespMsg respMsg = mbDynamicService.showDynamicList();
//        return respMsg;
//    }
}
