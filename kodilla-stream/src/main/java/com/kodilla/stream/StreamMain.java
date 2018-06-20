package com.kodilla.stream;
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
}