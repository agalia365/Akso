package com.akso.spring.config;

import com.akso.spring.bean.Person;
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
    @Scope
    public Person person() {
        Person person = new Person();
        person.setAge(18);
        person.setName("Lee");
        person.setSalar(50000);
        return person;
    }
}

