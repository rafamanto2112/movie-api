package br.com.vital.moviesapi.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vital.moviesapi.domain.Catalog;
import br.com.vital.moviesapi.domain.Movie;
import br.com.vital.moviesapi.dto.request.MovieRequest;
import br.com.vital.moviesapi.dto.response.MovieResponse;
import br.com.vital.moviesapi.exceptions.BusinessException;
import br.com.vital.moviesapi.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public void insert(final MovieRequest request) {
		final Catalog catalog = new Catalog(movieRepository);
		catalog.insert(request.toDomain());
	}

	@Override
	public void update(final MovieRequest request) {
		final Catalog catalog = new Catalog(movieRepository);
		catalog.update(request.toDomain());
	}

	@Override
	public void delete(final Integer id) throws BusinessException {
		final Catalog catalog = new Catalog(movieRepository);
		catalog.delete(id);
	}

	@Override
	public MovieResponse find(final Integer id) {
		final Catalog catalog = new Catalog(movieRepository);

		return MovieResponse.toResponse(catalog.find(id));
	}

	@Override
	public List<MovieResponse> listAll() {
		final Catalog catalog = new Catalog(movieRepository);

		final List<Movie> movies = catalog.listAll();

		if(Objects.nonNull(movies)) {
			return movies.stream().map(e -> MovieResponse.toResponse(e)).collect(Collectors.toList());
		}

		return null;
	}

}
