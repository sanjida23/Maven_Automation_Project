package DAY3_043022;

import java.util.ArrayList;

public class ActionItem2 {
public static void main(String[] args) {
    //array list of cities
    ArrayList<String> cities = new ArrayList<>();
    cities.add("Brooklyn");
    cities.add("Queens");
    cities.add("Manhatten");
    cities.add("Staten");


    //for loop to print only when city is brooklyn or manhatten

    for (int i = 0; i < cities.size(); i++) {
        if (cities.get(i) == "Brooklyn" || cities.get(i) == "Manhatten") {
            System.out.println("The city at location " + i + " is " + cities.get(i));
        }


    }
}
    }
