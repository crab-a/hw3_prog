public abstract class Animal {
    /*
    an abstract class animal. every kind of animal extends this class.
     */
    private final String food;
    private final String activity;
    private final String species;
    public Animal(String species, String food, String activity){
        /*
        the constructor of animal
        @param: animal: the species of the animal
        @param: food: the food the animal eats
        @param: activity: the activity the animal does
         */
        this.species = species;
        this.food = food;
        this.activity = activity;
    }
    public String getSpecies(){
        /*
        return the species of the animal
         */
        return this.species;
    }
    public String getFood(){
        /*
        return the food the animal eats
         */
        return this.food;
    }
    public String play(){
        /*
        return the activity the animal enjoys to do
         */
        return this.activity;
    }
}
