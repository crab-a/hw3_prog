import java.util.ArrayList;

public class Rss {
    /*
    the broadcast of the zoo. tells the observers the very interesting news about the animals. its a singleton.
     */
    private ArrayList<ZooObserver> subscribedList = new ArrayList<>();
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
        subscribedList.add(observer);
    }
    public void removeObserver(ZooObserver observer){
        /*
        removes an observer from the subscribed list.
         */
        subscribedList.remove(observer);
    }
    public void letKnow(String action) {
        /*
        tell the exciting news about the zoo to all of the observers.
         */
        System.out.println("Notifying observers:");
        for(ZooObserver observer : subscribedList){
            observer.letKnow(action);
        }
    }
}
