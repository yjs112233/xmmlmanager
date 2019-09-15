package yjs.xmml.xmmlmanager.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yjs.xmml.xmmlmanager.pojo.Film;

@Mapper
@Repository
public interface FilmDao {

    @Insert("insert into dm_films(film_name,film_code,film_provider,film_length,film_season,film_lables,film_content,film_shot_place," +
            "film_create_time,film_main_img,film_details_img,film_one_video,film_whole_video,film_price) " +
            "values" +
            "(#{filmName},#{filmCode},#{filmProvider},#{filmLength},#{filmSeason},#{filmLables},#{filmContent},#{filmShotPlace}," +
            "#{filmCreateTime},#{filmMainImg},#{filmDetailsImg},#{filmOneVideo},#{filmWholeVideo},#{filmPrice})")
    Integer save(Film film);
}
