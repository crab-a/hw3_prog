import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

public class Zoo {
    private static Zoo zoo =null;
    public static ArrayList<Animal> animalsList= new ArrayList<>();
    LinkedHashMap<String, Integer> uniqueAnimals = new LinkedHashMap<>();
    private static int hunger=3;
    private static int happiness=2;
    private Rss zooRss = Rss.getInstance();
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
        zooRss.addObserver(observer);
    }

    public void showAnimalsInfo() {
        System.out.println("The zoo contains total of "+animalsList.size()+" animals:");
        countAnimals();
        System.out.println("Happiness level: "+happiness);
        if (happiness<3)
            System.out.println("The animals are not happy, you should watch them...");
        else
            System.out.println("The animals are very happy, keep working hard…");
        System.out.println("Hunger level: "+hunger);
        if(hunger>3)
            System.out.println("The animals are hungry, you should feed them…");
    }

    private void countAnimals() {
        Set<String> animals = uniqueAnimals.keySet();
        for (String animal : animals){
            System.out.println(("- "+animal+": "+ uniqueAnimals.get(animal)));
        }
    }

    public void feedAnimals() {
        for (Animal animal: animalsList){
            System.out.println("The "+animal.getAnimal()+" is eating"+animal.getFood()+"...");
            decreaseHunger();
        }
        letKnow("fed");
    }

    public void watchAnimals() {
        for (Animal animal: animalsList){
            System.out.println("The "+animal.getAnimal()+" is "+animal.play()+"...");
            increaseHappiness();
            increaseHunger();
        }
        letKnow("watch");
    }

    public void addAnimal(Animal animal) {
        if (!animalsList.contains(animal))
            uniqueAnimals.put(animal.getAnimal(),0);
        animalsList.add(animal);
        uniqueAnimals.put(animal.getAnimal(),uniqueAnimals.get(animal.getAnimal()) + 1);

        letKnow(animal.getAnimal());
    }

    private void letKnow(String action) {
        zooRss.letKnow(action);
    }
    private void decreaseHunger(){
        if(hunger>1)
            hunger--;
    }
    private void increaseHunger(){
        if(hunger<5)
            hunger++;
    }
    private void increaseHappiness(){
        if(happiness<5)
            happiness++;
    }
    public void removeObserver(ZooObserver observer) {
        zooRss.removeObserver(observer);
    }
}
