package bsiotmobile.mobile.common;

import bsiotmobile.mobile.extension.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Demo class
 *
 * @author drose
 * @date 2019/3/25 16:20
 */
public class ImagesUtils {
    //保存图片所在的文件夹
    private static String uploadDirPath="/home/upload/";
//    private static String uploadDirPath="E://upload/";
    /** 
    * @Description: 上传图片到服务器，并返回可以访问的图片路径（可直接保存到数据库）
    * @Param: [file] 
    * @return: java.lang.String 
    * @Author: rose
    * @Date: 2019/3/25 
    */
    public static String imgUpload(MultipartFile file){
        if(file==null){
            throw new ApplicationException("图片为空，请重新上传");
        }
        //获取格式
        String format=file.getOriginalFilename();
        //设置图片存储文件夹，一天一个文件夹
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        String dirName = sdf.format(new Date());
        File dirFile=new File(uploadDirPath+dirName);
        //如果文件夹不存在，先创建
        if(!dirFile.isDirectory()){
            dirFile.mkdir();
        }
        //设置文件名，用时间戳+源文件的名称
        String fileName=System.currentTimeMillis()+format.substring(format.lastIndexOf("."),format.length());
        String imgUrl=uploadDirPath+"/"+dirName+"/"+fileName;
        File path=new File(imgUrl);
        //设置可以直接访问的路径,可保存到数据库
        String dbImgUrl="http://39.108.106.29/"+dirName+"/"+fileName;
        try {
            file.transferTo(path);
        }catch (Exception e){
           System.out.println(e);
        }
        return dbImgUrl;
    }
}
