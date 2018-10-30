import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Programming {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstInput = reader.readLine();
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();
        while (!firstInput.equals("Tournament")) {
            String tokens[] = firstInput.split(" ");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            Trainer trainer = new Trainer(trainerName);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if (!trainers.containsKey(trainerName)) {
                trainers.put(trainerName, trainer);
            }
            trainers.get(trainerName).addPokemon(pokemon);

            firstInput = reader.readLine();
        }
        String element = reader.readLine();
        while (!element.equals("End")) {
            for (Trainer trainer : trainers.values()) {
                if(trainer.hasElement(element)){
                    trainer.addBadge();
                }
                else{
                    trainer.reducePokemonsHealth();
                }
            }

            element = reader.readLine();
        }
        trainers.entrySet().stream().sorted((t2, t1) -> Integer.compare(t1.getValue().getBadgesCount(), t2.getValue().getBadgesCount()))
                .forEach(t -> System.out.println(t.getValue()));


    }
}

class Trainer {
    private String name;
    private int badgesCount;
    List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        badgesCount = 0;
        pokemons = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public boolean hasElement(String element) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void addBadge() {
        badgesCount++;
    }

    public void reducePokemonsHealth() {
        for (int i = 0; i < pokemons.size(); i++) {
            pokemons.get(i).reduceHealth(10);
            if (pokemons.get(i).getHealth() <= 0) {
                pokemons.remove(i);
                i--;
            }
        }
    }

    public int getBadgesCount() {
        return badgesCount;
    }

    public String toString() {
        return String.format("%s %d %d", name, badgesCount, pokemons.size());
    }


}

class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return this.element;
    }

    public int getHealth() {
        return this.health;
    }

    public void reduceHealth(int health) {
        this.health -= health;
    }
}
//bad practice just for testing purpose












