package yjs.xmml.xmmlmanager.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import yjs.xmml.xmmlmanager.pojo.Film;

import java.util.List;

@Mapper
@Repository
public interface FilmDao {

    /**
     * 保存作品
     * @param film
     * @return
     */
    @Insert("insert into dm_films(film_name,film_code,film_provider_id,film_length,film_season,film_lables,film_content,film_shot_place," +
            "film_create_time,film_area,film_title,film_main_img,film_details_img,film_one_video,film_whole_video,film_price," +
            "film_type) " +
            "values" +
            "(#{filmName},#{filmCode},#{filmProviderId},#{filmLength},#{filmSeason},#{filmLables},#{filmContent},#{filmShotPlace}," +
            "#{filmCreateTime},#{filmArea},#{filmTitle},#{filmMainImg},#{filmDetailsImg},#{filmOneVideo},#{filmWholeVideo},#{filmPrice}," +
            "#{filmType})")
    Integer save(Film film);

    /**
     * 获取所有作品
     */
    @Select("select * from dm_films where film_flag=0")
    List<Film> getAllFilm();
}
