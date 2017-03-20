package conf;

import org.TesteWebSocket.Informante;
import org.TesteWebSocket.Websocket;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import javax.inject.Inject;

import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	@Inject
	private Informante informante;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registro) {
		
		System.out.println("adicionando Handler");
		registro.addHandler(new Websocket(informante), "/websocket");
		
	}
	

}
