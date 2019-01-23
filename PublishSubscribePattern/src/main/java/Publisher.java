
public class Publisher {
	
	public void send(Message message, PubSubServer server) {
		server.messageStorage.add(message);
	}

}
