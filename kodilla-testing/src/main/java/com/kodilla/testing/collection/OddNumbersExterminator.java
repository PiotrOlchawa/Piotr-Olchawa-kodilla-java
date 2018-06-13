package com.kodilla.testing.collection;

/*Celem zadania jest przetestowanie klasy, która udostępnia metodę przyjmującą jako argument 
listę ArrayList obiektów typu Integer, która również zwraca listę (nową) ArrayList obiektów typu Integer, 
stanowiących podzbiór danych wejściowych z pominięciem liczb nieparzystych.

Brzmi strasznie? Już omawiamy o co chodzi :)

Aby przygotować rozwiązanie zadania:

W katalogu src/main/java utwórz pakiet com.kodilla.testing.collection

W utworzonym pakiecie stwórz klasę OddNumbersExterminator, posiadającą metodę exterminate(ArrayList<Integer> numbers)
przyjmującą jako argument kolekcję ArrayList liczb typu Integer,
która zwraca również kolekcję ArrayList liczb typu Integer, stanowiącą podzbiór kolekcji wejściowej 
z pominięciem liczb nieparzystych.

W katalogu src/test/java utwórz pakiet com.kodilla.testing.collection.

W utworzonym pakiecie stwórz klasę testową (zbiór testów) CollectionTestSuite, a w niej napisz testy sprawdzające, 
czy metoda filtrująca liczby nieparzyste działa poprawnie:
testOddNumbersExterminatorEmptyList (sprawdzi, czy klasa zachowuje się poprawnie, gdy lista jest pusta)
testOddNumbersExterminatorNormalList (sprawdzi, czy klasa zachowuje się poprawnie, 
gdy lista zawiera liczby parzyste i nieparzyste)
Użyj również adnotacji @Before oraz @After, aby wyświetlić informację o tym, jakie operacje (testy) są aktualnie wykonywane.
*/


import java.util.ArrayList;
import java.util.Iterator;

public class OddNumbersExterminator {


    ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {

        Iterator<Integer> iterator = numbers.iterator();

        while (iterator.hasNext()) {
            if ((iterator.next() % 2) != 0) {
                iterator.remove();
            }
        }
        return numbers;
    }
    
    
 /*
    
    public static void main(String[] args) {
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        System.out.println(oddNumbersExterminator.exterminate(arrayList));
     }*/


}
