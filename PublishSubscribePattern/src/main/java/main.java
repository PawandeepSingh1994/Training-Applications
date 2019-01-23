
public class main {

	public static void main(String[] args) {
		
		run();

	}
	
	public static void run() {
		
		PubSubServer server = new PubSubServer();
		
		Publisher AnimalNewsPublisher = new Publisher();
		Publisher SportsPublisher = new Publisher();
		Publisher BusinessPublisher = new Publisher();
		
		Subscriber SportsAddict = new Subscriber();
		Subscriber BusinessGuy = new Subscriber();
		Subscriber AllNews = new Subscriber();
		
		Message a1 = new Message("Dogs", "Dog attacked elderly man");
		Message a2 = new Message("Lion", "Lion breaks out of Zoo. No one attacked.");
		Message s1 = new Message("Cricket", "England Beat Aus");
		Message s2 = new Message("Soccer", "Russia beats Mexico 3-2");
		Message b1 = new Message("Stocks", "Apple stock crashed from 118 to 45");
		Message b2 = new Message("Trade", "China ends trade war with Russia");
		
		server.subscribers.add(SportsAddict);
		server.subscribers.add(BusinessGuy);
		server.subscribers.add(AllNews);
		
		SportsAddict.setTopic("Cricket");
		SportsAddict.setTopic("Soccer");
		
		BusinessGuy.setTopic("Stocks");
		BusinessGuy.setTopic("Trade");
		
		AllNews.setTopic("Dogs");
		AllNews.setTopic("Lion");
		AllNews.setTopic("Cricket");
		AllNews.setTopic("Soccer");
		AllNews.setTopic("Stocks");
		AllNews.setTopic("Trade");
		
		AnimalNewsPublisher.send(a1, server);
		AnimalNewsPublisher.send(a2, server);
		SportsPublisher.send(s1, server);
		SportsPublisher.send(s2, server);
		BusinessPublisher.send(b1, server);
		BusinessPublisher.send(b2, server);
		
		server.forward();
		
		System.out.println("SportsAddict is subscribed to this news: ");
		SportsAddict.print();
		System.out.println();
		System.out.println("BusinessGuy is subscribed to this news: ");
		BusinessGuy.print();
		System.out.println();
		System.out.println("AllNews is subscribed to this news: ");
		AllNews.print();
		
	}

}
