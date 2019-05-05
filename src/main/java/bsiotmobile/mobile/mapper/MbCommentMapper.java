package bsiotmobile.mobile.mapper;

import bsiotmobile.mobile.eo.MbComment;
import bsiotmobile.mobile.eo.MbDynamic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/3/22 16:55
 */
@Mapper
@Component
public interface MbCommentMapper {
    //新增评论
    void addComment(@Param("eo")MbComment mbComment);

    //显示评论列表
    List<MbComment> findCommentListByDid(@Param("did")String id);
}
