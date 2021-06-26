public class UnicornFactory extends AnimalFactory {
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
