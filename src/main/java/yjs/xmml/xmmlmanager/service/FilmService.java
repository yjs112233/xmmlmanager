package yjs.xmml.xmmlmanager.service;

import org.springframework.web.multipart.MultipartFile;
import yjs.xmml.xmmlmanager.pojo.Film;

public interface FilmService {


    //作品信息保存到数据库
    Integer save(Film film);
}
