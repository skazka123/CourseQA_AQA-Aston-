public class Cat extends Animal {
    final static int max_distance_run = 200;
    final static int max_distance_swim = 0;
    boolean satiety = false;
    final static String type = "cat";
    int need_food;
    static int countCat = 0;

    public Cat (String name, int need_food) {
        super(name);
        this.need_food = need_food;
        countCat++;
    }

    public void info (){
        infoAnimal();
        System.out.println("Вид животного: " + type + ", статус животного: "+ (satiety? "сыт" : "голоден"));
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
            System.out.println(name + " не умеет плавать");
        }
    }

    public static int getCountCat() {
        return countCat;
    }
}
