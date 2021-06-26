public abstract class Animal {
    private String food;
    private String activity;
    private String animal;
    public Animal(String animal, String food, String activity){
        this.animal = animal;
        this.food = food;
        this.activity = activity;
    }
    public String getAnimal(){
        return this.animal;
    }
    public String getFood(){
        return this.food;
    }
    public String play(){
        return this.activity;
    }
}
