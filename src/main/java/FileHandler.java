import java.io.*;

public class FileHandler {
    private final String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    // запись данных
    public void writeToFile(String data) throws FileProcessingException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
        } catch (IOException e) {
            throw new FileProcessingException("Ошибка при записи файла", e);
        }
    }

    // чтение данных
    public String readFromFile() throws FileProcessingException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new FileProcessingException("ошибка при чтении файла", e);
        }
        return content.toString();
    }
}