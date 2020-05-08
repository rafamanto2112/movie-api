package br.com.vital.moviesapi.type;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum GenreType {

	ACTION(28),
	ADVENTURE(12),
	ANIMATION(16),
	COMEDY(35),
	CRIME(80),
	DOCUMENTARY(99),
	DRAMA(18),
	FAMILY(10751),
	FANTASY(14),
	HISTORY(36),
	HORROR(27),
	MUSIC(10402),
	MYSTERY(9648),
	ROMANCE(10749),
	SCIENCE_FICTION(878),
	TV_MOVIE(10770),
	THRILLER(53),
	WAR(10752),
	WESTERN(37),
	OTHER(1);

	private Integer code;

	public static GenreType getByCode(final Integer code) {
		return Arrays.stream(GenreType.values()).filter(e -> e.getCode().equals(code)).findFirst().orElse(OTHER);
	}

	public static List<GenreType> convertToList(final Integer... genres) {
		if(Objects.nonNull(genres)) {
			final List<GenreType> genreList = Arrays.stream(genres).map(e -> getByCode(e)).collect(Collectors.toList());
			return genreList;
		}

		return null;

	}

}
