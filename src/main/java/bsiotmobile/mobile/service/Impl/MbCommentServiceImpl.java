package bsiotmobile.mobile.service.Impl;

import bsiotmobile.mobile.common.GetUUID;
import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.common.ResultUtils;
import bsiotmobile.mobile.eo.MbComment;
import bsiotmobile.mobile.extension.ApplicationException;
import bsiotmobile.mobile.mapper.MbCommentMapper;
import bsiotmobile.mobile.service.MbCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/3/22 19:31
 */
@Service
public class MbCommentServiceImpl implements MbCommentService {
    @Autowired
    private MbCommentMapper mbCommentMapper;
    @Override
    public RespMsg addComment(MbComment mbComment) {
        mbComment.setId(GetUUID.getUUID());
        mbComment.setCreatedAt(new Date());
        mbComment.setUpdatedAt(new Date());
        if(mbComment.getdId()==null){
            throw new ApplicationException("评论ID不能为空");
        }
        if(mbComment.getContent()==null){
            throw new ApplicationException("评论不能为空");
        }
        mbCommentMapper.addComment(mbComment);
        return ResultUtils.success();
    }
}
