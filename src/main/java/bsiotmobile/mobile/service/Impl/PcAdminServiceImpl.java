package bsiotmobile.mobile.service.Impl;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.common.ResultUtils;
import bsiotmobile.mobile.eo.PcAdmin;
import bsiotmobile.mobile.extension.ApplicationException;
import bsiotmobile.mobile.mapper.PcAdminMapper;
import bsiotmobile.mobile.service.PcAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/4/23 15:52
 */
@Service
public class PcAdminServiceImpl implements PcAdminService {

    @Autowired
    private PcAdminMapper pcAdminMapper;

    @Override
    public RespMsg addAdmin(PcAdmin pcAdmin) {
        if(pcAdmin.getName()==null){
            throw new ApplicationException("用户名不能为空");
        }
        if(pcAdmin.getPassword()==null){
            throw new ApplicationException("密码不能为空");
        }
        if(pcAdmin.getLevel()==null){
            pcAdmin.setLevel("普通管理员");
        }
        pcAdmin.setCreatedAt(new Date());
        pcAdminMapper.addAdmin(pcAdmin);
        return ResultUtils.success();
    }

    @Override
    public RespMsg findAdminList() {
        List<PcAdmin> adminList = pcAdminMapper.findAdminList();
        return ResultUtils.success(adminList);
    }

    @Override
    public RespMsg updateAdminById(PcAdmin pcAdmin) {
        if(pcAdmin.getName()==null){
            throw new ApplicationException("用户名不能为空");
        }
        if(pcAdmin.getPassword()==null){
            throw new ApplicationException("密码不能为空");
        }
        if(pcAdmin.getLevel()==null){
            throw new ApplicationException("级别不能为空");
        }
        pcAdminMapper.updateAdminById(pcAdmin);
        return ResultUtils.success();
    }

    //登录
    @Override
    public RespMsg loginAdmin(PcAdmin pcAdmin) {
        PcAdmin pcAdmin1 = pcAdminMapper.loginAdmin(pcAdmin.getName());
        if(!pcAdmin1.getPassword().equals(pcAdmin.getPassword())){
            return ResultUtils.error("用户名或密码错误",500);
        }
        return ResultUtils.success(pcAdmin1);
    }

    @Override
    public RespMsg deleteAdminById(Integer id) {
        if(id==null){
            throw new ApplicationException("用户ID不能为空");
        }
        pcAdminMapper.deleteAdminById(id);
        return ResultUtils.success();
    }
}
