package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pojo.VideoPaging;
import service.VideoService;
import util.JacksonSerialize;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;

/**
 * @description:
 * @author: Andy
 * @time: 2021/8/28 2:57
 */
@RestController
public class VideoControllerImpl implements VideoController {

    @Autowired
    VideoService videoService;


    @GetMapping(path = "/page/{Page},{PageSzie}", produces = "application/json; charset=utf-8")
    public String Videopage(@PathVariable String Page, @PathVariable String PageSzie, HttpServletResponse response,
                            HttpServletRequest request) {
        response.setHeader("Access-Control-Allow-Origin", "*");

        String pagejson = null;
        if (null != Page && null != PageSzie) {
            System.out.println(Page + "\n" + PageSzie);
            try {
                VideoPaging videopage = videoService.Videopage(Integer.valueOf(Page), Integer.valueOf(PageSzie));

                ObjectMapper mapper = new ObjectMapper();
                SimpleModule simpleModule = new SimpleModule();
                SimpleModule module = simpleModule.addSerializer(new JacksonSerialize());
                mapper.registerModule(module);
                pagejson = mapper.writeValueAsString(videopage);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pagejson;
    }

    @GetMapping(value = "/image/{id}", produces = "image/png")
    public void img(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("image/jpg");
        if (null != id) {
            String imageid = "E:\\CodeSpace\\PolymericVideo\\src\\main\\resources\\image\\"+id+".jpg";
            try {
                FileInputStream inputStream = new FileInputStream(new File(imageid));
                byte[] bytes = new byte[inputStream.available()];
                int len;
                while ((len = inputStream.read(bytes)) != -1) {
                    System.out.print(new String(bytes,0,len));
                }

                ServletOutputStream outputStream = response.getOutputStream();
                outputStream.write(bytes);

                inputStream.close();
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
