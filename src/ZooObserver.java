public class ZooObserver {
    /*
    an observer who gets interesting news about the zoo
     */
    private String name;

    public ZooObserver(String name) {
        /*
        the constructor. initialize a new observer and give him his name
        @param: name: the name of the observer
         */
        this.name = name;
    }

    public String getName() {
        /*
        return the name of the observer
         */
        return this.name;
    }

    public void letKnow(String action) {
        /*
        receive the news about the zoo and print it.
         */
        switch (action) {
            case ("fed"):
                System.out.println("[" + this.name + "] " + "The animals are being fed");
                break;
            case ("watch"):
                System.out.println("[" + this.name + "] " + "The animals are being watched");
                break;
            default:
                System.out.println("[" + this.name + "] " + action + " has been added to the zoo!");
        }
    }
}
