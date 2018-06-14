package com.kodilla.testing.collection;

/*W utworzonym pakiecie stwórz klasę testową (zbiór testów) CollectionTestSuite, a w niej napisz testy sprawdzające,
czy metoda filtrująca liczby nieparzyste działa poprawnie:
testOddNumbersExterminatorEmptyList (sprawdzi, czy klasa zachowuje się poprawnie, gdy lista jest pusta)
testOddNumbersExterminatorNormalList (sprawdzi, czy klasa zachowuje się poprawnie,
gdy lista zawiera liczby parzyste i nieparzyste)
Użyj również adnotacji @Before oraz @After, aby wyświetlić informację o tym, jakie operacje (testy) są aktualnie wykonywane.
*/

import org.junit.*;

import java.util.ArrayList;

public class CollectionTestSuite {


    @Before
    public void before() {
        System.out.println("Test Case: begin");
    }

    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {

        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> testArrayList = new ArrayList<>();
        testArrayList.add(1);
        testArrayList.add(2);
        testArrayList.add(3);
        testArrayList.add(4);
        testArrayList.add(5);
        ArrayList<Integer> resultArrayList = new ArrayList<>();
        resultArrayList.add(2);
        resultArrayList.add(4);

        //When
        testArrayList = oddNumbersExterminator.exterminate(testArrayList);

        //Then
        Assert.assertTrue(testArrayList.containsAll(resultArrayList));
    }


    @Test
    public void testOddNumbersExterminatorEmptyList() {

        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> testArrayList = new ArrayList<>();

        //When
        testArrayList = oddNumbersExterminator.exterminate(testArrayList);

        //Then
        Assert.assertEquals(0, testArrayList.size());
    }
}