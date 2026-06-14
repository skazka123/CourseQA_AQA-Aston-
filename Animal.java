public class Animal {
    String name;
    static int countAnimal = 0;
    Animal() {
        countAnimal++;
    }

    public Animal(String name){
        this.name = name;
    }

    public void infoAnimal (){
        System.out.println("Имя животного: " + name);
    }

    public void run (int distance_run){
        System.out.println(name + " пробежал " + distance_run + " м");
    }

    public void swim (int distance_swim){
        System.out.println(name + " проплыл " + distance_swim + " м");
    }

    public void longestDistance (){
        System.out.println(name + " не смог преодолеть расстояние");
    }

    public static int getCountAnimal() {
        return countAnimal;
    }
}
