package bsiotmobile.mobile.common;

/**
 * Demo class
 *返回信息工具类
 * @author drose
 * @date 2019/1/10 14:38
 */
public class ResultUtils {

    public static RespMsg success(Object object){
        RespMsg msg=new RespMsg();
        msg.setCode(200);
        msg.setMsg("请求成功");
        msg.setData(object);
        return msg;
    }
    public static RespMsg success(){
        return success(null);
    }

    public static RespMsg error(String msg,Integer code){
        RespMsg emsg=new RespMsg();
        emsg.setCode(code);
        emsg.setMsg(msg);
        return emsg;
    }
}
