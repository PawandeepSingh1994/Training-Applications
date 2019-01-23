import java.util.*;

public class PubSubServer {
	
	Queue<Message> messageStorage = new LinkedList<>();
	List<Subscriber> subscribers = new ArrayList<>();
	
	public void forward() {
		
		while(messageStorage.size() != 0) {
			
			Message message = messageStorage.remove();
			
			for(int i = 0; i < subscribers.size(); i++) {
				
				for(int j = 0; j < subscribers.get(i).topics.size(); j++) {
					
					if(message.getTopic() == subscribers.get(i).topics.get(j)) {
						subscribers.get(i).myMessages.add(message);
					}
					
				}
			}
		}
		
	}

}
