package model;

public class Session {
    private Movie movie;
    private Theatre theatre;

    public Session(Movie movie, Theatre theatre) {
        this.movie = movie;
        this.theatre = theatre;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }
}
