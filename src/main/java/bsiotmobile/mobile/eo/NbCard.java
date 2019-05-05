package bsiotmobile.mobile.eo;

import java.io.Serializable;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/3/3 16:38
 */
public class NbCard extends BaseEo {

    //门卡ID
    private String cardId;

    //所属住户的姓名
    private String userName;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
