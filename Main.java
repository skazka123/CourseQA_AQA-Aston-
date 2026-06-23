import java.util.Random;

void main(String[] args) {
    String[][] arr = new String[][]{ {"2", "2", "2", "2"},{"2", "2", "2", "2"}, {"2", "2", "2", "2"}, {"2", "2", "2", "2"}};

    try {
        methodAllChecking(arr);
    } catch (MyArraySizeException e) {
        System.out.println("Получен массив неверного размера");
    } catch (MyArrayDataException e) {
        System.out.println("Неверный формат данных" + "- ошибка в ячейке: " + e.i + "x" + e.j);
    }
}

void methodAllChecking (String [][]arr) throws MyArraySizeException, MyArrayDataException {
    checkSizeArray(arr);
    sumArrayData(arr);
    getArrayElements (arr);
}

void checkSizeArray(String [][]arr) throws MyArraySizeException{
    int a = arr.length;
    int b = arr[0].length;
    if (a == 4 & b == 4) {
        System.out.println("Получен массив размера 4х4");
    } else {
        throw new MyArraySizeException();
    }
}

void sumArrayData(String [][]arr) throws MyArrayDataException{
    int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j);
                }
            }
        }
    System.out.println("Найдена сумма: " + sum);
}

void getArrayElements(String [][]arr){
    Random random = new Random();
    int line = random.nextInt();
    int column = random.nextInt();
    try {
        System.out.println("Значение случайной ячейки " + line + "x" + column + " : " + arr[line][column]);
    } catch (ArrayIndexOutOfBoundsException e){
        System.out.println("Ячейки " + line + "x" + column + " в массиве нет");
    }
}


