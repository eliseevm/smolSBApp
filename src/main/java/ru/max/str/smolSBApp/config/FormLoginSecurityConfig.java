package ru.max.str.smolSBApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class FormLoginSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         Конфигурация Spring Security
//         Конфигурация авторизации
        http
                .authorizeHttpRequests()
                .requestMatchers("/index", "/index/reg", "/index/termsOfUse", "/index/getemptyform",
                        "/select/register", "/select/sign_in")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/select/sign_in")
                .loginProcessingUrl("/process_login")
                .defaultSuccessUrl("/select/select", true)
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/index");

        return http.build();
    }

    //  Настройка аутентификации.
    @Bean
    protected AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception {
        return auth.getAuthenticationManager();
    }

    // Кодировка паролей
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
