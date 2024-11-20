//TODO Ajouter tous les attributs et méthodes associés
public class Pokemon {

    /* attributs*/
    private int id;
    private String name;
    private float weight;

    // TODO pour faire un tableau en attribut : private Pokemon[] next_evolution;

    /* constructeur */
    public Pokemon(int id, String name, float weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    /* Getters/setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Nom : " + name + ", Poids : " + weight + " kg";
    }

    public void showEvolution(Pokemon myPokemon) {

    }
}
