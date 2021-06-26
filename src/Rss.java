import java.util.ArrayList;

public class Rss {
    private ArrayList<ZooObserver> subscribedList = new ArrayList<>();
    private static Rss instance = new Rss();

    private Rss() {
    }

    public static Rss getInstance() {
        return instance;
    }
    public void addObserver(ZooObserver observer){
        subscribedList.add(observer);
    }
    public void removeObserver(ZooObserver observer){
        subscribedList.remove(observer);
    }
    private void letKnow(String action) {
        System.out.println("Notifying observers:");
        for(ZooObserver observer : subscribedList){
            observer.letKnow(action);
        }
    }
}
