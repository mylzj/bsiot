package bsiotmobile.mobile.common;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/2/18 23:01
 */
public class StringUtils {

    public static boolean idNotBlank(String s){
        if(s!=null&&s.equals("")){
            return true;
        }else{
            return false;
        }
    }
}
