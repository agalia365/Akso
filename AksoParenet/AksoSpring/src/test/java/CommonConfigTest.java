import com.akso.spring.bean.Person;
import com.akso.spring.config.CommonConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Arrays;

@Configuration
@Import(CommonConfig.class)
public class CommonConfigTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(CommonConfig.class);
        context.refresh();
        Person person = (Person) context.getBean("person");
        System.out.println(person);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }
}
