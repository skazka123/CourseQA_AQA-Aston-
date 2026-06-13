//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public static void main(String[] args) {
    setOfProducts();
    attractionPark();
}

public static void setOfProducts(){
    Product[] productsArray = new Product[5];
    productsArray[0] = new Product("Шахматы", "2025", "Лес", "Россия", 3867, true);
    productsArray[1] = new Product("Монополия", "2024", "HasbroGaming", "Ирландия", 1245, true);
    productsArray[2] = new Product("Тако, кот коза и сыр", "2025", "Hobby world", "Россия", 999, false);
    productsArray[3] = new Product("Башня удачи", "2026", "Дрова и щепки", "Россия", 476, true);
    productsArray[4] = new Product("Есть вопросики", "2024", "BoardGame", "Россия", 670, false);
    for (int i=0; i < 5; i++) {
        productsArray[i].info();
    }
}

public static void attractionPark(){
    Park happy = new Park("happy");
    Park.Attraction attractionPark = happy.new Attraction("Колесо обозрения", "9:00 - 19:00", 250);
    attractionPark.attractionInfo();
}