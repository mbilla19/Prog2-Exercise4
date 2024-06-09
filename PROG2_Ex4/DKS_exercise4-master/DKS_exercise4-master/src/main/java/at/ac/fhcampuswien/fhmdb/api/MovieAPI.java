package at.ac.fhcampuswien.fhmdb.api;

import at.ac.fhcampuswien.fhmdb.builderPattern.MovieAPIRequestBuilder;
import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import okhttp3.*;
import com.google.gson.Gson;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MovieAPI {
    private static final String URL = "http://prog2.fh-campuswien.ac.at/movies"; // https if certificates work
    private static final OkHttpClient client = new OkHttpClient();
    //test

    public static List<Movie> getAllMovies() throws MovieApiException {
        return getAllMovies(null, null, null, null);
    }

    public static List<Movie> getAllMovies(String query, Genre genre, String releaseYear, String ratingFrom) throws MovieApiException{

        String url = new MovieAPIRequestBuilder(URL)
                .query(query)
                .genre(String.valueOf(genre))
                .releaseYear(releaseYear)
                .ratingFrom(ratingFrom)
                .build();


        Request request = new Request.Builder()
                .url(url)
                .removeHeader("User-Agent")
                .addHeader("User-Agent", "http.agent")  // needed for the server to accept the request
                .build();

        try (Response response = client.newCall(request).execute()) {
            String responseBody = Objects.requireNonNull(response.body()).string();
            Gson gson = new Gson();
            Movie[] movies = gson.fromJson(responseBody, Movie[].class);

            return Arrays.asList(movies);
        } catch (Exception e) {
            throw new MovieApiException(e.getMessage());
        }
    }
}
