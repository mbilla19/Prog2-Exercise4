package at.ac.fhcampuswien.fhmdb.database;

import at.ac.fhcampuswien.fhmdb.observerPattern.Observable;
import at.ac.fhcampuswien.fhmdb.observerPattern.Observer;
import at.ac.fhcampuswien.fhmdb.observerPattern.Observer;
import com.j256.ormlite.dao.Dao;

import java.util.ArrayList;
import java.util.List;

public class WatchlistRepository implements Observable {
    private List<Observer> observers = new ArrayList<>();
    private static WatchlistRepository instance;

    private WatchlistRepository() {
        // private constructor to prevent instantiation
    }

    public static WatchlistRepository getInstance() {
        if (instance == null) {
            instance = new WatchlistRepository();
        }
        return instance;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    Dao<WatchlistMovieEntity, Long> dao;

    public List<WatchlistMovieEntity> readWatchlist() throws DataBaseException {
        try {
            return dao.queryForAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("Error while reading watchlist");
        }
    }

    public void addToWatchlist(WatchlistMovieEntity movie) throws DataBaseException {
        try {
            // only add movie if it does not exist yet
            long count = dao.queryBuilder().where().eq("apiId", movie.getApiId()).countOf();
            if (count == 0) {
                dao.create(movie);
                notifyObservers();
            } else {
                notifyObservers();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("Error while adding to watchlist");
        }
    }

    public void removeFromWatchlist(WatchlistMovieEntity movie) throws DataBaseException {
        try {
            dao.delete(movie);
        } catch (Exception e) {
            throw new DataBaseException("Error while removing from watchlist");
        }
    }

    public boolean isOnWatchlist(WatchlistMovieEntity movie) throws DataBaseException {
        try {
            return dao.queryForMatching(movie).size() > 0;
        } catch (Exception e) {
            throw new DataBaseException("Error while checking if movie is on watchlist");
        }
    }

}
