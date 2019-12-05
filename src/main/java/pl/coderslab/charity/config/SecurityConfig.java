package pl.coderslab.charity.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
        import org.springframework.security.config.annotation
        .web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import pl.coderslab.charity.user.SpringDataUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests()
                        .antMatchers("/index").permitAll()
                        .antMatchers("/resources/**").permitAll()
                        .antMatchers("/img/**").permitAll()
                        .antMatchers("/logoutSuccess").permitAll()
                        .antMatchers("/login").permitAll()
                        .antMatchers("/register/**").permitAll()
                        .antMatchers("/form/**").hasAnyRole("USER", "ADMIN")
                        .antMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest()
                        .authenticated()
//                        .permitAll()

                        .and()
                        .formLogin()
                        .loginPage("/login").failureUrl("/login?error=true")
                        .defaultSuccessUrl("/index")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .and().logout()
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/logoutSuccess").
                        and().exceptionHandling()
                        .accessDeniedPage("/access-denied");
        }

        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public SpringDataUserDetailsService customUserDetailsService() {
                return new SpringDataUserDetailsService();
        }
}
