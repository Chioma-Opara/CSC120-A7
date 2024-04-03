import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new House("Morris House", "101 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new House("Lamont House", "4 Prospect Street Northampton, MA 01063", 4, true, true));
        myMap.addBuilding(new House("Chase House", "3 Elm Street Northampton, MA 01063", 3, true, true));
        myMap.addBuilding(new House("Baldwin House", "7 Elm Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Burton Hall", "6 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Seelye Hall", "4 Chapin Way Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Wright Hall", "1 Chapin Way Northampton, MA 01063", 2));
        myMap.addBuilding(new Building("Campus Centre", "5 Elm Street Northampton, MA 01063", 2));
        myMap.addBuilding(new House("Capen House", "8 Prospect Street Northampton, MA 01063", 3, false, true));
        myMap.addBuilding(new Building("Clark Hall", "15 Elm Street Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("College Hall", "10 Elm Street Northampton, MA 01063", 2));
        myMap.addBuilding(new Cafe("Compass Cafe", "Neilson Library Northampton, MA 01063"));
        myMap.addBuilding(new Library("Neilson Library", "1 Neilson Drive Northampton, MA 01063", 3, true));
        System.out.println(myMap);
    }
    
}
