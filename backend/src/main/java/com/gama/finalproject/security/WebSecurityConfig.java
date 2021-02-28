package com.gama.finalproject.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .csrf()
                .disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/cadastro").permitAll()
            .antMatchers(HttpMethod.POST, "/login").permitAll()
            .antMatchers("/v2/api-docs",
                         "/configuration/ui",
                         "/swagger-resources/**",
                         "/configuration/security",
                         "/swagger-ui.html",
                         "/webjars/**",
                         "/csrf").permitAll()
            .anyRequest().authenticated()
            // .anyRequest().permitAll() // Se quiserem remover o login, comentem a linha de cima e descomenta essa :D
            .and()
            .headers().frameOptions().sameOrigin()// Fazer o h2 funcionar
            .and()
            .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
            .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("SELECT usuario, senha, 1 FROM Administrador WHERE usuario = ?")
            .passwordEncoder(passwordEncoder())
            .authoritiesByUsernameQuery("SELECT ?, 'ROLE_USER';");
    }

    @Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
