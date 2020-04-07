import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class HashMapExample {

	public static void main(String[] args) {
		//Create a HashMap with String as key and LinkedList as value
		//The key will be the state code (ie. WI, MN, IL, IA...)
		//The list in the value will store city names.
		
		//Make linked list for WI
		LinkedList<String> wisconsinCities = new LinkedList<String>();
		wisconsinCities.add("Menomonie");
		wisconsinCities.add("Eau Claire");
		
		HashMap<String, LinkedList<String> > citiesByState;
		citiesByState = new HashMap<String, LinkedList<String> >();
		//add wisconsinCities as value for key WI
		citiesByState.put("WI",wisconsinCities);
		//add Hudson to WI
		citiesByState.get("WI").add("Hudson");

		//add IL with an empty list to HashMap
		citiesByState.put("IL", new LinkedList<String>());
		
		//add DeKalb list for IL in HashMap
		citiesByState.get("IL").add("Dekalb");
		citiesByState.get("IL").add("Springfield");

		//Add Cali and 3 cities
		citiesByState.put("CA", new LinkedList<String>());
		citiesByState.get("CA").add("Malibu");
		citiesByState.get("CA").add("Oakland");

		//Print out everything
		printCitiesByState(citiesByState);
		
	}
	
	public static void printCitiesByState(HashMap<String, LinkedList<String> > map) {
		//Iterate through keys and print out list of cities for each key
		String s = "State and cities:\n";

		//loop through keys
		for (String key : map.keySet()) {
			s += "State: " + key + ":";

			//Grab list of cities and iterate through list for the key
			Iterator<String> iterator = map.get(key).iterator();
			while (iterator.hasNext()) {
				String city = iterator.next();
				s += " -> " + city;
			}
			s += "\n";
		}
		
		//Print out the final string we ended up with
		System.out.println(s);
		
	}

}
