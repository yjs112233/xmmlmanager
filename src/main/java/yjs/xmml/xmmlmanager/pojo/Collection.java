package yjs.xmml.xmmlmanager.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Collection {

    private Integer collectionId;
    private Integer collectionUserId;
    private Date collectionCreateTime;
    /**收藏作品id*/
    private Integer collectionFilmId;
    private String collectionFilmImg;
    private Integer collectionFlag;
    /**作品详情*/
    private Film film;
}
