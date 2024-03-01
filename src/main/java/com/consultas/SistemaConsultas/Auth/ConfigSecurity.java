package com.consultas.SistemaConsultas.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class ConfigSecurity extends WebSecurityConfigurerAdapter {
//configuracion para usar springSecurity
	@Autowired
	private UserDetailsService usuarioService;

	@Bean
	public BCryptPasswordEncoder passwordEncode() {// esta funcion devuelva una password encriptada
		return new BCryptPasswordEncoder();
	}

	// en esta clase vamos a generar el bean para manejar la autenticcion del
	// usuario
	@Override
	@Autowired // se usa inyeccion de dependencia para usar la funcion
				// AuthenticationManagerBuilder
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.usuarioService).passwordEncoder(passwordEncode());
	}

	@Bean("authenticationManager") // que el contenedor de spring lo busque con este nombre
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.addAllowedOrigin("*");
	    configuration.addAllowedHeader("*");
	    configuration.addAllowedMethod("*");
	    configuration.setAllowCredentials(true);
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return source;
	}
		/*
		 * http.authorizeRequests().antMatchers(HttpMethod.GET,"/v1/getJuzgados",
		 * "/v1/getJuzgados/{idJuzgados}")
		 * .permitAll().antMatchers(HttpMethod.POST,"/v1/createEscritos").authenticated(
		 * ) /getJuzgados" + "/{" + "idJuzgados" + "}
		 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/Sistema-Consultas/v1/crearUsuario")
		.permitAll().antMatchers(HttpMethod.GET,"/v1/confirmar/{token}")
		.permitAll();
		
		http.cors().and().csrf().disable();
	}
	
	
}