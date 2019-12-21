package C3_StacksAndQueues;

import java.util.EmptyStackException;

public class P6_AnimalShelter {

    public static void main(String args[]){
        AnimalShelter animalShelter = new AnimalShelter();
        animalShelter.enqueue(new Animal("A", Animal.TYPE_DOG));
        animalShelter.enqueue(new Animal("B", Animal.TYPE_DOG));
        animalShelter.enqueue(new Animal("C", Animal.TYPE_CAT));
        System.out.println("Enqueuing some data : ");
        System.out.println(animalShelter);

        System.out.println("dequeueAny() returned " + animalShelter.dequeueAny());
        System.out.println("Now, AnimalShelter : ");
        System.out.println(animalShelter);

        System.out.println("dequeueCat() returned " + animalShelter.dequeueCat());
        System.out.println("Now, AnimalShelter : ");
        System.out.println(animalShelter);

        System.out.println("dequeueCat() returned " + animalShelter.dequeueCat());
        System.out.println("Now, AnimalShelter : ");
        System.out.println(animalShelter);

        System.out.println("dequeueDog() returned " + animalShelter.dequeueDog());
        System.out.println("Now, AnimalShelter : ");
        System.out.println(animalShelter);
    }

    private static class AnimalShelter{
        Node<Animal> start, end;

        void enqueue(Animal animal){
            Node<Animal> node = new Node<>(animal);
            if(start == null) {
                start = end = node;
            } else {
                end.next = node;
                end = node;
            }
        }

        Animal dequeueAny(){
            if(start == null){
                throw new EmptyStackException();
            } else {
                Animal oldestAnimal = start.data;
                start = start.next;
                return oldestAnimal;
            }
        }

        Animal dequeueDog(){
            return dequeueSpecific(Animal.TYPE_DOG);
        }

        Animal dequeueCat(){
            return dequeueSpecific(Animal.TYPE_CAT);
        }

        Animal dequeueSpecific(String type){
            if(start == null) {
                throw new EmptyStackException();
            } else {
                Node<Animal> node, prev;
                node = prev = start;

                while (node != null && !node.data.type.equals(type)){
                    prev = node;
                    node = node.next;
                }

                if(node == null)
                    return null;
                else if(node == start)
                    start = start.next;
                else
                    prev.next = node.next;
                return node.data;
            }
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Start -> ");

            if(start == null){
                builder.append("NULL <- End");
                return builder.toString();
            }

            Node<Animal> node = start;
            while (node != null){
                builder.append(node.data);
                if(node.next != null)
                    builder.append(" -> ");
                node = node.next;
            }

            return builder.append("\n").toString();
        }

    }

    private static class Animal{
        static final String TYPE_DOG = "Dog", TYPE_CAT = "Cat";

        String name, type;

        Animal(String name, String type){
            this.name = name;
            this.type = type;
        }

        @Override
        public String toString() {
            return String.format("{name:%s, type:%s}", name, type);
        }
    }

}
