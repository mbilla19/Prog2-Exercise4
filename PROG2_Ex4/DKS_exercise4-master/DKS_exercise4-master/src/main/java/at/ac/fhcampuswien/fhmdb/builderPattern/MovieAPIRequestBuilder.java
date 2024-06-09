package at.ac.fhcampuswien.fhmdb.builderPattern;

import at.ac.fhcampuswien.fhmdb.models.Genre;

public class MovieAPIRequestBuilder {

    private String base;
    private String query;
    private String genre;
    private String releaseYear;
    private String ratingFrom;

    public MovieAPIRequestBuilder(String base) {
        this.base = base;
    }

    public MovieAPIRequestBuilder query(String query) {
        this.query = query;
        return this;
    }

    public MovieAPIRequestBuilder genre(String genre) {
        this.genre = genre;
        return this;
    }

    public MovieAPIRequestBuilder releaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public MovieAPIRequestBuilder ratingFrom(String ratingFrom) {
        this.ratingFrom = ratingFrom;
        return this;
    }

    public String build() {
        StringBuilder url = new StringBuilder(base);
        if (query != null) url.append("?query=").append(query);
        if (genre != null) url.append("&genre=").append(genre);
        if (releaseYear != null) url.append("&releaseYear=").append(releaseYear);
        if (ratingFrom != null) url.append("&ratingFrom=").append(ratingFrom);
        return url.toString();
    }
    private static final String DELIMITER = "&";

    private StringBuilder sb;

}
