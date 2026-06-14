public class Dog extends Animal{
    final static int max_distance_run = 500;
    final static int max_distance_swim = 10;
    final static String type = "dog";
    static int countDog = 0;

    public Dog (String name) {
        super(name);
        countDog++;
    }

    public void info (){
        infoAnimal();
        System.out.println("Вид животного: " + type);
    }

    public void go_run(int distance_run) {
        if (max_distance_run >= distance_run) {
            super.run(distance_run);
        } else {
            super.longestDistance();
        }
    }

    public void go_swim(int distance_swim) {
        if (max_distance_swim >= distance_swim) {
            super.swim(distance_swim);
        } else {
            super.longestDistance();
        }
    }

    public static int getCountDog() {
        return countDog;
    }
}
