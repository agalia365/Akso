package com.akso.spring.config;

import com.akso.spring.bean.Color;
import com.akso.spring.bean.Person;
import com.akso.spring.bean.Red;
import com.akso.spring.condition.LinuxCondition;
import com.akso.spring.condition.MyImportSelector;
import com.akso.spring.condition.WindowsCondition;
import org.springframework.context.annotation.*;

@Configuration
/*@ComponentScans(
        value = {*//*@ComponentScan(
                basePackages = {"com.akso.spring"}, excludeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com.akso.spring.dao")
            }
        ),*//*
        @ComponentScan(
                basePackages = {"com.akso.spring"}, excludeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM, value={MyTypeFilter.class})
            }
        )
        }
)*/
@Import({Color.class, Red.class, MyImportSelector.class}) // 导入组件， id 默认是组件的全名
public class CommonConfig2 {

    /**
     * 给容器中注册组件的方式：
     * 1. 扫描包+ 组件标注注解[@Controller/@Service/@Repository/@Component][自己写的类文件]
     * 2. @Bean[导入的第三方包里面的组件]
     * 3. @Import[快速给容器导入一个组件]
     *      3.1 @Import(要导入到容器中的组件);容器中就会自动注册这个组件， id默认是全类名
     *      3.2 ImportSelector: 返回需要导入的组件的全类名数租
     *      3.3
     */

}

