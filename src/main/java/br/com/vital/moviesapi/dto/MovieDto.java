package br.com.vital.moviesapi.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.vital.moviesapi.domain.Movie;
import br.com.vital.moviesapi.type.GenreType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MovieDto {

	private Integer id;
	private boolean adult;

	@JsonProperty("original_language")
	private String originalLanguage;

	@JsonProperty("original_title")
	private String originaTitle;

	private String title;

	@JsonProperty("genre_ids")
	private Integer[] genres;
	private int popularity;

	@JsonProperty("vote_count")
	private Integer voteCount;

	@JsonProperty("poster_path")
	private String posterPath;

	public static List<Movie> toDomainList(final MovieDto dto) {
		return null;
	}

	public static Movie toDomain(final MovieDto forObject) {
		return null;
	}

	public Movie toDomain() {
		final Movie movie = new Movie();
		movie.setId(id);
		movie.setAdult(adult);
		movie.setOriginalLanguage(originalLanguage);
		movie.setOriginaTitle(originaTitle);
		movie.setPopularity(popularity);
		movie.setPosterPath(posterPath);
		movie.setTitle(title);
		movie.setVoteCount(voteCount);

		movie.setGenres(GenreType.convertToList(genres));

		return movie;
	}

	public static MovieDto toRequest(final Movie movie) {
		final MovieDto dto = new MovieDto();
		dto.setTitle(movie.getTitle());
		dto.setAdult(movie.isAdult());
		dto.setOriginalLanguage(movie.getOriginalLanguage());
		dto.setOriginaTitle(movie.getOriginaTitle());
		dto.setPopularity(movie.getPopularity());
		dto.setPosterPath(movie.getPosterPath());
		dto.setVoteCount(movie.getVoteCount());
		dto.setGenres(movie.getGenres().stream().map(e -> e.getCode()).toArray(Integer[]::new));

		return dto;
	}

}
