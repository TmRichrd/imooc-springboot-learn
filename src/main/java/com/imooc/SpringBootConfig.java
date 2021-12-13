package com.imooc;

import com.imooc.pojo.Stu;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootConfig {
    @Bean
    public Stu stu() {
        return new Stu("jack", 18);
    }
}
