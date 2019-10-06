package remoteFacade;

import dataMapper.CinemaManagerMapper;
import domain.CinemaManager;
import domain.CinemaManagerAssembler;
import domain.CinemaManagerDTO;

public class CinemaManagerServiceBean {

	public CinemaManagerDTO getCinemaManager(int id) {
		CinemaManager cinemaManager = new CinemaManagerMapper().findcinemaManagerById(id);
		CinemaManagerDTO cinemaManagerDTO = CinemaManagerAssembler.createCinemaManagerDTO(cinemaManager);
		return cinemaManagerDTO;
	}
	
	public String getCinemaManagerJson(int id) {
		CinemaManager cinemaManager = new CinemaManagerMapper().findcinemaManagerById(id);
		CinemaManagerDTO cinemaManagerDTO = CinemaManagerAssembler.createCinemaManagerDTO(cinemaManager);
		return CinemaManagerDTO.serialize(cinemaManagerDTO);
	}
	
	public boolean updateCinemaManager(CinemaManagerDTO CinemaManagerDTO) {
		return CinemaManagerAssembler.updateCinemaManagerDTO(CinemaManagerDTO);
	}
	
	public boolean updateCinemaManagerJson(String json) {
		CinemaManagerDTO cinemaManagerDTO = CinemaManagerDTO.deserialize(json);
		return CinemaManagerAssembler.updateCinemaManagerDTO(cinemaManagerDTO);
	}
	
	public boolean addCinemaManager(CinemaManagerDTO cinemaManagerDTO) {
		return CinemaManagerAssembler.addCinemaManagerDTO(cinemaManagerDTO);
	}
	
	public boolean addCinemaManagerJson(String json) {
		CinemaManagerDTO cinemaManagerDTO = CinemaManagerDTO.deserialize(json);
		return CinemaManagerAssembler.addCinemaManagerDTO(cinemaManagerDTO);
	}
	
}
