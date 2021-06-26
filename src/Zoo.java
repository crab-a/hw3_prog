import java.util.ArrayList;

public class Zoo {
    private static Zoo zoo =null;
    public static ArrayList<Animal> animalsList= new ArrayList<>();
    public static ArrayList<Animal> uniqueAnimals= new ArrayList<>();
    public static ArrayList<ZooObserver> subscribedList= new ArrayList<>();
    private static int hunger=3;
    private static int happiness=2;
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
        //for //count ecah animal
        System.out.println("Happiness level: "+happiness);
        if (happiness<3)
            System.out.println("The animals are not happy, you should watch them...");
        else
            System.out.println("The animals are very happy, keep working hard…");
        System.out.println("Hunger level: "+hunger);
        if(hunger>3)
            System.out.println("The animals are hungry, you should feed them…");
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
            uniqueAnimals.add(animal);
        animalsList.add(animal);

        letKnow(animal.getAnimal());
    }

    private void letKnow(String action) {
        System.out.println("Notifying observers:");
        for(ZooObserver observer : subscribedList){
            observer.letKnow(action);
        }
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
        subscribedList.remove(observer);
    }
}
