package pojo;

import java.util.ArrayDeque;
import java.util.Queue;

public class AnimalShelf {
    Queue<Integer> dog;
    Queue<Integer> cat;
    public AnimalShelf() {
        dog = new ArrayDeque<>();
        cat = new ArrayDeque<>();
    }

    public void enqueue(int[] animal) {
        if(animal[1] == 0){
            cat.add(animal[0]);
        }
        else{
            dog.add(animal[0]);
        }
    }

    public int[] dequeueAny() {
        if(cat.size() == 0){
            return dog.size() == 0 ? new int [] {-1,-1} : new int [] {dog.poll(), 1};
        }
        else if(dog.size() == 0){
            return new int []{cat.poll(), 0};
        }
        return cat.peek() > dog.peek() ? new int [] {dog.poll(),1} : new int [] {cat.poll(), 0};
    }

    public int[] dequeueDog() {
        if(dog.size() > 0){
            return new int [] {dog.poll(),1};
        }
        return new int []{-1, -1};
    }

    public int[] dequeueCat() {
        if(cat.size() > 0){
            return new int [] {cat.poll(),0};
        }
        return new int []{-1, -1};
    }
}
