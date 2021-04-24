import com.meditation.service.impl.Calculatorimpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @description:
 * @author: Andy
 * @time: 2020/7/6 18:33
 */

@ContextConfiguration(locations = "classpath:applicationtext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class test {

    @Autowired
    Calculatorimpl calculatorimpl;

    @Test
    public void test1() {
        /**
         * @author: Andy
         * @param
         * @return: void
         * @time: 2020/7/7 12:20
         * @description:
         *  1. 被代理类实现了接口:
         *      Spring将会调用jdk原生的(必须要实现接口)的代理方法,所返回的是代理实现过后的接口类型;
         *      所以,要拿到代理对象,必须用实现的接口来接收, 容器中的实现类,实为代理对象;
         *      被代理后的对象 在容器中类型为 class com.sun.proxy.$Proxy18;
         *         ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationtext.xml");
         *         Calculator calculator = (Calculator) ioc.getBean("calculatorimpl");
         *         calculator.add(1,1);
         *  2. 被代理类没有实现接口:
         *      Spring将会调用,专门做代理的架包cjlib,具体实现原理尚未可知,所以返回的是被代理实现过后的接口类型;
         *      不一样的是,要拿到代理对象, 可以通过实现类,来接受代理类, 容器中的实现类,实为代理对象;
         *      被代理后的对象 在容器中类型为 class com.meditation.service.impl.Calculatorimpl$$EnhancerBySpringCGLIB$$8e03e5ae
         *         ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationtext.xml");
         *         Calculatorimpl calculatorimpl = (Calculatorimpl) ioc.getBean("calculatorimpl");
         *         calculatorimpl.add(1, 1);
         */
        calculatorimpl.add(555, 44);
        calculatorimpl.mul(5, 44);
        calculatorimpl.sub(44, 5);
        calculatorimpl.div(100, 10);


    }
}
