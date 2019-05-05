package bsiotmobile.mobile.service.Impl;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.common.ResultUtils;
import bsiotmobile.mobile.eo.MbCardRecord;
import bsiotmobile.mobile.eo.User;
import bsiotmobile.mobile.mapper.MbCardRecordMapper;
import bsiotmobile.mobile.mapper.MbUserMapper;
import bsiotmobile.mobile.service.MbCardRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/4/25 19:27
 */
@Service
public class MbCardRecordServiceImpl implements MbCardRecordService {

    private Logger logger= LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private MbCardRecordMapper mbCardRecordMapper;
    @Autowired
    private MbUserMapper mbUserMapper;

    @Override
    public RespMsg findCardRecordList(String id) {
        List<MbCardRecord> cardRecordList = mbCardRecordMapper.findCardRecordList(id);
        return ResultUtils.success(cardRecordList);
    }

    @Override
    public RespMsg deleteCardRecordById(Integer id) {
        mbCardRecordMapper.deleteCardRecordById(id);
        return ResultUtils.success();
    }

    @Override
    public void addCardRecord(String cardId) {
        //根据卡号查询用户信息
        User userInfo = mbUserMapper.findUserByCardId(cardId);
        //封装数据
        MbCardRecord mbCardRecord=new MbCardRecord();
        mbCardRecord.setCreatedAt(new Date());
        mbCardRecord.setUserId(userInfo.getId());
        mbCardRecord.setUserName(userInfo.getName());
        //插入数据
        mbCardRecordMapper.addCardRecord(mbCardRecord);
        logger.info("卡号%s滴卡记录插入成功",cardId);
    }
}
