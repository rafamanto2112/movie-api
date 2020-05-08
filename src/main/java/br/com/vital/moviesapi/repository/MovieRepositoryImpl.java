package br.com.vital.moviesapi.repository;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import br.com.vital.moviesapi.domain.Movie;
import br.com.vital.moviesapi.dto.MovieCollectionDto;
import br.com.vital.moviesapi.dto.MovieDto;
import br.com.vital.moviesapi.dto.SessionDto;
import br.com.vital.moviesapi.exceptions.TechinicalException;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${moviedbapi}")
	private String urlDataBaseApi;

	@Value("${appKey}")
	private String appKey;

	@Value("${language}")
	private String language;

	@Value("${list.id}")
	private String listId;

	@Cacheable("session")
	public String getSession() {
		try {
			final SessionDto session = restTemplate.getForObject(buildNewSessionUrl(), SessionDto.class);
			return session.getId();

		} catch(final Exception e) {
			e.printStackTrace();
			throw new TechinicalException("insert failed", e);
		}
	}

	@Override
	public void insert(final Movie movie) {
		try {
			restTemplate.postForObject(
					getBaseListUrl() + "/add_item" + buildAppKey() + buildSession(), MovieDto.toRequest(movie),
					Object.class);

		} catch(final Exception e) {
			e.printStackTrace();
			throw new TechinicalException("insert failed", e);
		}
	}

	private String buildSession() {
		final StringBuilder sb = new StringBuilder();
		sb.append("&").append("session_id=").append(getSession());

		return sb.toString();
	}

	@Override
	public Movie findById(final Integer id) {
		final MovieDto dto = restTemplate.getForObject(urlDataBaseApi + "/movie/" + id + buildAppKey(), MovieDto.class);

		if(Objects.nonNull(dto)) {
			return dto.toDomain();
		}

		return null;
	}

	@Override
	public void update(final Movie movie) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(final Integer id) {
		// TODO Auto-generated method stub

	}

	private String getBaseListUrl() {
		final StringBuilder sb = new StringBuilder();
		sb.append(urlDataBaseApi);
		sb.append("/list");
		sb.append("/").append(listId);

		return sb.toString();
	}

	private String buildAppKey() {
		final StringBuilder sb = new StringBuilder();
		sb.append("?").append("api_key=").append(appKey);

		return sb.toString();
	}

	@Override
	public List<Movie> listAll() {
		final MovieCollectionDto dto = restTemplate.getForObject(getBaseListUrl() + buildAppKey(), MovieCollectionDto.class);

		if(Objects.nonNull(dto)) {
			return dto.toResponseList();
		}

		return null;
	}

	private String buildNewSessionUrl() {
		final StringBuilder sessionUrl = new StringBuilder();
		sessionUrl.append(urlDataBaseApi)
		.append("/authentication")
		.append("/guest_session")
		.append("/new")
		.append(buildAppKey());

		return sessionUrl.toString();
	}

}
