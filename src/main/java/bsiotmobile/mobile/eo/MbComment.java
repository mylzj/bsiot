package bsiotmobile.mobile.eo;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/3/10 16:27
 */
public class MbComment extends BaseEo {

    //用户id
    private String userId;
    //用户姓名
    private String userName;
    //所评论的动态id
    private String dId;
    //评论内容
    private String content;
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
