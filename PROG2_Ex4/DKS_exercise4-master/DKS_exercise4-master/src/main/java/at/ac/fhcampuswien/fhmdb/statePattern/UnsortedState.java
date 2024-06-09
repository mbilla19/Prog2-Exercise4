package at.ac.fhcampuswien.fhmdb.statePattern;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.collections.ObservableList;

import java.util.List;

public class UnsortedState implements MovieSorterState {
    @Override
    public void sort(List<Movie> movies) {
        // No sorting applied
    }
}
