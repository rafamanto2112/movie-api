package br.com.vital.moviesapi.domain;

import java.util.List;
import java.util.Objects;

import br.com.vital.moviesapi.exceptions.BusinessException;
import br.com.vital.moviesapi.repository.MovieRepository;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Catalog {

	private final MovieRepository movieRepository;

	public Catalog(final MovieRepository movieRepository) {
		this.movieRepository = movieRepository;

	}

	public void insert(final Movie movie) {
		movieRepository.insert(movie);
	}

	public void update(final Movie movie) {
		final Movie movieResult = movieRepository.findById(movie.getId());

		if(Objects.isNull(movieResult)) {
			throw new BusinessException("movie not found");
		}

		movieRepository.update(movie);
	}

	public void delete(final Integer id) {
		final Movie movieResult = movieRepository.findById(id);

		if(Objects.isNull(movieResult)) {
			throw new BusinessException("movie not found");
		}

		movieRepository.delete(id);
	}

	public List<Movie> listAll() {
		return movieRepository.listAll();
	}

	public Movie find(final Integer id) {
		return movieRepository.findById(id);
	}

}
