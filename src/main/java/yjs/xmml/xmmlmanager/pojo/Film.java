package yjs.xmml.xmmlmanager.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Film {
    /**id*/
    private Integer filmId;
    /**初始名称*/
    private String filmName;
    /**作品编号*/
    private String filmCode;
    /**提供者*/
    private Integer filmProviderId;
    /**时长*/
    private String filmLength;
    /**类型*/
    private String filmType;
    /**季节*/
    private String filmSeason;
    /**关键词*/
    private String filmLables;
    /**标题描述*/
    private String filmTitle;
    /**内容简介*/
    private String filmContent;
    /**拍摄地点*/
    private String filmShotPlace;
    /**拍摄时间*/
    private String filmCreateTime;
    /**放置区域*/
    private String filmArea;
    /**作品主图*/
    private String filmMainImg;
    /**详图*/
    private String filmDetailsImg;
    /**1分钟短视频*/
    private String filmOneVideo;
    /**完整样片*/
    private String filmWholeVideo;
    /**价格*/
    private String filmPrice;
    /**vip价格*/
    private String filmVipPrice;
    /**被点击次数*/
    private Integer filmClickNumber;
    /**软删除*/
    private Integer filmFlag;
}
