package com.clientes.api.auth;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

import static com.clientes.api.constants.ApplicationConstants.*;

@EnableResourceServer
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    /*  Use this configuration if you are not using @EnableGlobalMethodSecurity
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, PUBLIC_ENDPOINTS).permitAll()
                .antMatchers(HttpMethod.GET, SHOW_CLIENT_ENDPOINT).hasAnyRole(USER_ROLE, ADMIN_ROLE)
                .antMatchers(HttpMethod.POST, UPLOAD_CLIENT_ENDPOINT).hasAnyRole(USER_ROLE, ADMIN_ROLE)
                .antMatchers(HttpMethod.POST, CREATE_CLIENT_ENDPOINT).hasRole(ADMIN_ROLE)
                .antMatchers(PRIVATE_ENDPOINTS).hasRole(ADMIN_ROLE)
                .anyRequest().authenticated();
    }*/

    /* Use this configuration if you are using @EnableGlobalMethodSecurity and the @Secured annotations */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, GET_PUBLIC_ENDPOINTS).permitAll()
                .anyRequest().authenticated()
                .and().cors().configurationSource(corsConfigurationSource());
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Arrays.asList(ANGULAR_APP_ALLOWED_ORIGIN, ALL_ORIGINS));
        configuration.setAllowedMethods(Arrays.asList(ALLOWED_METHODS));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList(ALLOWED_HEADERS));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(CORS_CONFIGURATION_PATTERN, configuration);
        return source;
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> filterFilterRegistrationBean =
                new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));
        filterFilterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return filterFilterRegistrationBean;
    }


}
