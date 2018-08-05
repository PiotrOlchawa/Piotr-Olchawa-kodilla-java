package com.kodilla.patterns.builder.bigmac;

/*Celem zadania jest przećwiczenie użycia wzorca Builder. Stworzymy klasę reprezentującą popularną kanapkę BigMac.
 Ma ona zestaw domyślnych składników, można ją również "rozszerzać" o niestandardowe składniki, np. bekon.

Aby zrealizować zadanie:

W katalogu src/main/java utwórz pakiet com.kodilla.patterns.builder.bigmac.

W tym pakiecie utwórz klasę Bigmac, zawierającą następujące pola:
bun (pol. bułka do hamburgera (w odróżnieniu od roll — - zwykłej bułki — może być z sezamem lub bez),
burgers — oznaczającą ilość kotletów wołowych w środku kanapki,
sauce — oznaczającą rodzaj użytego sosu (standard, 1000 wysp, barbecue),
ingredients — oznaczającą listę składników dodatkowych (możliwe wartości to: sałata, cebula, bekon, ogórek, papryczki chilli, pieczarki, krewetki, ser).

Stwórz wewnętrzną klasę BigmacBuilder zgodną ze wzorcem Builder.

W katalogu src/test/java utwórz pakiet com.kodilla.patterns.builder.bigmac.
Stwórz zestaw testów o nazwie BigmacTestSuite oraz test sprawdzający, czy wzorzec Builder działa prawidłowo.
*/

import java.util.*;
import java.util.stream.Stream;

public final class Bigmac {

    private final String bun;
    private final int burgers;
    private final String sauce;
    private final List<String> ingredients;

    public static class BigmacBuilder {
        private static final String[] DEFAULT_INGREDIENTS = {"pomidor"};
        private static final String[] CORRECT_INGREDIENTS = {"sałata", "cebula", "bekon", "ogórek", "papryczki", "chilli", "pieczarki", "krewetki", "ser"};
        private static final String[] CORRECT_SAUCE = {"standard", "1000 wysp", "barbecue"};
        private static final String[] CORRECT_BUN_TYPE = {"bun", "roll"};
        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();


        public BigmacBuilder bun(String bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            if (Arrays.stream(CORRECT_BUN_TYPE).noneMatch(l -> l.equals(bun))) {
                throw new IllegalStateException("There is no correct bun specified!");
            }

            if (burgers < 1 || burgers > 3) {
                throw new IllegalStateException("There is no correct burgers specified!");
            }

            if (!ingredients.stream()
                    .allMatch(t -> Arrays.stream(CORRECT_INGREDIENTS).anyMatch(t::contains))) {
                throw new IllegalStateException("There is no correct ingredients specified!");
            }

            if (Arrays.stream(CORRECT_SAUCE).noneMatch(l -> l.equals(sauce))) {
                throw new IllegalStateException("There is no correct sauce specified!");
            }
            ingredients.addAll(Arrays.asList(DEFAULT_INGREDIENTS));

            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }

    private Bigmac(String bun, int burgers, String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "BigMac{" +
                "bun='" + bun + '\'' +
                ", burgers='" + burgers + '\'' +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

}
