package org.TesteWebSocket;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class Informante extends Thread {
	
	private final Set<WebSocketSession> sessoes = new HashSet<WebSocketSession>();
	private boolean executando = false;
	
	private final DateFormat formatadorData = new SimpleDateFormat ("dd/MM/yyy HH:mm:ss");
	
	public void registrarSessao(WebSocketSession session) {
		sessoes.add(session);
	}
	
	public void removerSessao(WebSocketSession session) {
		sessoes.remove(session);
	}
	
	public void run(){
		
		while (executando) {
			
			try {
				
				String mensagem = formatadorData.format(new Date());
				
				if (!sessoes.isEmpty()) {
					
					for (WebSocketSession session : sessoes) {
						
						if (session.isOpen()) {
							session.sendMessage(new TextMessage(mensagem));
						}
					}
				}
				
				Thread.sleep(3000);
				
			} catch (InterruptedException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@PostConstruct
	public void init(){
		this.executando = true;
		this.start();
	}
	
	@PreDestroy
	public void finish(){
		this.executando = false;
	}

}
