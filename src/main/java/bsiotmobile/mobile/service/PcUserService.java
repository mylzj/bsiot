package bsiotmobile.mobile.service;

import bsiotmobile.mobile.common.RespMsg;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/2/25 11:39
 */
public interface PcUserService {

    //查找用户列表
    RespMsg findUserList(String name, String phoneNum);

    //审核用户状态
    RespMsg updateStatusById(String id,String status);

    //删除用户
    RespMsg deleteUserById(String id);
}
