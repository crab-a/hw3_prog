public class Zebra extends Animal{
    /*
    animal which its species is zebra
     */
    public Zebra(){
        /*
        initialize the new zebra by calling the animal (super class) constructor
         */
        super("zebra", "grass", "running");
    }
}
class ZebraFactory extends AnimalFactory {
    /*
    a factory for creating of new zebras. extends the super class AnimalFactory
     */
    public ZebraFactory(){}
    @Override
    public Animal createAnimal(){
        /*
        creates a new zebra
         */
        return new Zebra();
    }
}
