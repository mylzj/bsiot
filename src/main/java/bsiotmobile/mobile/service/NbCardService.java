package bsiotmobile.mobile.service;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.eo.User;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/1/10 13:06
 */
public interface NbCardService {

    //滴卡检验卡号
    RespMsg checkCard(String cardId);

}
