import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementFrequencyCounter {

    public static Map<String, Integer> countFrequencies(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String item : list) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }

        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("apple");
        fruits.add("orange");

        System.out.println("Input List: " + fruits);

        Map<String, Integer> frequencies = countFrequencies(fruits);

        System.out.println("Frequencies: " + frequencies);
    }
}
