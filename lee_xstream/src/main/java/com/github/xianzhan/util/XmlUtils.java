package com.github.xianzhan.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class XmlUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(XmlUtils.class);

    /**
     * pojo 对象转 XML
     *
     * @param object
     * @return
     */
    public static String toXml(Object object) {
        //XStream xstream=new XStream(); //默认使用xpp解析器
        //指定编码解析器
        XStream xstream = new XStream(new DomDriver("UTF-8"));
        //启用注解识别
        xstream.processAnnotations(object.getClass());
        return xstream.toXML(object);
    }

    /**
     * 将传入xml文本转换成Java对象
     *
     * @param xmlStr
     * @param cls    xml对应的class类
     * @return T  xml对应的class类的实例对象
     */
    public static <T> T toBean(String xmlStr, Class<T> cls) {
        XStream xstream = new XStream();
        xstream.processAnnotations(cls);
        T obj = (T) xstream.fromXML(xmlStr);
        return obj;
    }

    /**
     * 写到xml文件中去
     *
     * @param obj      对象
     * @param absPath  绝对路径
     * @param fileName 文件名
     */
    public static boolean toXMLFile(Object obj, String absPath, String fileName) {
        String strXml = toXml(obj);
        String filePath = absPath + fileName;
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                LOGGER.error("file creation failed, cause is {}", e);
                return false;
            }
        }
        OutputStream ous = null;
        try {
            ous = new FileOutputStream(file);
            ous.write(strXml.getBytes());
            ous.flush();
        } catch (Exception e1) {
            LOGGER.error("file write failed, cause is {}", e1);
            return false;
        } finally {
            if (ous != null)
                try {
                    ous.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return true;
    }

    /**
     * 从xml文件读取报文
     *
     * @param absPath  绝对路径
     * @param fileName 文件名
     * @param cls
     */
    public static <T> T toBeanFromFile(String absPath, String fileName, Class<T> cls) throws Exception {
        String filePath = absPath + fileName;
        InputStream ins = null;
        try {
            ins = new FileInputStream(new File(filePath));
        } catch (Exception e) {
            throw new Exception("read {" + filePath + "} file failed！", e);
        }
        XStream xstream = new XStream();
        xstream.processAnnotations(cls);
        T obj = null;
        try {
            obj = (T) xstream.fromXML(ins);
        } catch (Exception e) {
            throw new Exception("parse {" + filePath + "} file failed！", e);
        }
        if (ins != null)
            ins.close();
        return obj;
    }
}
