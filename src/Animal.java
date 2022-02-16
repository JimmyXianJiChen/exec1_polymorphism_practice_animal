public class Animal implements Comparable<Animal>{
    String name;
    float weight;

    String getName(){return this.name;}
    float getWeight(){return this.weight;}

    @Override
    public int compareTo(Animal b){
        return (this.weight<b.getWeight()) ? 1 : -1;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
