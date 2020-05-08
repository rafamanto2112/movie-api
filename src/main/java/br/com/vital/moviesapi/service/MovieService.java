package br.com.vital.moviesapi.service;

import java.util.List;

import br.com.vital.moviesapi.dto.request.MovieRequest;
import br.com.vital.moviesapi.dto.response.MovieResponse;

public interface MovieService {

	void insert(MovieRequest request);

	void update(MovieRequest request);

	void delete(Integer id);

	MovieResponse find(Integer id);

	List<MovieResponse> listAll();

}
