package controller;

import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: Andy
 * @time: 2021/10/4 20:19
 */
public interface VideoController {
    public String Videopage(String Page, String PageSzie, HttpServletResponse response,
                            HttpServletRequest request);

}
