package service;

import pojo.Video;
import pojo.VideoPaging;

import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2021/8/27 20:42
 */
public interface VideoService  {
     int addVideo(Video video);
    List<Video> ViewVideo();
    VideoPaging Videopage(int Page, int DataSzie);

}
