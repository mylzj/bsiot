package bsiotmobile.mobile.eo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/1/10 0:34
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class User extends BaseEo{


    //用户名称
    private String name;
    //用户性别
    private Integer sex;
    //用户手机号码
    private String phoneNum;
    //密码
    private String password;
    //类型
    private String type;
    //门牌号
    private String houseNum;
    //审核状态
    private String status;
    //卡号
    private String cardId;
    //头像图片链接
    private String imgUrl;
    //验证码，非存储字段
    private String checkCode;


    public User() {
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", phoneNum='" + phoneNum + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", houseNum='" + houseNum + '\'' +
                ", status='" + status + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
