package com.almousleck.spring3;

import com.almousleck.spring3.models.Role;
import com.almousleck.spring3.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoSpringboot3Application {
    public static void main(String[] args) {
        SpringApplication.run(DemoSpringboot3Application.class, args);
    }

    @Bean
    CommandLineRunner runner(RoleRepository roleRepository) {
        return args -> {
            Role role = new Role(1L,"ROLE_USER");
            Role admin = new Role(2L,"ROLE_ADMIN");
            roleRepository.saveAll(List.of(role, admin));
        };

    }
}
