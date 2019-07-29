import com.akso.spring.bean.Color;
import com.akso.spring.bean.ColorFactoryBean;
import com.akso.spring.bean.Person;
import com.akso.spring.config.CommonConfig;
import com.akso.spring.config.CommonConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;

@Configuration
@Import(CommonConfig.class)
public class CommonConfigTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CommonConfig.class);
        Person person = (Person) context.getBean("person");
        System.out.println(person);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);

        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = context.getEnvironment();

        String property = environment.getProperty("os.name");
        System.out.println(property);

        Arrays.stream(beanNamesForType).forEach(System.out::println);
    }

    @Test
    public void testImport() {
        AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext(CommonConfig2.class);
        printBeans(context);
    }

    @Test
    public void testFactoryBean() {
        AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext(CommonConfig2.class);
        Color bean1 = (Color) context.getBean("colorFactoryBean");
        Color bean2 = (Color) context.getBean("colorFactoryBean");
        System.out.println(bean1 == bean2);

        /**
         * 要获取工厂bean 本身， 我们需要给bean id 加一个前缀 & ， 这样就可以获取到工厂bean 本身
         */
        Object bean3 =  context.getBean("&colorFactoryBean");
        System.out.println(bean3.getClass());
        printBeans(context);
    }

    private void printBeans(AnnotationConfigApplicationContext context) {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }
}

