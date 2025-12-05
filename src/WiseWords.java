import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class WiseWords implements Command {

    BufferedReader reader;
    Random rd;
    String readerLine;
    ArrayList<String> words;

    public WiseWords() throws Exception {
        try {
            reader = new BufferedReader(new FileReader("res/citaty.txt"));
            rd = new Random();
            readerLine = "";
            words = new ArrayList<>();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found");
        }
    }

    @Override
    public String execute() {
        while (readerLine!=null) {
            try {
                readerLine = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            words.add(readerLine);
        }
        return words.get(rd.nextInt(words.size()));
    }

    @Override
    public boolean exit() {
        return false;
    }
}
