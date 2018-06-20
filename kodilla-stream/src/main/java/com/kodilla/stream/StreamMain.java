/*W metodzie main(String[] args) klasy StreamMain napisz program, który:
zainicjuje strumień Stream przy pomocy metody stream() kolekcji
odfiltruje tylko tych użytkowników, którzy są mężczyznami
odfiltruje tylko tych użytkowników, którzy mają co najmniej 20 lat
odfiltruje tylko tych użytkowników, którzy mają co najmniej jeden opublikowany post
przy pomocy kolektora utworzy mapę par, w której rolę klucza będzie pełnił unikalny identyfikator użytkownika
wyświetli otrzymaną mapę wynikową
Napisany program prześlij do repozytorium GitHub.*/

package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();
        forum.addUser(new ForumUser(1, "Adam", 'M', LocalDate.of(2014, Month.JANUARY, 1), 45));
        forum.addUser(new ForumUser(2, "Rysiek", 'M', LocalDate.of(1965, Month.JANUARY, 1), 23));
        forum.addUser(new ForumUser(3, "Władek", 'M', LocalDate.of(1978, Month.JANUARY, 1), 25));
        forum.addUser(new ForumUser(4, "Czesiek", 'M', LocalDate.of(1997, Month.JANUARY, 1), 55));
        forum.addUser(new ForumUser(5, "Romek", 'M', LocalDate.of(2004, Month.JANUARY, 1), 0));
        forum.addUser(new ForumUser(6, "Marcin", 'M', LocalDate.of(2008, Month.JANUARY, 1), 12));

        Map<Integer, ForumUser> filteredForumUsers = forum.getUserList().stream().filter(l -> l.getSex() == 'M')
                .filter(l -> LocalDate.now().getYear() - l.getBirthDate().getYear() >= 20)
                .filter(l -> l.getPublishedPosts() >= 1)
                .collect(Collectors.toMap(l -> l.getUserId(), l -> l));

        for (Map.Entry<Integer, ForumUser> entryMap : filteredForumUsers.entrySet()) {
            System.out.println("UserId " + entryMap.getKey() + " : " + entryMap.getValue());
        }

    }
}

/*
package com.kodilla.stream;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks);
    }
}
*/



/*package com.kodilla.stream;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        BookDirectory theBookDirectory = new BookDirectory();
        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());

        System.out.println("# elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);
    }
}*/



/*import com.kodilla.stream.person.People;

public class StreamMain {
    public static void main(String[] args) {
        People.getList().stream()
                .filter(s -> s.length() > 11)
                .forEach(System.out::println);
    }
}*/


/*
import com.kodilla.stream.lambda.Executor;
import com.kodilla.stream.lambda.Processor;

public class StreamMain {
    public static void main(String[] args) {
        Processor processor = new Processor();
        Executor codeToExecute = () -> System.out.println("This is an example text.");
        processor.execute(codeToExecute);
    }
}
*/

/*
        import com.kodilla.stream.lambda.ExpressionExecutor;
        import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);


        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

    }
}*/

/*
Wykonanie zadania:

W metodzie main(String[] args) klasy StreamMain, utwórz obiekt klasy PoemBeautifier i wywołaj kilka razy metodę beautify z różnymi tekstami i różnymi upiększaczami tekstu (wyrażenia lambda).
Przykładowymi upiększaczami tekstu mogą być na przykład kody dopisujące znaki “ABC” na początku i na końcu otrzymanego
tekstu lub kody zmieniające cały otrzymany tekst na duże litery (skorzystaj z metody toUpperCase() klasy String).
Wymyśl również dwa własne upiększacze.
Kod zadania prześlij do Github.
*/

/*
import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;

import java.util.ArrayList;
import java.util.List;

public class StreamMain {
    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        List<String> texts = new ArrayList<>();
        texts.add("Some Text One");
        texts.add("Some Text Two");
        texts.add("Some Text Three");

        for (String text : texts) {
            System.out.println(poemBeautifier.beautify(text, l -> l.toUpperCase()));
            System.out.println(poemBeautifier.beautify(text, l -> "##### " + l + " #####"));
            System.out.println(poemBeautifier.beautify(text, l -> {
                String letter1 = l.substring(0, 1);
                String lastLetter = l.substring((l.length() - 1), (l.length())).toUpperCase();
                return letter1 + l + lastLetter;
            }));
        }

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}*/
