public class MonkeyFactory extends AnimalFactory{
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
