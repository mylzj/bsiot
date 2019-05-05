package bsiotmobile.mobile.eo;

import java.util.List;

/**
 * Demo class
 *用户动态实体类
 * @author drose
 * @date 2019/3/10 16:22
 */
public class MbDynamic extends BaseEo {
    //用户id
    private String userId;
    //用户姓名
    private String name;
    //用户的头像链接
    private String userImgUrl;
    //动态的内容
    private String content;
    //动态标题
    private String title;
    //图片链接
    private String imgUrl;
    //评论列表，非数据库存储字段
    private List<MbComment> list;
    //评论数
    private Integer commentCount;

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MbComment> getList() {
        return list;
    }

    public void setList(List<MbComment> list) {
        this.list = list;
    }

    public String getUserImgUrl() {
        return userImgUrl;
    }

    public void setUserImgUrl(String userImgUrl) {
        this.userImgUrl = userImgUrl;
    }
}
