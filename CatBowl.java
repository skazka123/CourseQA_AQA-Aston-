public class CatBowl {
    int count_food;

    public CatBowl(int count_food){
        this.count_food = count_food;
    }

    public int catEat (int cat_eat){
        return count_food = count_food - cat_eat;
    }

    public int addFood (int add_food){
        return count_food = count_food + add_food;
    }

    public void info (){
        System.out.println("В миске еды: " + count_food);
    }
}
