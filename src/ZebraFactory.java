public class ZebraFactory extends AnimalFactory {
    public ZebraFactory(){}
    @Override
    public Animal createAnimal(){
        return new Zebra();
    }
}
