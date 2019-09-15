package yjs.xmml.xmmlmanager.config;

import org.springframework.beans.factory.annotation.Value;

import java.io.File;

public class Content {

    /**系统文件上传固定路径*/
//    @Value("${file.upload}")
    public  static String sysUploadUrl="C:/films/";
    public final static String mainImg="_mainImg";
    public final static String detailsImg="_detailsImg_";
    public final static String oneVideo="_1_video";
    public final static String wholeVideo="_whole_video";
    public final static String interval=",";     //details详图间隔符
    public final static String xl= File.separator;     //斜杠


}
