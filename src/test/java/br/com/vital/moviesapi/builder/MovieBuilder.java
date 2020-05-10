package br.com.vital.moviesapi.builder;

import java.util.Arrays;

import br.com.vital.moviesapi.domain.Movie;
import br.com.vital.moviesapi.type.GenreType;

public class MovieBuilder {

	private Movie movie;

	public static MovieBuilder create() {
		final MovieBuilder builder = new MovieBuilder();
		builder.movie = new Movie();
		builder.movie.setId(1);
		builder.movie.setAdult(false);
		builder.movie.setOriginalLanguage("en");
		builder.movie.setOriginaTitle("Original Name Test");
		builder.movie.setTitle("Title Test");
		builder.movie.setGenres(Arrays.asList(GenreType.CRIME, GenreType.DRAMA));
		builder.movie.setPopularity(40000000);
		builder.movie.setVoteCount(24214);
		builder.movie.setPosterPath("/iVZ3JAcAjmguGPnRNfWFOtLHOuY.jpg");

		return builder;
	}

	public MovieBuilder withId(final Integer id) {
		movie.setId(id);
		return this;
	}

	public MovieBuilder withTitle(final String title) {
		movie.setTitle(title);
		return this;
	}

	public Movie build() {
		return movie;
	}

}
