package bsiotmobile.mobile.service.Impl;

import bsiotmobile.mobile.common.*;
import bsiotmobile.mobile.eo.MbRepair;
import bsiotmobile.mobile.mapper.MbUserRepairMapper;
import bsiotmobile.mobile.service.MbUserRepairService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/2/18 22:23
 */
@Service
public class MbUserRepairServiceImpl implements MbUserRepairService {

    private Logger logger= LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private MbUserRepairMapper mbUserRepairMapper;

    @Override
    public RespMsg commitRepair(MbRepair mbRepair) {
        mbRepair.setId(GetUUID.getUUID());
        //初始值为审核中
        mbRepair.setStatus("under_review");
        mbRepair.setCreatedAt(new Date());
        mbRepair.setUpdatedAt(new Date());
        //时间格式的转换
        try {
            if(mbRepair.getPreTimeDto()!=null){
                Date date = DateFormateUtils.StringToDtae(mbRepair.getPreTimeDto());
                mbRepair.setPreTime(date);
            }
            mbUserRepairMapper.addRepair(mbRepair);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return ResultUtils.success();
    }

    //查询报修记录
    @Override
    public RespMsg findRepair(String userId, String status, Integer page, Integer size) {
        MbRepair mbRepair=new MbRepair();

        if(userId!=null){
            mbRepair.setUserId(userId);
        }
       if(status!=null){
           mbRepair.setStatus(status);
       }
        List<MbRepair> repair = mbUserRepairMapper.findRepair(mbRepair);
        logger.info(repair.toString());
       for(MbRepair item:repair){
           SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           item.setPreTimeDto(sdf.format(item.getCreatedAt()));
       }
        return ResultUtils.success(repair);
    }

    @Override
    public RespMsg findRepairDetail(String id) {
        if(id==null||id.equals("")){
            return ResultUtils.error("查询记录不存在，请重试",500);
        }
        MbRepair repairDetail = mbUserRepairMapper.findRepairDetail(id);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        repairDetail.setPreTimeDto(sdf.format(repairDetail.getPreTime()));
        return ResultUtils.success(repairDetail);
    }

    @Override
    public RespMsg findRepairOrderByStatus(String status) {
        List<MbRepair> allRepairByStatus = mbUserRepairMapper.findAllRepairByStatus(status);
        return ResultUtils.success(allRepairByStatus);
    }

    @Override
    public RespMsg updateRepairByMaintainer(String status, String mid, String id) {
        mbUserRepairMapper.updateRepairByMaintainer(status,mid,id);
        return ResultUtils.success();
    }

    @Override
    public RespMsg findcompleteRepair(@RequestParam String id) {
        List<MbRepair> mbRepairs = mbUserRepairMapper.findcompleteRepair(id);
        return ResultUtils.success(mbRepairs);
    }
}
