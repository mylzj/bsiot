package bsiotmobile.mobile.service;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.eo.PcAdmin;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/4/23 15:50
 */
public interface PcAdminService {

    RespMsg addAdmin(PcAdmin pcAdmin);

    RespMsg findAdminList();

    RespMsg updateAdminById(PcAdmin pcAdmin);

    RespMsg loginAdmin(PcAdmin pcAdmin);

    RespMsg deleteAdminById(Integer id);
}
