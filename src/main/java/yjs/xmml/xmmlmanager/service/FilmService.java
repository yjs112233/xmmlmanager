package yjs.xmml.xmmlmanager.service;

import org.springframework.web.multipart.MultipartFile;
import yjs.xmml.xmmlmanager.pojo.Film;
import java.util.*;
public interface FilmService {


    //作品信息保存到数据库
    Integer save(Film film);

    //获取所有作品
    List<Film> getAllFilm();
}
