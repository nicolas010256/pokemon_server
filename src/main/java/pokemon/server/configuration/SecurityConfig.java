package pokemon.server.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Define o algoritmo de criptografia utilizado para criptografar senhas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configuração de Segurança
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .disable() // Desabilita a autenticação HTTP Basic
            .csrf()
                .disable(); // Desabilita Cross-Site Request Forgery                
    }

    // Registra o filtro de autenticação
    @Bean
    public FilterRegistrationBean<AuthFilter> authFilter() {

        // Cria um registrador de filtros
        FilterRegistrationBean<AuthFilter> registrationBean
            = new FilterRegistrationBean<>();
        
        // Define o filtro que será registrado
        registrationBean.setFilter(new AuthFilter());
        
        // Define a rota na qual o filtro será utilizado
        registrationBean.addUrlPatterns("/user/team/*");

        return registrationBean;
    }

}