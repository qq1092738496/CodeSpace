import com.meditation.service.Calculator;
import com.meditation.service.impl.Calculatorimpl2;
import com.meditation.util.CalculatorProxy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ProjectName: Springdemo
 * @Package: PACKAGE_NAME
 * @ClassName: test
 * @Author: yf
 * @Description: ${description}
 * @Date: 2020/7/4 21:36
 */

public class test {
    ApplicationContext IOC = new ClassPathXmlApplicationContext("applicationtext.xml");

    @Test
    public void test1() {
      //  Calculatorimpl2 calculator = IOC.getBean(Calculatorimpl2.class);
       // Calculator proxy = CalculatorProxy.getgetProxy(calculator);
        //proxy.add(1, 1);
        System.out.println("aaaaa");
    }
    
    public static void main(String[] args) {
        System.out.println("aaaaa");
    }
}
