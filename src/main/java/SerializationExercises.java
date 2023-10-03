import com.google.gson.Gson;
import model.Movie;
import model.Session;
import model.Theatre;

import java.io.*;

public class SerializationExercises {
    /*
        Should define the class for the concepts Movie, Theater and Session.
        A session is a play of movie in a theater.
        Create 2 instances of each class and relate among them.
        Serialize to Json all objects and save then in different files.
     */
    public static class Exercise1 {
        public static void main(String[] args) throws IOException {
            Movie movie1 = new Movie("Lost", "Steven");
            Movie movie2 = new Movie("La ola", "Almodovar");
            Theatre theatre1 = new Theatre("Alfredo Kraus", "Las palmas", 45);
            Theatre theatre2 = new Theatre("Teatro de Madrid", "Madrid", 12);
            Session session1 = new Session(movie1, theatre1);
            Session session2 = new Session(movie2, theatre2);
            Gson gson = new Gson();
            String json = gson.toJson(movie1);
            FileWriter file = new FileWriter("movie1.json");
            file.write(json);
            file.close();
            String json2 = gson.toJson(movie2);
            FileWriter file2 = new FileWriter("movie2.json");
            file2.write(json2);
            file2.close();
            String json3 = gson.toJson(theatre1);
            FileWriter file3 = new FileWriter("theatre1.json");
            file3.write(json3);
            file3.close();
            String json4 = gson.toJson(theatre2);
            FileWriter file4 = new FileWriter("theatre2.json");
            file4.write(json4);
            file4.close();
            String json5 = gson.toJson(session1);
            FileWriter file5 = new FileWriter("session1.json");
            file5.write(json5);
            file5.close();
            String json6 = gson.toJson(session2);
            FileWriter file6 = new FileWriter("session2.json");
            file6.write(json6);
            file6.close();
        }
    }

    /*
        Deserialize the objects created in exercise 1.
        Now serialize them using ObjectOutputStream
     */
    public static class Exercise2 {
        public static void main(String[] args) throws IOException {
            Gson gson = new Gson();
            FileReader fr = new FileReader("movie1.json");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            fr.close();
            br.close();
            Movie movie1 = gson.fromJson(line, Movie.class);
            fr = new FileReader("movie2.json");
            br = new BufferedReader(fr);
            line = br.readLine();
            Movie movie2 = gson.fromJson(line, Movie.class);
            fr.close();
            br.close();
            fr = new FileReader("theatre1.json");
            br = new BufferedReader(fr);
            line = br.readLine();
            Theatre theatre1 = gson.fromJson(line, Theatre.class);
            fr.close();
            br.close();
            fr = new FileReader("theatre2.json");
            br = new BufferedReader(fr);
            line = br.readLine();
            Theatre theatre2 = gson.fromJson(line, Theatre.class);
            fr.close();
            br.close();
            fr = new FileReader("session1.json");
            br = new BufferedReader(fr);
            line = br.readLine();
            Session session1 = gson.fromJson(line, Session.class);
            fr.close();
            br.close();
            fr = new FileReader("session2.json");
            br = new BufferedReader(fr);
            line = br.readLine();
            Session session2 = gson.fromJson(line, Session.class);
            fr.close();
            br.close();


        }
    }

    /*
       Deserialize the objects from the binary files created in exercise 2.
    */
    public static class Exercise3 {

        public static void main(String[] args) {

        }
    }
}
