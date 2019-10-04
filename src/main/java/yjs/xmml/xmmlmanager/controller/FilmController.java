package yjs.xmml.xmmlmanager.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import yjs.xmml.xmmlmanager.config.Content;
import yjs.xmml.xmmlmanager.pojo.Film;
import yjs.xmml.xmmlmanager.service.FilmService;
import yjs.xmml.xmmlmanager.tools.FileSave;
import java.util.UUID;
import java.util.*;
@Controller
@RequestMapping("film")
public class FilmController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    FilmService filmService;

    /**
     * 作品上传
     */
    @RequestMapping("upload")
    @ResponseBody
    public String  uploadFilm(Film film, MultipartFile mainImg,
                           MultipartFile details0,MultipartFile details1,
                           MultipartFile details2,MultipartFile details3,
                           MultipartFile details4,MultipartFile details5,
                           MultipartFile oneVideo,MultipartFile wholeVideo) {
        //文件名防重处理
        String fileName=film.getFilmName()+"_"+ UUID.randomUUID().toString().substring(0,2);
        try {
            //主图
            film.setFilmMainImg(FileSave.mainImg(fileName,mainImg));
            //详图
            StringBuilder sb=new StringBuilder();
            //间隔符
            String s=Content.interval;
            sb.append(FileSave.detailsImg(fileName,details0)+s);
            sb.append(FileSave.detailsImg(fileName,details1)+s);
            sb.append(FileSave.detailsImg(fileName,details2)+s);
            sb.append(FileSave.detailsImg(fileName,details3)+s);
            sb.append(FileSave.detailsImg(fileName,details4)+s);
            sb.append(FileSave.detailsImg(fileName,details5)+s);
            film.setFilmDetailsImg(sb.toString());
            //1分钟短视频
            if (oneVideo!=null){
                film.setFilmOneVideo(FileSave.oneVideo(fileName,oneVideo));
            }
            //完整样片
            if (wholeVideo!=null){
                film.setFilmWholeVideo(FileSave.wholeVideo(fileName,wholeVideo));
            }
        }catch (Exception e){
            logger.info("【文件存储异常】");
            return "文件储存异常";
        }
        //储存
        filmService.save(film);
        return "上传成功";
    }


    /**
     *获取所有作品
     */
    @RequestMapping("all")
    @ResponseBody
    public List<Film> getAllFilm(){
        List<Film> list= filmService.getAllFilm();
        logger.info("【作品总数:{}】",list.size());
        return list;
    }
}
