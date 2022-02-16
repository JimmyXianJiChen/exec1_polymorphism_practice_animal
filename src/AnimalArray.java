import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnimalArray{
    private List<Animal> animalList = new ArrayList<Animal>();
    public void addAnimal(Animal animal){this.animalList.add(animal);}
    public void addAnimalAt(int index,Animal animal){this.animalList.add(index,animal);}
    public void rmvAnimalAt(int index){this.animalList.remove(index);}
    public int getAnimalNum(){return this.animalList.size();}
    public void printAnimalList(List<Animal> ani){
        for(int i=0; i< ani.size(); i++){
            System.out.printf("%d: ", i);
            System.out.println(animalList.get(i));
            System.out.println("---------------------------------------");
        }
    }
    public void printAllAnimals(){
        printAnimalList(animalList);
    }
    public void delete(int i){
        animalList.remove(i);
    }
    public void sortByWeight(){
        Collections.sort(animalList,compareByWeight);
    }
    public void sortByName(){
        Collections.sort(animalList,compareByName);
    }

    Comparator<Animal> compareByWeight = new Comparator<Animal>() {
        @Override
        public int compare(Animal s1, Animal s2) {
            return (s1.getWeight()<s2.getWeight()) ? -1:1;
        }
    };
    Comparator<Animal> compareByName = new Comparator<Animal>() {
        @Override
        public int compare(Animal s1, Animal s2) {
            return (s1.getName().compareTo(s2.getName())<0) ? -1:1;
        }
    };
}
