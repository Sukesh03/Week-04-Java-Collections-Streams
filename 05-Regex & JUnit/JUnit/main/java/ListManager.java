import java.util.List;

public class ListManager {

    public static void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    public static void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element)); // removes by value, not index
    }

    public static int getSize(List<Integer> list) {
        return list.size();
    }
}
