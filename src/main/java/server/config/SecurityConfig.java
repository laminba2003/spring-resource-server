package server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
        .authorizeRequests(authentication -> authentication
            .antMatchers(HttpMethod.GET, "/foos/**").hasAuthority("SCOPE_profile")
            .antMatchers(HttpMethod.POST, "/foos").hasAuthority("SCOPE_write")
            .anyRequest().authenticated())
        .oauth2ResourceServer(oauth2 -> oauth2.jwt());
	}
    
}