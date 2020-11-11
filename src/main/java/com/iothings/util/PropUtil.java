package com.iothings.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import javax.xml.bind.PropertyException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 * @Package： com.iothings.util
 * @author： ZDL
 * @date： 2020/11/9 13:43
 * @version： V1.0
 * @Description：
 */
public class PropUtil {
    /**
     * 获取配置文件中的配置值方法,根据传入的配置文件名和key获取该值
     * @param fileName 配置文件名,需要在classes根目录
     * @param key	配置项名称
     * @return	配置项的值
     * @throws IOException	无法读取配置文件时
     * @throws PropertyException	配置项对应的值为空时
     */
    public static String getProperty(String fileName,String key) throws IOException, PropertyException {
        Resource resource = new ClassPathResource(fileName);
        Properties props = PropertiesLoaderUtils.loadProperties(resource);
        String value=props.getProperty(key);
        if(null==value){
            //logger.warn("尝试读取没有的配置项,配置文件:"+fileName+"中,无法找到配置项"+key);
            throw new PropertyException("尝试读取没有的配置项,配置文件:"+fileName+"中,无法找到配置项"+key);
        }

        return value;
    }
    public static void setProperty(String fileName,String key,String value) throws IOException, PropertyException{
        Resource resource = new ClassPathResource(fileName);
        Properties props = PropertiesLoaderUtils.loadProperties(resource);
        props.setProperty(key, value);
        String path=java.net.URLDecoder.decode(Thread.currentThread().getContextClassLoader().getResource(fileName).getPath(),"utf-8");
        OutputStream fos = new FileOutputStream(path);
        props.store(fos, "Update '" + key + "' value");
    }
}
