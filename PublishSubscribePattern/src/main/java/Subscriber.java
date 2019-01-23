import java.util.*;

public class Subscriber {
	
	List<String> topics = new ArrayList<>();
	public Queue<Message> myMessages = new LinkedList<>();
	
	public void setTopic(String topic) {
		this.topics.add(topic);
	}
	
	public void print() {
		while(myMessages.size() != 0) {
				Message message = myMessages.remove();
				System.out.println("Topic: " + message.getTopic() + ", Message: " + message.getPayload());
		}
	}
	

}
