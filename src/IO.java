import java.util.ArrayList; //employee list
import java.io.BufferedReader; //read file
import java.io.InputStreamReader; //read file
import java.io.FileInputStream; //read file
import java.io.BufferedWriter; //write to file
import java.io.OutputStreamWriter; //write to file
import java.io.FileOutputStream; //write to file
import java.nio.charset.StandardCharsets; //encoding
import java.util.List;

public class IO {
    private String movieData;
    private String invertedData;

    public IO (String movieData, String invertedData) {
        this.movieData = movieData;
        this.invertedData = invertedData;
    }

    public List<String> readLines() {
        ArrayList<String> lines = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(movieData), StandardCharsets.UTF_8))) { //Άνοιγμα με UTF-8
            String line;
            while ((line = br.readLine()) != null) { //Όσο υπάρχουν γραμμές
                lines.add(line); //Προσθήκη στην λίστα
            }
        }
        catch (java.io.FileNotFoundException exc) {
            System.out.println("Δεν βρέθηκε το αρχείο που ζητήθηκε");
        }
        catch (java.io.IOException exc) {
            System.out.println("Υπήρξε κάποιο πρόβλημα στο διάβασμα του αρχείου");
        }

        return lines;
    }

    public void writeActorsToFile(ArrayList<Actor> actors) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(invertedData), StandardCharsets.UTF_8))) {
            for (int i = 0; i < actors.size(); i++) {
                bw.write(actors.get(i).toString());
                bw.newLine();
            }

            bw.close();
        }
        catch (java.io.FileNotFoundException exc) {
            System.out.println("Δεν βρέθηκε το αρχείο που ζητήθηκε");
        }
        catch (java.io.IOException exc) {
            System.out.println("Υπήρξε κάποιο πρόβλημα στο διάβασμα του αρχείου");
        }
    }
}
