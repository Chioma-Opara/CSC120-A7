import java.util.ArrayList;

public class House extends Building {
  private ArrayList<String> residents; 
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /** Default constructor */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator){
    super(name, address, nFloors);  // the super contructor must take in all the required parameters as defined in the parent class
    this.residents = new ArrayList<> ();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator; 
  }

  /**Overloaded Class constructor. Implements a default house with no dining room and no elevator */
  public House(String name, String address, int nFloors){
    super(name, address, nFloors);  // the super contructor must take in all the required parameters as defined in the parent class
    this.residents = new ArrayList<> ();
    this.hasDiningRoom = false;
    this.hasElevator = false; 
  }

  /**
   * Getter for hasDining
   * @return a boolean representing whether or not the house has a dining
   */
  public boolean getHasDining(){
    return this.hasDiningRoom;
  }

  /**
   * Getter for hasElevator
   * @return whether or not the house has an elevator
   */
  public boolean getHasElevator(){
    return this.hasElevator;
  }

  /**
   * Returns the number of residents in the house
   * @return number of residents in the house
   */
  public int nResidents(){
    int n = residents.size();
    return n;
  }

  /**
   * Modifies the toString of the house to reflect whether or not the house has an elevator and/or a dining
   * @return a brief description of the house 
   */
  public String toString(){
    String desc = super.toString();
    if (this.hasDiningRoom){
      desc += " It has a dining room.";
    }

    if (this.hasElevator){
      desc += " It has an elevator.";
    }
    return desc;
  }

  /**
   * Determines whether or not a person is a resident of the house
   * @param person name of person whose residency status is to be checked
   * @return whether or not person is a house resident
   */
  public boolean isResident(String person){
    if (this.residents.contains(person)){
      return true;
    }
    else{
      return false; 
    }
  }

  /**
   * Adds a new person to the list of residentsif person isn't already a resident
   * @param name name of person moving into the house
   */
  public void moveIn(String name){
    // not a resident? Sure move in!
    if (!isResident(name)){
      this.residents.add(name);
      System.out.println(name + " has successfully moved into " + this.getName());
    }
    // already a resident? Can't move in twice ):
    else{
      throw new RuntimeException(name + " is already a resident in " + this.getName());
    }
  }

  /**
   * Allows multiple people move in simultaneously
   * @param newResidents list of people moving in
   */
  public void moveIn(ArrayList<String> newResidents){
    for (String name : newResidents){
      // not a resident? Sure move in!
      if (!isResident(name)){
        this.residents.add(name);
        System.out.println(name + " has successfully moved into " + this.getName());
      }
      // already a resident? Can't move in twice ):
      else{
        throw new RuntimeException(name + " is already a resident in " + this.getName());
      }
    }
  }

  /**
   * Removes a person from the list of residents if person was already a resident
   * @param name name of person moving out of the house
   * @return name of resident that has moved out
   */
  public String moveOut(String name){
    // a resident? Sad to see you leave  ):
    if (isResident(name)){
      this.residents.remove(name);
      System.out.println(name + " has successfully moved out of " + this.getName() + ". We're sad to see you leave ):");
      return name;
    }
    // not a resident? Can't move out 
    else{
      throw new RuntimeException(name + " can't move out as " + name + " is not a resident in " + this.getName());
    }
  }


  /**
   * Overrides goToFloor() from parent class to simulate movement between floors using an elevator
   * @param floorNum the floor number the user wishes to go to
   */
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    if (!this.hasElevator){
      throw new RuntimeException(this.name + "has no elevator. You must use the stairs");
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
}


  /**
   * Overrides the showOptions() method from parent class to reflect options specific to the House class
   */
  public void showOptions() {
    if (this.hasElevator){
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + moveIn(name)\n + moveOut(name)");
    }  
    else{
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + moveIn(name)\n + moveOut(name)");
    }
  }
}


/**
 * NOTES TO ME -> Personal notes to help future me work through my code
 * You may want to add elevator to Building and only override goToFloor in cafe next time
 * Idea of hw: what should be handled by the parent class, and what should be handled by the individual classes
 * for security reasons, we will never print out the entire list of house residents
 * why should hasDiningRoom or nResidents be private? You don't want others to be able to change it
 * CODE TESTER:
 * 
  public static void main(String[] args) {
    House morrisHouse = new House("Morris House", "101 Green Street", 4);
    System.out.println(morrisHouse);
    System.out.println(morrisHouse.getHasDining());
    System.out.println(morrisHouse.getHasElevator());
    morrisHouse.moveIn("Chioma");
    morrisHouse.moveOut("Chioma");
    morrisHouse.moveIn("Sabina");
    morrisHouse.moveIn("Olohi");
    ArrayList <String> newResidents = new ArrayList<>();
    String [] names = {"Chi", "JO", "IS", "Vis","Cal"};
    for(String name : names){newResidents.add(name);}
    morrisHouse.moveIn(newResidents);
    System.out.println(morrisHouse.nResidents());
  }
 */