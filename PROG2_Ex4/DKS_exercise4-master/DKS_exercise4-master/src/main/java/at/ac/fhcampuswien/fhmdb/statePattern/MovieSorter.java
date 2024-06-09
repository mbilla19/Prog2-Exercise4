package at.ac.fhcampuswien.fhmdb.statePattern;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.collections.ObservableList;

import java.util.List;

public class MovieSorter {

    private MovieSorterState currentState;
    private final MovieSorterState unsortedState = new UnsortedState();
    private final MovieSorterState ascendingState = new AscendingState();
    private final MovieSorterState descendingState = new DescendingState();

    public MovieSorter() {
        currentState = unsortedState;
    }

    public void setState(MovieSorterState state) {
        this.currentState = state;
    }

    public void sort(List<Movie> movies) {
        currentState.sort(movies);
    }

    public void sortAscending() {
        setState(ascendingState);
    }

    public void sortDescending() {
        setState(descendingState);
    }

    public void resetSort() {
        setState(unsortedState);
    }
    private MovieSorterState state;

    public MovieSorterState getState() {
        return state;
    }

    public void sortMovies(ObservableList<Movie> movieList){
        state.sort(movieList);
    }
}
