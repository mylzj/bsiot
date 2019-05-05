package bsiotmobile.mobile.service.Impl;

import bsiotmobile.mobile.common.GetUUID;
import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.common.ResultUtils;
import bsiotmobile.mobile.eo.MbComment;
import bsiotmobile.mobile.eo.MbDynamic;
import bsiotmobile.mobile.extension.ApplicationException;
import bsiotmobile.mobile.mapper.MbCommentMapper;
import bsiotmobile.mobile.mapper.MbDynamicMapper;
import bsiotmobile.mobile.mapper.MbUserMapper;
import bsiotmobile.mobile.service.MbDynamicService;
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
 * @date 2019/3/10 16:43
 */
@Service
public class MbDynamicServiceImpl implements MbDynamicService {
    private Logger logger= LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private MbDynamicMapper mbDynamicMapper;
    @Autowired
    private MbCommentMapper mbCommentMapper;
    @Autowired
    private MbUserMapper mbUserMapper;
    @Override
    public RespMsg addDynamic(MbDynamic mbDynamic) {
        //读取用户头像链接
        String userImgUrlById = mbUserMapper.findUserImgUrlById(mbDynamic.getUserId());
        if(userImgUrlById!=null){
            mbDynamic.setUserImgUrl(userImgUrlById);
        }
        mbDynamic.setId(GetUUID.getUUID());
        mbDynamic.setCreatedAt(new Date());
        mbDynamic.setUpdatedAt(new Date());
        mbDynamicMapper.addDynamic(mbDynamic);

        return ResultUtils.success();
    }

    @Override
    public RespMsg showDynamicList() {
        List<MbDynamic> mbDynamics = mbDynamicMapper.showDynamicList();
        for(MbDynamic list:mbDynamics){
            //根据动态ID找到所有的评论，并且赋值进去
            List<MbComment> commentListByDid = mbCommentMapper.findCommentListByDid(list.getId());
            list.setCommentCount(commentListByDid.size());
            list.setList(commentListByDid);
        }
        return ResultUtils.success(mbDynamics);
    }

    @Override
    public RespMsg deleteDynamic(String id) {
        if(id==null){
            throw new ApplicationException("动态ID不能为空");
        }
        mbDynamicMapper.deleteDynamicById(id);
        return ResultUtils.success();
    }
}
