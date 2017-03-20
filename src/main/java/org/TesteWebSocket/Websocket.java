package org.TesteWebSocket;

//import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class Websocket extends TextWebSocketHandler {
	
	//@Inject
	private Informante informante;
	
	public Websocket(Informante info) {
		this.informante = info;
	}
	
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage textMessage) {
		System.out.println("Recebi a mensagem " + textMessage.getPayload());
	}
	
	public void afterConnectionEstablished(WebSocketSession session) {
		System.out.println("Recebi uma conexão");
		informante.registrarSessao(session);
	}

	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
		System.out.println("Uma conexão terminou");
		informante.removerSessao(session);
	}

}
