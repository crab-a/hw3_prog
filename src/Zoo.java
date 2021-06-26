import java.util.ArrayList;

public class Zoo {
    private static Zoo zoo =null;
    public static ArrayList<Animal> animalsList= new ArrayList<>();
    public static ArrayList<ZooObserver> subscribedList= new ArrayList<>();
    public static Zoo getInstance() {
        if(zoo ==null)
            zoo = new Zoo();
        else
            System.out.println("The zoo already exists...");
        return zoo;
    }
    private Zoo(){
        System.out.println("Creating zoo...");
    }

    public void addObserver(ZooObserver observer) {
        subscribedList.add(observer);
    }

    public void showAnimalsInfo() {
        System.out.println("The zoo contains total of "+animalsList.size()+" animals:");
        for

    }

    public void feedAnimals() {
        for (Animal animal: animalsList){
            System.out.println("The "+animal.getName+" is eating "+animal.getfood+"...");
            animal.fed();
        }
        letKnow("feed");

    }

    public void watchAnimals() {
        for (Animal animal: animalsList){
            System.out.println("The "+animal.getName+" is eating "+animal.getfood+"...");
            animal.fun();
        }
        letKnow("watch");
    }

    public void addAnimal(Animal animal) {
        animalsList.add(animal);
        letKnow("new");
    }

    private void letKnow(String action) {
        for(ZooObserver observer : subscribedList){
            observer.letKnow(action);
        }
    }

    public void removeObserver(ZooObserver observer) {
        subscribedList.remove(observer);
    }
}
