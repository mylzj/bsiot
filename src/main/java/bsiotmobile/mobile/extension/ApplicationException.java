package bsiotmobile.mobile.extension;

import java.io.Serializable;

/**
 * Demo class
 *自定义异常类
 * @author drose
 * @date 2019/3/21 16:24
 */
public class ApplicationException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -7110316208734638051L;

    public ApplicationException(String msg) {
        super(msg);
    }
}
