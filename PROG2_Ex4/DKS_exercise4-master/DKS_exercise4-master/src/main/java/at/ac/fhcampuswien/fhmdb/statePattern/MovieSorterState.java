package at.ac.fhcampuswien.fhmdb.statePattern;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.collections.ObservableList;

import java.util.List;

public interface MovieSorterState {
    void sort(List<Movie> movies);
}
