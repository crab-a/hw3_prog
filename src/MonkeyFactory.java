public class MonkeyFactory extends AnimalFactory{
    public MonkeyFactory(){}
    @Override
    public Animal createAnimal(){
        return new Monkey();
    }
}
