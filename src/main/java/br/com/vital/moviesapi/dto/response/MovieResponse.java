package br.com.vital.moviesapi.dto.response;

import java.util.List;

import org.modelmapper.ModelMapper;

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
		final ModelMapper modelMapper = new ModelMapper();
		final MovieResponse response = modelMapper.map(movie, MovieResponse.class);

		return response;
	}

}
