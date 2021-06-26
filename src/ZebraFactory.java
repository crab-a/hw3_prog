public class ZebraFactory extends AnimalFactory {
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
