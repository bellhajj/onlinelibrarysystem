package com.bagudu.mvp;

import com.bagudu.mvp.security.SpringSecurityAuditorAware;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class MvpApplication {

    @Bean
    public AuditorAware<String> auditorAware() {

        return new SpringSecurityAuditorAware();
    }

    public static void main(String[] args) {
        SpringApplication.run(MvpApplication.class, args);
    }

}
