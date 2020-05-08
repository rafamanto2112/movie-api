package br.com.vital.moviesapi.repository;

import java.util.List;

import br.com.vital.moviesapi.domain.Movie;

public interface MovieRepository {

	void insert(Movie movie);

	Movie findById(Integer id);

	void update(Movie movie);

	void delete(Integer id);

	List<Movie> listAll();

}
