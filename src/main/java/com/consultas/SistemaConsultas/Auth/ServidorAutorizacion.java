package com.consultas.SistemaConsultas.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class ServidorAutorizacion extends AuthorizationServerConfigurerAdapter{
// este servidor de autorizacion nos permitira la gestiosn del token y todo el acceso a las URI y servicios a traves el token

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	@Qualifier("authenticationManager")   //indicamos a que bean hacemos referencia
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()")
		.checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		//metodo para que los clientes accedan a nuestras api, a traves de seguridad
		clients.inMemory().withClient("clientrest")//es un cliente PostMap
		.secret(passwordEncoder.encode("1234"))//se codifica la password a un 1234
		.scopes("read","write")//se dan permisos de lectura y escritura
		.authorizedGrantTypes("password", "refresh_token")
		.accessTokenValiditySeconds(40000)
		.refreshTokenValiditySeconds(40000);
		// ya tenemos configurado nuestro cliente que va a usar nuestras apis y va a pasar por el servidor de autorizacion indicandole el tipo de liente
		//con la clave y permisos, erl tipo de autorizxacion e indicando que debe devolver un refresh token
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager)
		.tokenStore(tokenStore())
		.accessTokenConverter(accessTokenConverter());
	}

	
//aqui se esta generando el token y luego se esta almacenando
	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}
	
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		return jwtAccessTokenConverter;
	}
	
	/*private JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter jwtAccessTokenConverter1 = new JwtAccessTokenConverter();
		String jwtAccessTokenConverterStr =  jwtAccessTokenConverter1.toString();
		System.out.println("uno: "+jwtAccessTokenConverterStr);

		jwtAccessTokenConverterStr.replace("Bearer","").trim();
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		
		jwtAccessTokenConverter.setVerifierKey(jwtAccessTokenConverterStr);
		System.out.println("dos: "+jwtAccessTokenConverter);
		return jwtAccessTokenConverter;
	}*/
}
