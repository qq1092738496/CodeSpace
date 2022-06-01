package service;

import dao.Videodao;
import org.springframework.beans.factory.NamedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Video;
import pojo.VideoPaging;

import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2021/8/27 20:46
 */

@Service
public class VideoServiceImpl implements VideoService   {

    @Autowired
    Videodao videodao;

    public int addVideo(Video video) {
        int i = videodao.addVideo(video);
        return i;
    }

    public List<Video> ViewVideo() {
        List<Video> videos = videodao.ViewVideo();
        return videos;
    }

    public VideoPaging Videopage(int Page, int PageSzie) {
        VideoPaging videoPaging = new VideoPaging();
        List<Video> videos = videodao.limitVideo((Page-1)*PageSzie, PageSzie);
        videoPaging.setData_Actual(videos);
        videoPaging.setData_Sum(videodao.Data_Sum());
        videoPaging.setCurrent_Page(Page);
        videoPaging.setPage_Size(PageSzie);

        return videoPaging;
    }
}
