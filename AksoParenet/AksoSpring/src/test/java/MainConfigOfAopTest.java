import com.akso.spring.aop.MathCalculator;
import com.akso.spring.config.MainConfigOfAOP;
import com.akso.spring.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainConfigOfAopTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        MathCalculator mathCalculator = (MathCalculator)context.getBean("mathCalculator");
        int res = mathCalculator.div(10, 2);
        System.out.println(res);

    }
}
