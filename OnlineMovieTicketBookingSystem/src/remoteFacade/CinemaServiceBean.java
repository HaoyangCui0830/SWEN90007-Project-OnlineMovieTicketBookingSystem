package remoteFacade;

import java.util.ArrayList;
import java.util.List;
import dataMapper.MovieMapper;
import domain.Cinema;
import domain.CinemaAssembler;
import domain.CinemaDTO;

public class CinemaServiceBean {

	/**
	 * Get a List of CinemaDTO object
	 * */
	public List<CinemaDTO> getCinemaByMovieId(int id) {
		List<Cinema> cinemas = new MovieMapper().findCinemaByMovieId(id);
		List<CinemaDTO> cinemaDTOs = new ArrayList<CinemaDTO>();
		for(Cinema cinema : cinemas){
			cinemaDTOs.add(CinemaAssembler.createCinemaDTO(cinema));
		}
		return cinemaDTOs;
	}
	
	/**
	 * Get the Json of a list of Cinema object
	 * */
	public String getCinemasJson(int id) {
		List<Cinema> cinemas = new MovieMapper().findCinemaByMovieId(id);
		List<CinemaDTO> cinemaDTOs = new ArrayList<CinemaDTO>();
		String json = "";
		for(Cinema cinema : cinemas){
			cinemaDTOs.add(CinemaAssembler.createCinemaDTO(cinema));
		}
		for(CinemaDTO cinemaDTO : cinemaDTOs) {
			json += CinemaDTO.serialize(cinemaDTO);
		}
		return json;
	}
	
}
