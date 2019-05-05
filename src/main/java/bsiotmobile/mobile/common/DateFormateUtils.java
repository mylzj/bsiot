package bsiotmobile.mobile.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/2/18 22:41
 */
public class DateFormateUtils {

    public static Date StringToDtae(String str) throws ParseException {
//        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(str);
    }
}
