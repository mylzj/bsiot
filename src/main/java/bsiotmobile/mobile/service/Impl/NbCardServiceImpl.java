package bsiotmobile.mobile.service.Impl;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.common.ResultUtils;
import bsiotmobile.mobile.eo.NbCard;
import bsiotmobile.mobile.mapper.NbCardMapper;
import bsiotmobile.mobile.service.NbCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/3/3 16:52
 */
@Service
public class NbCardServiceImpl implements NbCardService {

    @Autowired
    private NbCardMapper nbCardMapper;

    @Override
    public RespMsg checkCard(String cardId) {
        //查询数据库是否存在此卡号
        NbCard nbCard = nbCardMapper.checkCard(cardId);
        if(nbCard!=null){
            //查询得到则返回卡号
            return ResultUtils.success(nbCard);
        }
        //查询不存在，即失败
        return ResultUtils.error("卡号不存在",500);
    }
}
