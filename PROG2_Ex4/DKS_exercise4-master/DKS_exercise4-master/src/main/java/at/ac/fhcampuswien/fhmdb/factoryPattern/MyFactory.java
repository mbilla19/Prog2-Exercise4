package at.ac.fhcampuswien.fhmdb.factoryPattern;


import at.ac.fhcampuswien.fhmdb.controllers.*;
import javafx.util.Callback;
import at.ac.fhcampuswien.fhmdb.*;


public class MyFactory implements Callback<Class<?>, Object> {

    private static MainController mainControllerInstance;
    private static MovieListController movieListControllerInstance;
    private static WatchlistController watchlistControllerInstance;

    @Override
    public Object call(Class<?> aClass) {
        if (aClass == MainController.class) {
            if (mainControllerInstance == null) {
                try {
                    mainControllerInstance = (MainController) aClass.getDeclaredConstructor().newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return mainControllerInstance;
        } else if (aClass == MovieListController.class) {
            if (movieListControllerInstance == null) {
                try {
                    movieListControllerInstance = (MovieListController) aClass.getDeclaredConstructor().newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return movieListControllerInstance;
        } else if (aClass == WatchlistController.class) {
            if (watchlistControllerInstance == null) {
                try {
                    watchlistControllerInstance = (WatchlistController) aClass.getDeclaredConstructor().newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return watchlistControllerInstance;
        }
        try {
            return aClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private static MyFactory instance;

    public MyFactory() {

    }

    public static MyFactory getInstance() {
        if (instance == null) {
            instance = new MyFactory();
        }
        return instance;
    }


}


