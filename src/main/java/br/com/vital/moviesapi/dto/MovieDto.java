package br.com.vital.moviesapi.dto;

import java.util.List;

import org.modelmapper.ModelMapper;

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
		final ModelMapper modelMapper = new ModelMapper();
		final Movie movie = modelMapper.map(this, Movie.class);
		movie.setGenres(GenreType.convertToList(genres));

		return movie;
	}

	public static MovieDto toRequest(final Movie movie) {
		final ModelMapper modelMapper = new ModelMapper();
		final MovieDto dto = modelMapper.map(movie, MovieDto.class);

		dto.setGenres(movie.getGenres().stream().map(e -> e.getCode()).toArray(Integer[]::new));

		return dto;
	}

}
