package bsiotmobile.mobile.service.Impl;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.common.ResultUtils;
import bsiotmobile.mobile.eo.MbRepair;
import bsiotmobile.mobile.eo.User;
import bsiotmobile.mobile.mapper.PcrUserMapper;
import bsiotmobile.mobile.service.PcUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/2/25 16:00
 */
@Service
public class PcUserServiceImpl implements PcUserService {
    private Logger logger= LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private PcrUserMapper pcrUserMapper;

    @Override
    public RespMsg findUserList(String name, String phoneNum) {
        User user=new User();
        if(name!=null){
            user.setName(name);
        }
        if(phoneNum!=null){
            user.setPhoneNum(phoneNum);
        }
        List<User> userList = pcrUserMapper.findUserList(user);
        for(User item:userList){

            if(item.getStatus().equals("passed")){
                item.setStatus("审核通过");
            }
            if(item.getStatus().equals("maintainner")){
                item.setStatus("审核通过");
            }
            if(item.getStatus().equals("under_review")){
                item.setStatus("审核中");
            }
        }
        return ResultUtils.success(userList);
    }

    @Override
    public RespMsg updateStatusById(String id, String status) {
        String type="";
        if(id==null||status==null){

            return ResultUtils.error("审核失败",500);
        }
        if(status.equals("under_review")){
            type="passerby";
        }
        if(status.equals("passed")){
            type="household";
        }
        if(status.equals("maintainner")){
            type="maintainner";
        }
        pcrUserMapper.updateStatusById(id,status,type);
        return ResultUtils.success();
    }

    @Override
    public RespMsg deleteUserById(String id) {
        pcrUserMapper.deleteUserById(id);
        return ResultUtils.success();
    }
}
