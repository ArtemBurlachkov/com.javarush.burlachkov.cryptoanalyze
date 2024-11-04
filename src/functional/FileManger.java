package functional;

import java.io.*;

public class FileManger {
    public String readFile(String fileName) {
    try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        String line = reader.readLine();
        while (line != null) {
            line= reader.readLine();
        }
        return line;
    }
    catch(FileNotFoundException e) {
        e.printStackTrace();
    }
    catch (IOException e) {
        throw new RuntimeException(e.getMessage(), e);
    }

        return null;
    }
    public void writeFile(String fileName, String content) {
    try {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(content);
        bufferedWriter.close();
        fileWriter.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
