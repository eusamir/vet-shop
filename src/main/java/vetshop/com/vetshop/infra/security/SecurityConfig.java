package vetshop.com.vetshop.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    SecurityFilter securityFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/animal").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/cliente").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/consulta").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/exame").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/funcionario").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/raca").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/receita").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/tipo/create").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/tratamento-consulta").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/medico-veterinario").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/animal").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/cliente").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/consulta").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/exame").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/funcionario").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/raca").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/receita").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/tipo").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/tratamento-consulta").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/medico-veterinario").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/animal").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/cliente").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/consulta").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/exame").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/funcionario").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/raca").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/receita").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/tipo").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/tratamento-consulta").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/medico-veterinario").hasRole("EMPLOYEE")

                        .anyRequest()
                        .authenticated())
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
