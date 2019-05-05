package bsiotmobile.mobile.common;

import java.util.UUID;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/2/18 22:27
 */
public class GetUUID {
    //返回32位UUID随机字符串
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
