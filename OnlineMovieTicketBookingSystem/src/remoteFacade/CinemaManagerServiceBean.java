package remoteFacade;

import dataMapper.CinemaManagerMapper;
import domain.CinemaManager;
import domain.CinemaManagerAssembler;
import domain.CinemaManagerDTO;

public class CinemaManagerServiceBean {
	
	/**
	 * get CinemaManagerDTO object
	 * */
	public CinemaManagerDTO getCinemaManager(int id) {
		CinemaManager cinemaManager = new CinemaManagerMapper().findcinemaManagerById(id);
		CinemaManagerDTO cinemaManagerDTO = CinemaManagerAssembler.createCinemaManagerDTO(cinemaManager);
		return cinemaManagerDTO;
	}
	
	/**
	 * get CinemaManagerDTO Json
	 * */
	public String getCinemaManagerJson(int id) {
		CinemaManager cinemaManager = new CinemaManagerMapper().findcinemaManagerById(id);
		CinemaManagerDTO cinemaManagerDTO = CinemaManagerAssembler.createCinemaManagerDTO(cinemaManager);
		return CinemaManagerDTO.serialize(cinemaManagerDTO);
	}
	
	/**
	 * Update cinemaManager based on input CinemaManagerDTO
	 * */
	public boolean updateCinemaManager(CinemaManagerDTO CinemaManagerDTO) {
		return CinemaManagerAssembler.updateCinemaManagerDTO(CinemaManagerDTO);
	}
	
	/**
	 * Update CinemaManager based on input json
	 * */
	public boolean updateCinemaManagerJson(String json) {
		CinemaManagerDTO cinemaManagerDTO = CinemaManagerDTO.deserialize(json);
		return CinemaManagerAssembler.updateCinemaManagerDTO(cinemaManagerDTO);
	}

	/**
	 * add cinemaManager based on input CinemaManagerDTO
	 * */
	public boolean addCinemaManager(CinemaManagerDTO cinemaManagerDTO) {
		return CinemaManagerAssembler.addCinemaManagerDTO(cinemaManagerDTO);
	}
	
	/**
	 * add CinemaManager based on input json
	 * */
	public boolean addCinemaManagerJson(String json) {
		CinemaManagerDTO cinemaManagerDTO = CinemaManagerDTO.deserialize(json);
		return CinemaManagerAssembler.addCinemaManagerDTO(cinemaManagerDTO);
	}
	
}
