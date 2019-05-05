package bsiotmobile.mobile.common;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/4/24 1:27
 */
@Service
public class SendSmsUtils {
    private  Logger logger= LoggerFactory.getLogger(this.getClass().getName());
    //注册时发送验证码
    public CommonResponse sendCheckCode(String phoneNum,String checkCode){
        //todo 两个秘钥上阿里云找
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "", "");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        CommonResponse response=new CommonResponse();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        //发送的号码
        request.putQueryParameter("PhoneNumbers", phoneNum);
        //设置前面，需要提前去阿里云申请
        request.putQueryParameter("SignName", "双林物业");
        //模板类型，需要去阿里云申请
        request.putQueryParameter("TemplateCode", "SMS_164150959");
        //根据SDK文档拼接json格式的验证码，随机生成
        String jsonCode="{\"code\":\""+checkCode+"\"}";
        request.putQueryParameter("TemplateParam", jsonCode);
        try {
             response = client.getCommonResponse(request);
            logger.info("短信验证码返回日志："+response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return response;
    }
}
