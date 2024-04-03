public class Cafe extends Building {
private int nCoffeeOunces;  // The number of ounces of coffee remaining in inventory
private int nSugarPackets;  // The number of sugar packets remaining in inventory
private int nCups;  // The number of cups remaining in inventory
private int nCreams;  // The number of "splashes" of cream remaining in inventory


    /** Default class constructor */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors); 
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    /** Overloaded constructor. Cafe is initialised has a deafualt number of floors and supplies */
    public Cafe(String name, String address){
        super(name, address, 2); 
        this.nCoffeeOunces = 1200;
        this.nSugarPackets = 500;
        this.nCreams = 300;
        this.nCups = 100;
    }

    /**
     * Check if cafe has enough supplies to sell order
     * @param size number of coffee ounces user desires
     * @param nSugarPackets number of sugar packets user desires
     * @param nCreams number of creams user desires 
     * @return whether or not store has enough cupplies to fulfill order
     */
    private boolean canSell(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces > size && this.nSugarPackets > nSugarPackets && this.nCreams > nCreams && this.nCups > 0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Restock cafe supplies by adding extra amounts of coffee ounces, sugar packets, creamers and cups
     * @param size number of coffee ounces user desires
     * @param nSugarPackets number of sugar packets user desires
     * @param nCreams number of creams user desires 
     * @param nCups number of cups of coffee user desires 
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * Reduces amount of cafe supplies when a cup of coffee is sold
     * @param size number of coffee ounces user desires
     * @param nSugarPackets number of sugar packets user desires
     * @param nCreams number of creams user desires 
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.canSell(size, nSugarPackets, nCreams)){
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
        }
        else{
            this.restock(size*5, nSugarPackets*5, nCreams*5, 5);
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
        }
    }

    /**
     * Reduces amount of cafe supplies when a cup of coffee is sold by default values
     */
    public void sellCoffee(){
        sellCoffee(16, 5, 3);
    }

    /**
     * Overrides goToFloor() from parent class to allow user access to only the ground floor
     * @param floorNum the floor number the user wishes to go to
     */
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    if (floorNum > 1 && floorNum <= this.nFloors){
        System.out.println("You are only allowed on the first floor of " + this.name);
    }
    this.activeFloor = floorNum;
    }


    /**
     * Overrides the showOptions() method from parent class to reflect cafe's ability to sell coffee
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor()\n + sellCoffee()");
    }
}

/**
 * NOTES TO ME -> personal notes to help future me walk through my code
 * Since all the attributes are private, can I simply change them within the methods as I have done here? No. A class doesn't need an accessor to its own attributes

 * CODE TESTER:
 *  public static void main(String[] args) {
        Cafe compassCafe = new Cafe("Compass Cafe", "Neilson Library", 1, 50, 100, 100, 100);
        compassCafe.sellCoffee(200, 250, 70);
        System.out.println("ncoffeeounce: " + compassCafe.nCoffeeOunces + " Num of sugar: " + compassCafe.nSugarPackets + " nCreams: " + compassCafe.nCreams + " num of cups: " + compassCafe.nCups);
    }
 */