public abstract class Animal {
    private String food;
    private String activity;
    private String species;
    public Animal(String animal, String food, String activity){
        /*
        the constructor.
         */
        this.species = animal;
        this.food = food;
        this.activity = activity;
    }
    public String getSpecies(){
        return this.species;
    }
    public String getFood(){
        return this.food;
    }
    public String play(){
        return this.activity;
    }
}
