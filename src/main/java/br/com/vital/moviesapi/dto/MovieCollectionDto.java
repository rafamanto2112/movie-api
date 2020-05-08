package br.com.vital.moviesapi.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.vital.moviesapi.domain.Movie;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MovieCollectionDto {

	private List<MovieDto> items;

	public List<Movie> toResponseList() {
		final List<Movie> movies = items.stream().map(e -> e.toDomain()).collect(Collectors.toList());

		return movies;
	}

}
