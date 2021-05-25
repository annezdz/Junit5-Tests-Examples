package junit5tests;

import listeners.Listener;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(Listener.class)
public class AssertionsTest {

    @Test
    void assertEqualsTest(){
        assertEquals("firstString","secondString",
                "The string values were not equal");
    }

    @Test
    void assertEqualsListTest(){
        List<String> expectedValues = Arrays.asList("firstString", "secondString", "thirdString");
        List<String> actualValues = Arrays.asList("firstString", "secondString", "thirdString");
        assertEquals(expectedValues,actualValues);
    }

    @Test
    void assertArraysEqualsTest(){
        int[] expectedValues = {1,2,3};
        int[] actualValues = {1,2,3};
        assertArrayEquals(expectedValues,actualValues);
    }

    @Test
    void assertTrueTest(){
        assertFalse(false);
        assertTrue(false,"This boolean condition did not evaluate to true");

    }

    @Test
    void assertThrowsTest(){
        assertThrows(NullPointerException.class, null);
    }

    @Test
    void assertAllTest(){
        assertAll(
                () -> assertEquals("firstString","secondString" +
                        "The string values were not equal"),
                () -> assertThrows(NullPointerException.class, null),
                () -> assertTrue(false,"This boolean condition did not evaluate to true"));
    }

    @Test
    void assertForMapTest(){
        Map<String, Integer> theMap = new HashMap<>();
        theMap.put("firstKey",1);
        theMap.put("secondKey",2);
        theMap.put("third",3);

        assertThat(theMap, Matchers.hasValue(2));
        assertThat(theMap, Matchers.hasKey("secondKey"));
    }

    @Test
    void assertForList(){
        List<String> theList = Arrays.asList("firstString","secondString","thirdString");
        assertThat(theList, Matchers.hasItem("thirdString"));
    }

    @Test
    void assertForAnyOf(){
        List<String> theList = Arrays.asList("firstString","secondString","thirdString");
        assertThat(theList, Matchers.anyOf(Matchers.hasItem("thirdString"),
                Matchers.hasItem("noString")));
    }

    @Test
    void assertForAllOf(){
        List<String> theList = Arrays.asList("firstString","secondString","thirdString");
        assertThat(theList, Matchers.allOf(Matchers.hasItem("thirdString"),
                Matchers.hasItem("noString")));
    }

    @Test
    void assertForContainsAnyOrder(){
        List<String> theList = Arrays.asList("firstString","secondString","thirdString");
        assertThat(theList, Matchers.containsInAnyOrder("firstString","secondString","thirdString"));
    }
}
