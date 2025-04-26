import java.util.*;

public class InvertMap {

    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> original) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : original.entrySet()) {
            invertedMap
                    .computeIfAbsent(entry.getValue(), k -> new ArrayList<>())
                    .add(entry.getKey());
        }

        return invertedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);

        Map<Integer, List<String>> invertedMap = invertMap(originalMap);

        System.out.println(invertedMap);
    }
}
