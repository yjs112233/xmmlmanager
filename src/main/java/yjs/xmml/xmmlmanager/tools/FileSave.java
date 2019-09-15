package yjs.xmml.xmmlmanager.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import yjs.xmml.xmmlmanager.config.Content;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileSave {

    private static Logger logger= LoggerFactory.getLogger(FileSave.class);

    /**
     * 主图上传
     * @param name
     * @param mainImg
     */
    public static String mainImg(String name, MultipartFile mainImg) throws IOException {
            //作品文件夹
            String path=Content.sysUploadUrl+name;
            File file=new File(path);
            if (!file.exists()){
                file.mkdirs();
                logger.info("【文件夹不存在,创建:{}】",path);
            }

            //主图储存路径
            String mainImgPath=path+Content.xl+name+Content.mainImg+FileSave.getFormat(mainImg);
            //数据库储存路径
            String dataPath=name+Content.xl+name+Content.mainImg+FileSave.getFormat(mainImg);
            File mainImgFile=new File(mainImgPath);
            if (!mainImgFile.exists()){
                mainImgFile.createNewFile();
            }
            mainImg.transferTo(mainImgFile);
            logger.info("【主图:{},保存成功】",mainImgPath);
            return dataPath;
    }

    /**
     * 详图上传
     * @param name
     * @param detailsImg
     */
    public static String detailsImg(String name,MultipartFile detailsImg) throws IOException {
        //作品文件夹
        String path=Content.sysUploadUrl+name;
        File file=new File(path);
        if (!file.exists()){
            file.mkdirs();
            logger.info("【文件夹不存在,创建:{}】",path);
        }

        //文件名
        String filePath=Content.xl+name+Content.detailsImg+
                UUID.randomUUID().toString().substring(0,3)+FileSave.getFormat(detailsImg);
        //详图储存路径
        String detail=path+filePath;
        //数据库储存路径
        String dataPath=name+filePath;
        File detailFile=new File(detail);
        if (!detailFile.exists()){
            detailFile.createNewFile();
        }
        detailsImg.transferTo(detailFile);
        logger.info("【详图:{},保存成功】",detail);
        return dataPath;
    }

    /**
     * 1分钟短视频
     * @param name
     * @param oneVideo
     */
    public static String oneVideo(String name,MultipartFile oneVideo) throws IOException {
        //作品文件夹
        String path=Content.sysUploadUrl+name;
        File file=new File(path);
        if (!file.exists()){
            file.mkdirs();
            logger.info("【文件夹不存在,创建:{}】",path);
        }
        //1分钟视频
        String onePath=path+Content.xl+name+Content.oneVideo+FileSave.getFormat(oneVideo);
        //数据库储存路径
        String dataPath=name+Content.xl+name+Content.oneVideo+FileSave.getFormat(oneVideo);
        File one=new File(onePath);
        if (!one.exists()){
            one.createNewFile();
        }
        oneVideo.transferTo(one);
        logger.info("【1分钟短视频:{},保存成功】",onePath);
        return dataPath;
    }

    /**
     * 完整样片
     * @param name
     * @param wholeVideo
     */
    public static String wholeVideo(String name,MultipartFile wholeVideo) throws IOException {
        //作品文件夹
        String path=Content.sysUploadUrl+name;
        File file=new File(path);
        if (!file.exists()){
            file.mkdirs();
            logger.info("【文件夹不存在,创建:{}】",path);
        }
        //完整样片
        String wholePath=path+Content.xl+name+Content.wholeVideo+FileSave.getFormat(wholeVideo);
        //数据库储存路径
        String dataPath=name+Content.xl+name+Content.wholeVideo+FileSave.getFormat(wholeVideo);
        File whole=new File(wholePath);
        if (!whole.exists()){
            whole.createNewFile();
        }
        wholeVideo.transferTo(whole);
        logger.info("【完整样片:{},保存成功】",wholePath);
        return dataPath;
    }

    /**
     * 格式获取
     */
    public static String getFormat(MultipartFile file){
        //获取格式
        int index=file.getOriginalFilename().lastIndexOf(".");
        String ft=file.getOriginalFilename().substring(index);
        return  ft;
    }
}
