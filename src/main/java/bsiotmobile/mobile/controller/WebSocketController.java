package bsiotmobile.mobile.controller;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.common.ResultUtils;
import bsiotmobile.mobile.common.WebSocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/3/8 17:20
 */
@Controller
@RequestMapping("/api/websocket")
@CrossOrigin
public class WebSocketController {

    @RequestMapping(value="/sendAll", method= RequestMethod.GET)
    /**
     * 群发消息内容
     * @param message
     * @return
     */
    @ResponseBody
    RespMsg sendAllMessage(@RequestParam(required=true) String message){
        try {
            WebSocketServer.BroadCastInfo(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultUtils.success();
    }
    @RequestMapping(value="/sendOne", method=RequestMethod.GET)
    /**
     * 指定会话ID发消息
     * @param message 消息内容
     * @param id 连接会话ID
     * @return
     */
    @ResponseBody
    RespMsg sendOneMessage(@RequestParam(required=true) String message,@RequestParam(required=true) String id){
        try {
            WebSocketServer.SendMessage(id,message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultUtils.success();
    }

}
