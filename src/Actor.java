import java.util.*;

public class Actor {
    public String name;
    private List<Integer> movieIds;

    public Actor(String name) {
        this.name = name;
        movieIds = new ArrayList<Integer>();
    }

    public void addId(Integer id) {
        this.movieIds.add(id);
    }

    //Δημιουργία inverted string
    public String toString() {
        String result = "";
        result += name + ":";

        //Για κάθε id στην λίστα, προσθήκη στο string
        //και προσθήκη διαχωριστικού εκτός του τελευταίου id
        for (int i = 0; i < movieIds.size() ; i++) {
            result += movieIds.get(i);
            if (i != movieIds.size() - 1) result += ";";
        }

        return result;
    }
}
