package bsiotmobile.mobile.service.Impl;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.common.ResultUtils;
import bsiotmobile.mobile.eo.MbRepair;
import bsiotmobile.mobile.mapper.PcrRepairMapper;
import bsiotmobile.mobile.service.PcRepairService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/2/25 11:46
 */
@Service
public class PcRepairServieImpl implements PcRepairService {
    private Logger logger= LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private PcrRepairMapper pcrRepairMapper;

    @Override
    public RespMsg findRepairList(String name, String phoneNum) {
        MbRepair mbRepair=new MbRepair();
        if(name !=null){
            mbRepair.setName(name);
        }
        if(phoneNum !=null){
            mbRepair.setPhoneNum(phoneNum);
        }
        List<MbRepair> repairList = pcrRepairMapper.findRepairList(mbRepair);
        for(MbRepair item:repairList){
            if(item.getStatus().equals("under_review")){
                item.setCurrentStatus("审核中");
            }
            if(item.getStatus().equals("completed")){
                item.setCurrentStatus("已审核");
            }
        }
        return ResultUtils.success(repairList);
    }
}
