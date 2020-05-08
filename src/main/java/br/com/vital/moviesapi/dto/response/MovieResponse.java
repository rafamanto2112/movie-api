package br.com.vital.moviesapi.dto.response;

import java.util.List;

import br.com.vital.moviesapi.domain.Movie;
import br.com.vital.moviesapi.type.GenreType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MovieResponse {

	private Integer id;
	private boolean adult;
	private String originalLanguage;
	private String originaTitle;
	private String title;
	private List<GenreType> genres;
	private Integer popularity;
	private Integer voteCount;
	private String posterPath;

	public static MovieResponse toResponse(final Movie movie) {
		final MovieResponse response = new MovieResponse();
		response.setId(movie.getId());
		response.setGenres(movie.getGenres());
		response.setOriginalLanguage(movie.getOriginalLanguage());
		response.setOriginaTitle(movie.getOriginaTitle());
		response.setPopularity(movie.getPopularity());
		response.setPosterPath(movie.getPosterPath());
		response.setTitle(movie.getTitle());
		response.setVoteCount(movie.getVoteCount());

		return response;
	}

}
