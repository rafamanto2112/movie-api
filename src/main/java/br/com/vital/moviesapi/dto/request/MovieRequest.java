package br.com.vital.moviesapi.dto.request;

import java.io.Serializable;

import br.com.vital.moviesapi.domain.Movie;
import br.com.vital.moviesapi.type.GenreType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MovieRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private boolean adult;
	private String originalLanguage;
	private String originaTitle;
	private String title;
	private Integer[] genres;
	private Integer popularity;
	private Integer voteCount;
	private String mediaType;
	private String posterPath;

	public Movie toDomain() {
		final Movie movie = new Movie();
		movie.setId(id);
		movie.setAdult(adult);
		movie.setGenres(GenreType.convertToList(genres));
		movie.setOriginalLanguage(originalLanguage);
		movie.setOriginaTitle(originaTitle);
		movie.setPopularity(popularity);
		movie.setPosterPath(posterPath);
		movie.setTitle(title);
		movie.setVoteCount(voteCount);

		return movie;
	}

}
