package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize + 1);
    }


    @Test
    void testHasCity() {
        list = MockCityList();
        City mockCity = new City("Estevan", "SK");
        list.addCity(mockCity);
        assertTrue(list.hasCity(mockCity));
        City city = new City("Vancouver", "British Columbia");
        assertFalse(list.hasCity(city));
    }

    @Test
    void testDelete() {
        list = MockCityList();
        City city = new City("Vancouver", "British Columbia");

        assertThrows(IllegalArgumentException.class, () ->
                list.delete(city));

        list.addCity(city);
        assertTrue(list.hasCity(city));
        list.delete(city);
        assertFalse(list.hasCity(city));
    }

    @Test
    void testCountAgain() {
        list = MockCityList();
        int listSize = list.getCountAgain();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCountAgain(), listSize + 1);
    }
}
