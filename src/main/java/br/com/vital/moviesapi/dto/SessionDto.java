package br.com.vital.moviesapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SessionDto {

	private boolean success;

	@JsonProperty("guest_session_id")
	private String id;

	@JsonProperty("expires_at")
	private String expirationDate;

}
