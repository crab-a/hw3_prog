public class UnicornFactory extends AnimalFactory {
    public UnicornFactory(){}
    @Override
    public Animal createAnimal(){
        return new Unicorn();
    }
}
