import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
            // Pn parse du fichier JSON puis indique que le contenu du fichier est un objet JSON global.
            Object fileToObj = new JSONParser().parse(new FileReader("pokedex.json"));
            JSONObject pokedexObject = (JSONObject) fileToObj; 

            // On indique que l’attribut "pokemon" contient une liste de Pokémon (donc un tableau JSON).
            JSONArray pokedexArray = (JSONArray) pokedexObject.get("pokemon"); 

            //Creation d'une liste pour stocker les objets pokemon
            List<Pokemon> pokemonList = new ArrayList<>();

            //Conversion des éléments du tableaux de pokemon en objets en issus de la classe Pokemon
            for (Object pokemon : pokedexArray ) {
                JSONObject pokedex = (JSONObject) pokemon;
                String name = (String) pokedex.get("name");
                String weightRaw = (String) pokedex.get("weight");
                float weight = Float.parseFloat(weightRaw.replace(" kg", ""));
                pokemonList.add(new Pokemon(0, name, weight)); // ID non utilisé pour l'instant
            }

            // On filtre les Pokémon de 10 kg ou plus
            List<Pokemon> heavyPokemonList = pokemonList.stream()
                    .filter(p -> p.getWeight() >= 10.0)
                    .collect(Collectors.toList());

            //On trie ensuite les pokemon filtrés par poids
            heavyPokemonList.sort(Comparator.comparing(Pokemon::getWeight));

            //Affichage des pokemon triés
            System.out.println("Pokémon triés par poids croissant :");
            for (Pokemon pokemon : heavyPokemonList) {
                System.out.println(pokemon);
            }

    }
}