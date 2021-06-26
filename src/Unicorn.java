public class Unicorn extends Animal{
    /*
    animal which its species is unicorn
     */
    public Unicorn(){
        /*
        initialize the new unicorn by calling the animal (super class) constructor
         */
        super("unicorn","rainbow cakes", "flying");
    }
}
class UnicornFactory extends AnimalFactory {
    /*
    a factory for creating of new unicorns. extends the super class AnimalFactory
     */
    public UnicornFactory(){}
    @Override
    public Animal createAnimal(){
        /*
        creates a new unicorn
         */
        return new Unicorn();
    }
}
