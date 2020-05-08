package br.com.vital.moviesapi.domain;

import java.util.List;

import br.com.vital.moviesapi.type.GenreType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Movie {

	private Integer id;
	private boolean adult;
	private String originalLanguage;
	private String originaTitle;
	private String title;
	private List<GenreType> genres;
	private Integer popularity;
	private Integer voteCount;
	private String mediaType;
	private String posterPath;

}
