import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListManagerTest {

    private List<Integer> list;

    @BeforeEach
    public void setUp() {
        list = new ArrayList<>();
    }

    @Test
    public void testAddElement() {
        ListManager.addElement(list, 5);
        assertTrue(list.contains(5));
        assertEquals(1, list.size());
    }

    @Test
    public void testRemoveElement() {
        list.add(10);
        list.add(20);
        ListManager.removeElement(list, 10);
        assertFalse(list.contains(10));
        assertEquals(1, list.size());
    }

    @Test
    public void testGetSize() {
        assertEquals(0, ListManager.getSize(list));
        list.add(1);
        list.add(2);
        assertEquals(2, ListManager.getSize(list));
    }
}
