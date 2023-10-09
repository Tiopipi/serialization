import com.google.gson.Gson;
import com.sun.jdi.ClassType;
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
    public static class Exercise2 implements Serializable {
        public static Movie deserializeMovieJson(String file) throws IOException {
            Gson gson = new Gson();
            FileReader fr = new FileReader(String.valueOf(file));
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            fr.close();
            br.close();
            return gson.fromJson(line, Movie.class);
        }

        public static Theatre deserializeTheatreJson(String file) throws IOException {
            Gson gson = new Gson();
            FileReader fr = new FileReader(String.valueOf(file));
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            fr.close();
            br.close();
            return gson.fromJson(line, Theatre.class);
        }

        public static Session deserializeSessionJson(String file) throws IOException {
            Gson gson = new Gson();
            FileReader fr = new FileReader(String.valueOf(file));
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            fr.close();
            br.close();
            return gson.fromJson(line, Session.class);
        }

        public static void serialize(String fileName, Object obj) throws IOException {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.flush();
            oos.close();
        }

        public static void main(String[] args) throws IOException {
            Movie movie1 = deserializeMovieJson("movie1.json");
            Movie movie2 = deserializeMovieJson("movie2.json");
            Theatre theatre1 = deserializeTheatreJson("theatre1.json");
            Theatre theatre2 = deserializeTheatreJson("theatre2.json");
            Session session1 = deserializeSessionJson("session1.json");
            Session session2 = deserializeSessionJson("session2.json");
            serialize("movie1.txt", movie1);
            serialize("movie2.txt", movie2);
            serialize("theatre1.txt", theatre1);
            serialize("theatre2.txt", theatre2);
            serialize("session1.txt", session1);
            serialize("session2.txt", session2);
        }
    }

    /*
       Deserialize the objects from the binary files created in exercise 2.
    */
    public static class Exercise3 {

        public static Movie deserializeMovie(String fileName) throws IOException, ClassNotFoundException {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Movie object = (Movie) ois.readObject();
            ois.close();
            return object;
        }
        public static Theatre deserializeTheatre(String fileName) throws IOException, ClassNotFoundException {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Theatre object = (Theatre) ois.readObject();
            ois.close();
            return object;
        }
        public static Session deserializeSession(String fileName) throws IOException, ClassNotFoundException {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Session object = (Session) ois.readObject();
            ois.close();
            return object;
        }

        public static void main(String[] args) throws IOException, ClassNotFoundException {
            Movie movie1 = deserializeMovie("movie1.txt");
            Movie movie2 = deserializeMovie("movie2.txt");
            Theatre theatre1 = deserializeTheatre("theatre1.txt");
            Theatre theatre2 = deserializeTheatre("theatre2.txt");
            Session session1 = deserializeSession("session1.txt");
            Session session2 = deserializeSession("session2.txt");

        }
    }
}
