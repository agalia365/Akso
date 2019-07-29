package com.akso.spring.config;

import com.akso.spring.bean.Person;
import com.akso.spring.condition.LinuxCondition;
import com.akso.spring.condition.WindowsCondition;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScans(
        value = {/*@ComponentScan(
                basePackages = {"com.akso.spring"}, excludeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.akso.spring.dao")
            }
        ),*/
        @ComponentScan(
                basePackages = {"com.akso.spring"}, excludeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM, value={MyTypeFilter.class})
            }
        )
        }
)
public class CommonConfig {

    @Bean
    @Scope(value = "singleton")
    public Person person() {
        Person person = new Person("Lee", 28, 2000000);
        return person;
    }

    @Bean
    @Conditional(WindowsCondition.class)
    protected Person person01() {
        Person person = new Person("Bill", 65, 1000000000);
        return person;
    }

    @Bean
    @Conditional(LinuxCondition.class)
    protected Person person02() {
        Person person = new Person("Linus", 66, 1000000000);
        return person;
    }
}

