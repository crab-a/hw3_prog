public class ZooObserver {
    private String name;

    public ZooObserver(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void letKnow(String action) {
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
