package bsiotmobile.mobile.service;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.eo.User;

import javax.servlet.http.HttpSession;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/1/10 13:06
 */
public interface UserService {

    void addUser(User user);

    User findUser(String id);

    RespMsg login( User user);


}
