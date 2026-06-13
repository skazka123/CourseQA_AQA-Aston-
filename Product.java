public class Product {
    private String name;
    private String date;
    private String producer;
    private String country;
    private int price;
    private boolean bookingStatus;

    public Product(String name, String date, String producer, String country, int price, boolean bookingStatus){
        this.name = name;
        this.date = date;
        this.producer = producer;
        this.country = country;
        this.price = price;
        this.bookingStatus = bookingStatus;
    }

    public void info (){
        System.out.println("Название: " + name + "; дата производства: " + date + "; производитель: " + producer +
                "; страна происхождения: " + country + "; цена: " + price + "; статус бронирования: " + (bookingStatus? "Забронирован":"Свободен"));
    }
}
