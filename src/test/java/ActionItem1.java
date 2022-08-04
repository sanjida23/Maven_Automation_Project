import java.util.ArrayList;
public class ActionItem1 {
    public static void main(String[] args) {
        //array list of country
        ArrayList<String> country = new ArrayList<>();
        country.add("Algeria");
        country.add("Colombia");
        country.add("Ecuador");
        country.add("Fiji");

        // array list of country code
        ArrayList<Integer> countryCode = new ArrayList<>();
        countryCode.add(213);
        countryCode.add(57);
        countryCode.add(593);
        countryCode.add(679);

        //for loop to iterate through arraylist

        for (int i =0; i <country.size(); i++) {
            System.out.println("My country is " + country.get(i) + "and my country code is " + countryCode.get(i));
        }
        // linear array for region
        String[] region = new String[]{"New York City", "Westchester County", "Albany","Syracuse"};
       //linear array for areaCode
        int[] areaCode = new int[]{212,914,838,680};
        //while loop to iterate through linear array
        int i=0;
        while(i< region.length){
            System.out.println("My region is " + region[i] + "and my area code is " + areaCode[i]);
            i++;
        }

    }
}
