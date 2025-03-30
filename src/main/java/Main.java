import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler("test.txt");


        Scanner scannerStr = new Scanner(System.in);
        String data = scannerStr.nextLine();


        System.out.print("Введите данные для записи в файл: ");

        scannerStr.close();
        try {
            fileHandler.writeToFile(data);
            System.out.println("данные записаны в файл.");

            String readData = fileHandler.readFromFile();
            System.out.println("содержимое файла:");
            System.out.println(readData);
        } catch (FileProcessingException e) {
            System.err.println("произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
