package com.marczyk.forum.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final static String USER_ROLE_NAME = "ADMIN";

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/contact", "/all_publications").permitAll()
                .antMatchers(HttpMethod.GET, "/publication").permitAll()
                .antMatchers("/publication").hasAnyRole(USER_ROLE_NAME)
                .antMatchers("/img/**").permitAll()
                .antMatchers("/**/*.js", "/**/*.css").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/",true)
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll();
    }

    @Autowired
    public void authenticationConfig(AuthenticationManagerBuilder builder) throws Exception {

        builder.inMemoryAuthentication()
                .withUser("admin")
                .password(PasswordEncoderFactories
                        .createDelegatingPasswordEncoder()
                        .encode("admin"))
                .roles(USER_ROLE_NAME);
    }
}
