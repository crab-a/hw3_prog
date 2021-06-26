public class Monkey extends Animal{
    /*
    animal which its species is monkey
     */
    public Monkey(){
        /*
        initialize the new monkey by calling the animal (super class) constructor
         */
        super("monkey", "a banana", "hanging on trees");
    }
}
class MonkeyFactory extends AnimalFactory{
    /*
    a factory for creating of new monkeys. extends the super class AnimalFactory
     */
    public MonkeyFactory(){}
    @Override
    public Animal createAnimal(){
        /*
        creates a new monkey
         */
        return new Monkey();
    }
}
