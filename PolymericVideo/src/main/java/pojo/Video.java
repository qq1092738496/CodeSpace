package pojo;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @description:
 * @author: Andy
 * @time: 2021/8/23 7:17
 */
public class Video {
    private int id;
    private String Video_Name; //电影名字；
    private String Cover; //封面
    private String Director; //导演；
    private String Screenwriter; //编剧
    private String Starring; //主演
    private String Introduce; //剧情
    private String Quality; //电影是品质，电视剧是级数；
    private String label; //标签，利于模糊查询；
    private String Film_length; //片长
    private String Release_Time; //上映时间

    private String play; //下载地址

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVideo_Name() {
        return Video_Name;
    }

    public void setVideo_Name(String video_Name) {
        Video_Name = video_Name;
    }

    public String getCover() {
        return Cover;
    }

    public void setCover(String cover) {
        Cover = cover;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getScreenwriter() {
        return Screenwriter;
    }

    public void setScreenwriter(String screenwriter) {
        Screenwriter = screenwriter;
    }

    public String getStarring() {
        return Starring;
    }

    public void setStarring(String starring) {
        Starring = starring;
    }

    public String getIntroduce() {
        return Introduce;
    }

    public void setIntroduce(String introduce) {
        Introduce = introduce;
    }

    public String getQuality() {
        return Quality;
    }

    public void setQuality(String quality) {
        Quality = quality;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getFilm_length() {
        return Film_length;
    }

    public void setFilm_length(String film_length) {
        Film_length = film_length;
    }

    public String getRelease_Time() {
        return Release_Time;
    }

    public void setRelease_Time(String release_Time) {
        Release_Time = release_Time;
    }

    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", Video_Name='" + Video_Name + '\'' +
                ", Cover='" + Cover + '\'' +
                ", Director='" + Director + '\'' +
                ", Screenwriter='" + Screenwriter + '\'' +
                ", Starring='" + Starring + '\'' +
                ", Introduce='" + Introduce + '\'' +
                ", Quality='" + Quality + '\'' +
                ", label='" + label + '\'' +
                ", Film_length='" + Film_length + '\'' +
                ", Release_Time='" + Release_Time + '\'' +
                ", play='" + play + '\'' +
                '}';
    }

    public Video(int id, String video_Name, String cover, String director, String screenwriter, String starring,
                 String introduce, String quality, String label, String film_length, String release_Time, String play) {
        this.id = id;
        Video_Name = video_Name;
        Cover = cover;
        Director = director;
        Screenwriter = screenwriter;
        Starring = starring;
        Introduce = introduce;
        Quality = quality;
        this.label = label;
        Film_length = film_length;
        Release_Time = release_Time;
        this.play = play;
    }

    public Video() {
    }
}
