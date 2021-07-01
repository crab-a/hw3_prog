import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

public class Zoo implements Observable {
    /*
    one of a kind zoo, may contains infinite animals, a singleton
     */
    private static Zoo zoo =null;
    private static ArrayList<Animal> animalsList;
    LinkedHashMap<String, Integer> uniqueSpecies;
    private static int hunger;
    private static int happiness;
    private final Rss zooRss;
    public static Zoo getInstance() {
        /*
        returns the only instance of the zoo.
         */
        if(zoo ==null)
            zoo = new Zoo();
        else
            System.out.println("The zoo already exists...");
        return zoo;
    }
    private Zoo(){
        System.out.println("Creating zoo...");
        animalsList= new ArrayList<>();
        uniqueSpecies = new LinkedHashMap<>();
        zooRss = Rss.getInstance();
        hunger=3;
        happiness=2;
    }
    public void addAnimal(Animal animal) {
        /*
        new animal in the zoo, how exciting!
        update all subscribers
        @param: animal: the new animal in the zoo
         */
        uniqueSpecies.put(animal.getSpecies(),(uniqueSpecies.getOrDefault((animal.getSpecies()),0)+1));
        animalsList.add(animal);
        update(capitalize(animal.getSpecies()));
    }

    public void showAnimalsInfo() {
        /*
        print all current information about the animals in the zoo:
        total count
        each spices count
        happiness level and hunger level
         */
        System.out.println("The zoo contains total of "+animalsList.size()+" animals:");
        printAnimalCount();
        System.out.println("Happiness level: "+happiness);
        if (happiness<3)
            System.out.println("The animals are not happy, you should watch them...");
        else
            System.out.println("The animals are very happy, keep working hard...");
        System.out.println("Hunger level: "+hunger);
        if(hunger>3)
            System.out.println("The animals are hungry, you should feed them...");
    }
    private void printAnimalCount() {
        Set<String> animals = uniqueSpecies.keySet();
        for (String animal : animals){
            System.out.println(("- "+capitalize(animal)+": "+ uniqueSpecies.get(animal)));
        }
    }

    public void feedAnimals() {
        /*
        feed the animals
        update all subscribers
         */
        for (Animal animal: animalsList){
            System.out.println("The "+animal.getSpecies()+" is eating "+animal.getFood()+"...");
        }
        decreaseHunger();
        update("fed");
    }
    public void watchAnimals() {
        /*
        the animals put up a show, how sweet.
        update all subscribers
         */
        for (Animal animal: animalsList){
            System.out.println("The "+animal.getSpecies()+" is "+animal.play()+"...");
        }
        increaseHunger();
        increaseHappiness();
        update("watch");
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
    @Override
    public void update(String action) {
        zooRss.letKnow(action);
    }
    @Override
    public void addObserver(Observer observer) {
        /*
        add the observer as subscriber to the zoo RSS
        @param: observer: the new subscriber to the RSS list
         */
        zooRss.addObserver(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        /*
        remove the observer from the RSS broadcast list
        we are sorry to see you leave
        @param: observer: the person who want to unsubscribe from the RSS list
         */
        zooRss.removeObserver(observer);
    }

    private String capitalize(String word) {
        return word.substring(0, 1).toUpperCase() +word.substring(1);
    }
}
