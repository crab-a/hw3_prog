import java.util.ArrayList;

public class Rss {
    /*
    the broadcast of the zoo. tells the observers the very interesting news about the animals. its a singleton.
     */
    private ArrayList<ZooObserver> zooSubscription = new ArrayList<>();
    private static Rss instance = new Rss();

    private Rss() {
    }

    public static Rss getInstance() {
        /*
        returns the only instance of rss.
         */
        return instance;
    }
    public void addObserver(ZooObserver observer){
        /*
        add a new observer to the subscribed list.
         */
        zooSubscription.add(observer);
    }
    public void removeObserver(ZooObserver observer){
        /*
        removes an observer from the subscribed list.
         */
        zooSubscription.remove(observer);
    }
    public void letKnow(String action) {
        /*
        tell the exciting news about the zoo to all of the observers.
         */
        System.out.println("Notifying observers:");
        for(ZooObserver observer : zooSubscription){
            observer.letKnow(action);
        }
    }
}
