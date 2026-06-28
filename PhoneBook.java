import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map <String, List<String>> book;

    public PhoneBook(){
        this.book = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        if (book.containsKey(surname)) {
            List<String> phoneList = book.get(surname);
            phoneList.add(phoneNumber);
            book.put(surname, phoneList);
        } else {
            List<String> phoneList = new ArrayList<>();
            phoneList.add(phoneNumber);
            book.put(surname, phoneList);
        }
    }

    public List<String> get(String surname) {
        return book.get(surname);
    }

    public void infoAbonent(String surname) {
        System.out.println("Абонент: " + surname + ", номера телефонов "+ book.get(surname));
    }
}
