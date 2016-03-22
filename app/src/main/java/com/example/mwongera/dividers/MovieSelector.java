package com.example.mwongera.dividers;

import com.karumi.dividers.Direction;
import com.karumi.dividers.Position;
import com.karumi.dividers.sample.grid.model.Movie;
import com.karumi.dividers.selector.Selector;
import java.util.EnumSet;
import java.util.List;

/**
 * Created by mwongera on 3/22/16.
 */
public class MovieSelector implements Selector {

    private final List<Movie> movies;
    private final int highRatingThreshold;

    public MovieSelector(List<Movie> movies, int highRatingThreshold) {
        this.movies = movies;
        this.highRatingThreshold = highRatingThreshold;
    }

    @Override public boolean isPositionSelected(Position position) {
        return movies.get(position.getAbsoluteIndex()).getRating() >= highRatingThreshold;
    }

    @Override public EnumSet<Direction> getDirectionsByPosition(Position position) {
        return EnumSet.allOf(Direction.class);
    }

}
