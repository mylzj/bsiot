package bsiotmobile.mobile.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/1/11 15:14
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {


    //websocket配置类
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }


    @Bean
    //必须加bean，将组件加入到容器中，才会生效
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer configurer= new WebMvcConfigurer(){
            //视图解析器
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/member.html").setViewName("member");
                registry.addViewController("/register.html").setViewName("register");
                registry.addViewController("/repair.html").setViewName("repair");
                registry.addViewController("/demo1.html").setViewName("demo1");
            }

            //拦截器
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandelInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/","/login.html","/member.html","/register.html");
//            }
        };
        return configurer;
    }


}
