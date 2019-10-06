package remoteFacade;

import dataMapper.ThreeDMovieMapper;
import domain.ThreeDMovie;
import domain.ThreeDMovieAssembler;
import domain.ThreeDMovieDTO;

public class ThreeDMovieServiceBean {

	/**
	 * Get ThreeDMovieDTO object
	 * */
	public ThreeDMovieDTO getThreeDMovieDTO(int id) {
		ThreeDMovie threeDMovie = new ThreeDMovieMapper().findThreeDMovieById(id);
		ThreeDMovieDTO threeDMovieDTO = ThreeDMovieAssembler.createThreeDMovieDTO(threeDMovie);
		return threeDMovieDTO;
	}
	
	/**
	 * Get ThreeDMovie Json
	 * */
	public String getThreeDMovieJson(int id) {
		ThreeDMovie threeDMovie = new ThreeDMovieMapper().findThreeDMovieById(id);
		ThreeDMovieDTO threeDMovieDTO = ThreeDMovieAssembler.createThreeDMovieDTO(threeDMovie);
		return ThreeDMovieDTO.serialize(threeDMovieDTO);
	}
	
	/**
	 * update ThreeDMovie based on input DTO
	 * */
	public boolean updateThreeDMovie(ThreeDMovieDTO threeDMovieDTO) {
		return ThreeDMovieAssembler.updateThreeDMovie(threeDMovieDTO);
	}
	
	
	/**
	 * update ThreeDMovie based on input Json
	 * */
	public boolean updateThreeDMovieJson(String json) {
		ThreeDMovieDTO threeDMovieDTO = ThreeDMovieDTO.deserialize(json);
		return ThreeDMovieAssembler.updateThreeDMovie(threeDMovieDTO);
	}

	/**
	 * add ThreeDMovie based on input DTO
	 * */
	public boolean addThreeDMovie(ThreeDMovieDTO threeDMovieDTO) {
		return ThreeDMovieAssembler.addThreeDMovie(threeDMovieDTO);
	}

	/**
	 * add ThreeDMovie based on input Json
	 * */
	public boolean addThreeDMovieJson(String json) {
		ThreeDMovieDTO threeDMovieDTO = ThreeDMovieDTO.deserialize(json);
		return ThreeDMovieAssembler.addThreeDMovie(threeDMovieDTO);
	}
	
}
