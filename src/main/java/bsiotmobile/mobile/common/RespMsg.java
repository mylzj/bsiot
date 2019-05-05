package bsiotmobile.mobile.common;

/**
 * Demo class
 *返回信息的统一包装
 * @author drose
 * @date 2019/1/10 14:30
 */
public class RespMsg<T> {
    //错误码
    private Integer code;
    //提示信息
    private String msg;
    //返回的具体信息
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
