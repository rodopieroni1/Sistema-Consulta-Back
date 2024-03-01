package com.consultas.SistemaConsultas.Auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer  //habilita la clase para que pueda sobreescribir la configuracion base(ResourseServerAdapter)
public class ConfiguracionRecursos extends ResourceServerConfigurerAdapter {
//permite configurar todos los enpoint y metodos a los cuales el usuario podra acceder
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/Sistema-Consultas/v1/crearUsuario")
		.permitAll().antMatchers(HttpMethod.GET,"/v1/confirmar/{token}")
		.permitAll();
		/*http.authorizeRequests().antMatchers(HttpMethod.GET,"/v1/confirmar/token", "/v1/getJuzgados/{idJuzgados}")
	    .permitAll().antMatchers(HttpMethod.POST,"/v1/createEscritos").authenticated();/getJuzgados" + "/{" + "idJuzgados" + "}

        
/*		http.authorizeRequests().antMatchers(HttpMethod.GET, "/v1/getJuzgados/{idJuzgados}")
		.permitAll().antMatchers(HttpMethod.PUT, "/v1/alumnos","/v1/alumnos/{id}")
		.permitAll().antMatchers(HttpMethod.DELETE,"/v1/alumnos/{id}")*/
		}
}
