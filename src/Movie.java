import java.util.*;

public class Movie {
    public static ArrayList<String> parse(String fileLine) {
        ArrayList<String> actors = new ArrayList<String>();
        String[] attributes = fileLine.split("#");

        for (String attribute: attributes) {
            String[] keyValuePair = attribute.split(":");
            String key = keyValuePair[0];

            if (key.equals("Πρωταγωνιστής") || key.equals("Ηθοποιός")) {
                String[] values = keyValuePair[1].split(";");
                for (String actorName : values) actors.add(actorName);
            }
        }

        return actors;
    }
}
