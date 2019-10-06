package remoteFacade;

import dataMapper.ThreeDMovieMapper;
import domain.ThreeDMovie;
import domain.ThreeDMovieAssembler;
import domain.ThreeDMovieDTO;

public class ThreeDMovieServiceBean {

	public ThreeDMovieDTO getThreeDMovieDTO(int id) {
		ThreeDMovie threeDMovie = new ThreeDMovieMapper().findThreeDMovieById(id);
		ThreeDMovieDTO threeDMovieDTO = ThreeDMovieAssembler.createThreeDMovieDTO(threeDMovie);
		return threeDMovieDTO;
	}
	
	public String getThreeDMovieJson(int id) {
		ThreeDMovie threeDMovie = new ThreeDMovieMapper().findThreeDMovieById(id);
		ThreeDMovieDTO threeDMovieDTO = ThreeDMovieAssembler.createThreeDMovieDTO(threeDMovie);
		return ThreeDMovieDTO.serialize(threeDMovieDTO);
	}
	
	public boolean updateThreeDMovie(ThreeDMovieDTO threeDMovieDTO) {
		return ThreeDMovieAssembler.updateThreeDMovie(threeDMovieDTO);
	}
	
	public boolean updateThreeDMovieJson(String json) {
		ThreeDMovieDTO threeDMovieDTO = ThreeDMovieDTO.deserialize(json);
		return ThreeDMovieAssembler.updateThreeDMovie(threeDMovieDTO);
	}
	
	public boolean addThreeDMovie(ThreeDMovieDTO threeDMovieDTO) {
		return ThreeDMovieAssembler.addThreeDMovie(threeDMovieDTO);
	}
	
	public boolean addThreeDMovieJson(String json) {
		ThreeDMovieDTO threeDMovieDTO = ThreeDMovieDTO.deserialize(json);
		return ThreeDMovieAssembler.addThreeDMovie(threeDMovieDTO);
	}
	
}
