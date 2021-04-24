import com.proxy.proxyCalculator;
import com.proxy.util.Calculator;
import com.proxy.util.utilImpl.CalculatorImpl;

/**
 * @description:
 * @author: Andy
 * @time: 2020/10/4 22:31
 */

public class test {

    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        proxyCalculator proxyCalculator = new proxyCalculator();
        Calculator calculator1 = proxyCalculator.CalculatorLog(calculator);
        calculator1.add(1,1);
    }

}
