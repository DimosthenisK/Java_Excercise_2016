import java.util.*;

public class Main {
    ArrayList<Actor> actors = new ArrayList<Actor>();

    public int getIndexOfActor(String actorName) {
        for (int i = 0; i < actors.size(); i++) {
            if (actors.get(i).name.equals(actorName)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Main mainClass = new Main();
        IO io = new IO(
                "C:\\Users\\demos\\IdeaProjects\\Java_Excercise_2016\\exampledata.txt",
                "C:\\Users\\demos\\IdeaProjects\\Java_Excercise_2016\\inverted.txt"
                );

        List<String> movies = io.readLines();
        //Για κάθε movie
        for (int i = 0; i < movies.size(); i++) {
            String rawMovie = movies.get(i);

            //Parse για να πάρουμε τους ηθοποιούς
            ArrayList<String> actorNames = Movie.parse(rawMovie);
            for (String actorName : actorNames) {
                //Βρίσκουμε τον ηθοποιό στην λίστα Actors
                Integer actorIndex = mainClass.getIndexOfActor(actorName);

                //Αν υπάρχει, του προσθέτουμε το ID της ταινίας
                if (actorIndex != -1) mainClass.actors.get(actorIndex).addId(i+1);
                else {
                    //Αλλιώς τον δημιουργούμε και του προσθέτουμε το ID
                    mainClass.actors.add(new Actor(actorName));
                    mainClass.actors.get(mainClass.actors.size()-1).addId(i+1);
                }
            }
        }

        //Τέλος, γράφουμε τους actors σε ένα αρχείο
        io.writeActorsToFile(mainClass.actors);
    }
}
