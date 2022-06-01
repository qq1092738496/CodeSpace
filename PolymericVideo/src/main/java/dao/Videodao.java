package dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.ibatis.annotations.Param;
import pojo.Video;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Andy
 * @time: 2021/8/23 7:42
 */

public interface Videodao {
    int addVideo(Video video);
    List<Video> ViewVideo();
    List<Video> limitVideo(@Param("Start") Integer Start, @Param("amount") Integer amount);
    Video View_one_Video(@Param("Video_Name") String Video_Name);
    String PlaySelect(@Param("Video_Name") String Video_Name);
    Integer Data_Sum();
    int removeNmae(@Param("Video_Name")String Video_Name);
    void removeVideo(@Param("id") Integer id);
    void modifyVideo(Video video);

}
