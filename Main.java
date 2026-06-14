//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    homeAnimals();
    mathFigure();
}

public static void homeAnimals(){
    catsLand();
    dogsLand();
    countAnimal();
}

public static void catsLand(){
    Cat [] all_cat = new Cat[3];
    all_cat[0] = new Cat("Барсик", 10);
    all_cat[1] = new Cat("Боня", 12);
    all_cat[2] = new Cat("Бруно", 11);
    for (Cat cat : all_cat) {
        cat.info();
        cat.go_run(5);
        cat.go_swim(10);
    }

    CatBowl catBowl = new CatBowl(25);
    catEat(all_cat,catBowl);
    catBowl.info();

    catBowl.count_food = catBowl.addFood(50);
    catEat(all_cat,catBowl);
    catBowl.info();
}

public static void dogsLand(){
    Dog dog1 = new Dog("Бобик");
    dog1.info();
    dog1.go_run(350);
    dog1.go_swim(20);
}

public static void countAnimal(){
    int allAnimal = Animal.getCountAnimal() + Cat.getCountCat() + Dog.getCountDog();
    System.out.println("Всего животных: " + allAnimal);
    System.out.println("Всего котов: " + Cat.getCountCat());
    System.out.println("Всего собак: " + Dog.getCountDog());
}

public static void catEat(Cat [] all_cat, CatBowl catBowl){
    for (Cat cat : all_cat) {
        if (!cat.satiety) {
            if (cat.need_food < catBowl.count_food) {
                catBowl.count_food = catBowl.catEat(cat.need_food);
                cat.satiety = true;
            }
        }
        cat.info();
    }
}

public static void mathFigure(){
    Circle circle1 = new Circle(5, "Желтый", "Зеленый");
    circle1.info();

    Rectangle rectangle1 = new Rectangle(10, 15, "Оливковый", "Лимонный");
    rectangle1.info();

    Triangle triangle1 = new Triangle(2, 5, 6, "Белый", "Черный");
    triangle1.info();
}

