import com.akso.spring.bean.Person;
import com.akso.spring.config.MainConfigOfLifeCycle;
import com.akso.spring.config.MainConfigOfProperty;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainConfigOfPropertyTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfProperty.class);
        Person person = (Person) context.getBean("person");

        System.out.println(person);
    }
}
