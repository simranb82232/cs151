package part2;

public abstract class Pizza {
    
    public abstract void pickToppings();
    
    public void makeCrust() {
        System.out.println("Make crust");
    }
    
    public void addToppings() {
        System.out.println("Add toppings");
    }
    
    public void preHeatOven() {
        System.out.println("Preheat oven");
    }
    
    public void cook() {
        System.out.println("Cook pizza");
    }

    public final void makeFromScratch() {
    	pickToppings();
    	makeCrust();
        addToppings();
        preHeatOven();
        cook();
    }
}