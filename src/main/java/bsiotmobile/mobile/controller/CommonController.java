package bsiotmobile.mobile.controller;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.common.ResultUtils;
import bsiotmobile.mobile.eo.NbCard;
import bsiotmobile.mobile.service.MbCardRecordService;
import bsiotmobile.mobile.service.NbCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.security.Security;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/1/12 17:27
 */
@Controller
@RequestMapping("/nbiot/")
@CrossOrigin
public class CommonController {
    private Logger logger= LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private NbCardService nbCardService;
    @Autowired
    private MbCardRecordService mbCardRecordService;

    @GetMapping("/demo")
    public String showIndex(){
        return "redirect:/demo1.html";
    }

    //滴卡校验卡号开门
    @PostMapping("/checkCard")
    @ResponseBody
    public RespMsg checkCard(@RequestBody NbCard card){
        if(card.getCardId()==null){
            return ResultUtils.error("卡号不存在",500);
        }
        RespMsg respMsg = nbCardService.checkCard(card.getCardId());
        return respMsg;
    }

    @RequestMapping("/tologin")
    public String toLogin(){
        return "redirect:/login.html";
    }

    @RequestMapping("/toregister")
    public  String toRegister(){
        return "redirect:/register.html";
    }

    @GetMapping("/test")
    @ResponseBody
    public String toMember(){
//        mbCardRecordService.addCardRecord("520FF41C");
        mbCardRecordService.findCardRecordList("12");
        return "200";
    }

}
