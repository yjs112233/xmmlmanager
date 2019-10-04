package yjs.xmml.xmmlmanager.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import yjs.xmml.xmmlmanager.dao.FilmDao;
import yjs.xmml.xmmlmanager.pojo.Film;
import yjs.xmml.xmmlmanager.service.FilmService;
import yjs.xmml.xmmlmanager.tools.FileSave;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class FileServiceImpl implements FilmService {

    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    FilmDao filmDao;
    @Override
    public Integer save(Film film) {
        return filmDao.save(film);
    }

    @Override
    public List<Film> getAllFilm() {
        return filmDao.getAllFilm();
    }
}
