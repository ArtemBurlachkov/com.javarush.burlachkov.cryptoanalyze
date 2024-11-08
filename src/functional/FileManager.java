package functional;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public static List<String> readFile(String filename) {
        try (FileReader in = new FileReader(String.valueOf(Path.of(filename)));
             BufferedReader reader = new BufferedReader(in)) {
            List<String> list = new ArrayList<>();
            while (reader.ready()) {
                list.add(reader.readLine());
            }
            return list;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeFile(String filename, List<String> list) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(String.valueOf(Path.of(filename))))) {
            for (int i = 0; i < list.size(); i++) {
                out.write(list.get(i));
                if (i < list.size() - 1) {
                    out.newLine();
                }
                out.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
