package CITC.chap03;

class Animal {
    String type;
    int number;

    public Animal(String type, int number) {
        this.type = type;
        this.number = number;
    }

    public String toString() {
        return type + number;
    }
}

public class AnimalShelter {
    public static void main(String[] args) {

        AnimalShelter animalShelter = new AnimalShelter();
        animalShelter.enqueue(new Animal("Cat", 1));
        animalShelter.enqueue(new Animal("Cat", 2));
        animalShelter.enqueue(new Animal("Dog", 1));
        animalShelter.enqueue(new Animal("Dog", 2));
        animalShelter.enqueue(new Animal("Cat", 3));
        animalShelter.enqueue(new Animal("Dog", 3));
        animalShelter.printQueue();
        System.out.println("---");
        System.out.println("dequeue any: " + animalShelter.dequeue("Any"));
        System.out.println("dequeue dog: " + animalShelter.dequeue("Dog"));
        System.out.println("dequeue dog: " + animalShelter.dequeue("Cat"));
        System.out.println("---");
        animalShelter.printQueue();

    }

    MyQueue<Animal> myQueue = new MyQueue<>();

    public Animal enqueue(Animal animalData) {
        return myQueue.enqueue(animalData);
    }

    public Animal dequeue(String option) {
        switch (option) {
            case "Any":
                return myQueue.dequeue();
            case "Dog":
                return dequeueAnimal("Dog");
            case "Cat":
                return dequeueAnimal("Cat");
            default:
                return null;
        }
    }

    private Animal dequeueAnimal(String option) {
        MyQueue<Animal> myQueue2 = new MyQueue<>();
        Animal data = null;
        boolean dequeueFlag = true;
        while (!myQueue.isEmpty()) {
            if (myQueue.peek().type.equals(option) && dequeueFlag) {
                data = myQueue.dequeue();
                dequeueFlag = false;
            } else {
                myQueue2.enqueue(myQueue.dequeue());
            }
        }
        while (!myQueue2.isEmpty()) {
            myQueue.enqueue(myQueue2.dequeue());
        }
        return data;
    }

    public void printQueue() {
        myQueue.printQueue();
    }
}
