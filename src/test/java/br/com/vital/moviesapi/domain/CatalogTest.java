package br.com.vital.moviesapi.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.vital.moviesapi.builder.MovieBuilder;
import br.com.vital.moviesapi.exceptions.BusinessException;
import br.com.vital.moviesapi.exceptions.TechinicalException;
import br.com.vital.moviesapi.repository.MovieRepository;

@RunWith(MockitoJUnitRunner.class)
public class CatalogTest {

	@InjectMocks
	private Catalog catalog;

	@Mock
	private MovieRepository movieRepository;

	@Test
	public void listAllTest() {
		final List<Movie> movies = new ArrayList<>();
		movies.add(MovieBuilder.create().withId(1).withTitle("Film One").build());
		movies.add(MovieBuilder.create().withId(2).withTitle("Film Two").build());
		movies.add(MovieBuilder.create().withId(3).withTitle("Film Three").build());

		Mockito.when(movieRepository.listAll()).thenReturn(movies);

		final List<Movie> moviesResult = catalog.listAll();

		assertThat(moviesResult.size(), is(3));
		assertThat(moviesResult.get(2).getId(), notNullValue());
		assertThat(moviesResult.get(2).getTitle(), notNullValue());
	}

	@Test
	public void findTest() {
		final Movie movie = MovieBuilder.create().withId(145).withTitle("founded filme test").build();

		Mockito.when(movieRepository.findById(Mockito.anyInt())).thenReturn(movie);

		final Movie movieResult = catalog.find(Mockito.anyInt());

		assertThat(movieResult.getId(), is(145));
		assertThat(movieResult.getTitle(), is("founded filme test"));
	}

	@Test(expected = TechinicalException.class)
	public void findTechinicalErrorTest() {
		final TechinicalException techinicalException = new TechinicalException("message techinical", new Throwable());

		Mockito.when(movieRepository.findById(Mockito.anyInt())).thenThrow(techinicalException);

		catalog.find(Mockito.anyInt());
	}

	@Test
	public void deleteTest() {
		final Movie movie = MovieBuilder.create().withId(145).withTitle("founded filme test").build();

		Mockito.when(movieRepository.findById(Mockito.anyInt())).thenReturn(movie);

		catalog.delete(Mockito.anyInt());

		Mockito.verify(movieRepository).delete(Mockito.anyInt());
	}

	@Test
	public void deleteMovieNotFoundErrorTest() {
		Mockito.when(movieRepository.findById(Mockito.anyInt())).thenReturn(null);

		try {
			catalog.delete(Mockito.anyInt());
			fail();
		} catch(final BusinessException e) {
			assertThat(e.getMessage(), is("movie not found"));

		}
	}

	@Test
	public void updateTest() {
		final Movie movie = MovieBuilder.create().withId(145).withTitle("founded filme test").build();

		Mockito.when(movieRepository.findById(Mockito.anyInt())).thenReturn(movie);

		catalog.update(MovieBuilder.create().build());

		Mockito.verify(movieRepository).update(Mockito.any());
	}

	@Test
	public void updateMovieNotFoundErrorTest() {
		Mockito.when(movieRepository.findById(Mockito.anyInt())).thenReturn(null);

		try {
			catalog.update(MovieBuilder.create().build());
			fail();
		} catch(final BusinessException e) {
			assertThat(e.getMessage(), is("movie not found"));

		}
	}

}
