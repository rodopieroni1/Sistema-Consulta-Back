package com.consultas.SistemaConsultas.Auth;

import java.util.concurrent.ThreadLocalRandom;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class MailConfiguration {
	
		
	@Value("${spring.mail.host}")
	private String host;

	@Value("${spring.mail.port}")
	private Integer port;

	@Value("${spring.mail.username}")
	private String from;

	@Value("${spring.mail.password}")
	private String password;
	
	JavaMailSender javamailerSender;
	
	

	public MailConfiguration(JavaMailSender javamailerSender) {
		this.javamailerSender = javamailerSender;

	}
		
	public void sendMessage(String to, String token, String nombre) {
		MimeMessage message = javamailerSender.createMimeMessage();
		String urlCompleta = "http://localhost:3000/confirmar/"+token;
		System.out.println("URL: "+ urlCompleta);
		String content = "<!DOCTYPE html>\n"
				+ "<html lang=\"en\">\n"
				+ "  <head>\n"
				+ "    <meta charset=\"utf-8\">\n"
				+ "    <style>\n"
				+ "      .bg{ \n"
				+ "      width:100%; background: white; \n"
				+ "      }\n"
				+ "      .cont{\n"
				+ "      width:600px; margin:0 auto; background: white; \n"
				+ "      }\n"
				+ "      .boxCont{width:70%; margin:0 auto;}\n"
				+ "      .boxCont p{\n"
				+ "      font-size:18px; color: black;\n"
				+ "      }\n"
				+ "      .boxCode{text-align: center; border-radius: 10px; background-color: aquamarine; font-size: 16px; padding: auto;}\n"
				+ "      .boxCode p{width:12%; height: 40px; font-size: 16px; display: inline-block ; border-bottom: 1px beige; \n"
				+ "      border-radius: 5px; text-align: center; font-size: 32px; margin-left: 5px; color: antiquewhite; }\n"
				+ "       .boxCont .footer{ font-size: 12px; color: gray; text-align: center}\n"
				+ "        .cont .fo{\n"
				+ "          width: 100%;\n"
				+ "          height: 10px;\n"
				+ "          margin: 20px 0 0 0;\n"
				+ "          background: linear-gradient(90deg, #4155c4, #1b04a1);\n"
				+ "        }\n"
				+ "    </style>\n"
				+ "  </head>\n"
				+ "  <body>\n"
				+ "    <div class=\"bg\">\n"
				+ "      <div class=\"cont\">\n"
				+ "        <div class=\"boxCont\">\n"
				+ "          <p> <strong>Estimado Usuario "+ nombre +"</strong></p>\n"
				+ "          <p> Su codigo de verificacion para el inicio de sesion es: </p>\n"
				+ "            <div class=\"boxCode\">\n"
				+ "                <p>{0}</p>\n"
				+ "                <p>{1}</p>\n"
				+ "                <p>{2}</p>\n"
				+ "                <p>{3}</p>\n"
				+ "                <p>{4}</p>\n"
				+ "                <p>{5}</p>\n"
				+ "                <p>{6}</p>\n"
				+ "            </div>\n"
				+ "            <p> Este codigo es de un solo uso:</p>\n"
				+ "            <br>\n"
				+ "            <a  href="+urlCompleta+">Ir alla...</a>\n"
				+ "            <p class=\"footer\">Este mensaje de correo electronico se ha enviado desde \n"
				+ "              una direccion exclusivamente para envios. No responda este mensaje\n"
				+ "            </p>\n"
				+ "        </div>\n"
				+ "      </div>\n"
				+ "    </div>\n"
				+ "  </body>\n"
				+ "</html>"
				+ "";		
		String code = generarCode();
		try {
 			message.setSubject("Aviso Mail");
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(to);			
			int index=0;
			for (int i = 0; i < code.length(); i++) {
				content = setCodeInTemplate(content, index, String.valueOf(code.charAt(i) ));
				index++;
			}			
			helper.setText(content, true);// el true es HTML
			helper.setFrom(from);
			javamailerSender.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
	
	////Generar Code	
	public String generarCode() {
		String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String token = "";				
		for (int x=0; x < banco.length(); x++ ) {
			int indiceAleatorio = ThreadLocalRandom.current().nextInt(0, banco.length() - 1);
			 char caracterAleatorio = banco.charAt(indiceAleatorio);
			 token += caracterAleatorio;
		}
		return token;
	}
	
	private String setCodeInTemplate(String templateCode, int index, String number){
		return templateCode.replace("{"+index+"}", number);	
		
	}
}
