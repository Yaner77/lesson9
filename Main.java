package lesson9;

public class Main {
    public static void main(String[] args) {
        String [][] array = new String[][]{{"1","2","3","4"},{"1","1","1","1"}, {"2","2","2","2"}, {"3","3","3","3"}};
        try {
            try {
                int result = method (array);
                System.out.println(result);

        } catch (MyArraySizeException e) {
            System.out.println("Длина массива превышена! ");}
        }
        catch (MyArrayDataException e) {
            System.out.println("Некорректное значение массива! ");
            System.out.println("Ошибка в ячейке: " + e.i + "x" + e.j);
        }
    }
        public static int method (String [][] array) throws MyArraySizeException,  MyArrayDataException{
        int count = 0;
        if (array.length !=4){
            throw new MyArraySizeException();
        }
            for (int i = 0; i < array.length; i++) {
                if(array [i].length !=4){
                    throw new MyArraySizeException();
                }
                for (int j = 0; j < array.length; j++) {
                    try {
                        count = count + Integer.parseInt(array[i] [j]);

                    }
                    catch (NumberFormatException e){
                        throw new  MyArrayDataException(i, j);
                    }
                }
            }
            return count;
        }
    }