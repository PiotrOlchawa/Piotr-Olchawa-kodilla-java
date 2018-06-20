package com.kodilla.stream.beautifier;

/*utwórz pakiet com.kodilla.stream.beautifier w katalogu src/main/java.
W tym pakiecie stwórz interfejs PoemDecorator, zawierający metodę decorate odpowiedzialną za ozdobienie tekstu przekazanego jako parametr.
Stwórz klasę PoemBeautifier,
która będzie posiadała metodę beautify, której jako parametry będzie można przekazać tekst do upiększenia oraz wyrażenie lambda upiększające tekst.*/


public class PoemBeautifier {

    public String beautify(String text,PoemDecorator poemDecorator){
        return poemDecorator.decorate(text);
    }
}


