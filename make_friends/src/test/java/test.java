import com.xad.pojo.News;
import com.xad.pojo.User;
import com.xad.pojo.UserPage;
import com.xad.service.Display_Data;
import com.xad.service.User_Function;
import com.xad.service.serviceImpl.Display_DataImpl;
import com.xad.service.serviceImpl.User_functionImpl;
import org.junit.Test;

import java.util.LinkedList;
import java.util.UUID;


/**
 * @description:
 * @author: Andy
 * @time: 2022/5/3 11:45
 */

public class test {
    @Test
    public void test() {
        /*String s = UUID.randomUUID().toString();
        System.out.println(s);*/
        User user = new User();
        user.setUserNumber(UUID.randomUUID().toString());
        user.setUserName("45564564");
        user.setPassWord("123456");
        user.setName("456456");
        user.setMailbox("45646465");
        /*User_Function user_function = new User_functionImpl();
        System.out.println(user_function.Register(user));*/

        Display_Data display_data = new Display_DataImpl();


    }

    @Test
    public void test2() {
        User_Function user_function = new User_functionImpl();
        UserPage userPage = user_function.likeUser("23", 1, 5);
        System.out.println(userPage);

    }
}
