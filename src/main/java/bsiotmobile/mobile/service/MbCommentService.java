package bsiotmobile.mobile.service;

import bsiotmobile.mobile.common.RespMsg;
import bsiotmobile.mobile.eo.MbComment;
import bsiotmobile.mobile.eo.MbDynamic;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/3/10 16:42
 */
public interface MbCommentService {

    //新增评论
    RespMsg addComment(MbComment mbComment);


}
