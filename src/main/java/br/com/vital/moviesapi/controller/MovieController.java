package br.com.vital.moviesapi.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.vital.moviesapi.dto.request.MovieRequest;
import br.com.vital.moviesapi.dto.response.MovieResponse;
import br.com.vital.moviesapi.exceptions.BusinessException;
import br.com.vital.moviesapi.service.MovieService;

@RestController
@RequestMapping("movies")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@ResponseBody
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> insert(@RequestBody @Valid final MovieRequest request) throws BusinessException {
		movieService.insert(request);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@RequestBody @Valid final MovieRequest request) throws BusinessException {
		movieService.update(request);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathParam("id") final Integer id) throws BusinessException {
		movieService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ResponseBody
	@GetMapping
	public ResponseEntity<List<MovieResponse>> find() {
		return new ResponseEntity<>(movieService.listAll(), HttpStatus.OK);
	}

	@ResponseBody
	@GetMapping("/{id}")
	public ResponseEntity<MovieResponse> find(@PathParam("id") final Integer id) {
		return new ResponseEntity<>(movieService.find(id), HttpStatus.OK);
	}

}
