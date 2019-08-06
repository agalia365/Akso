import com.akso.spring.bean.Person;
import com.akso.spring.config.MainConfigOfProfile;
import com.akso.spring.config.MainConfigOfProperty;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;


public class MainConfigOfProfileTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("test");
        context.register(MainConfigOfProfile.class);
        context.refresh();
        DataSource bean = context.getBean(DataSource.class);
        System.out.println(bean);
    }
}
