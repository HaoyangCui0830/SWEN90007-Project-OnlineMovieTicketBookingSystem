package domain;

import dataMapper.CinemaMapper;

public class CinemaAssembler {
	
	public static CinemaDTO createCinemaDTO(Cinema cinema) {
		CinemaDTO result = new CinemaDTO();
		result.setCinemaId(cinema.getCinemaId());
		result.setAddress(cinema.getAddress());
		result.setName(cinema.getName());
		return result;
	}
	
	public static boolean updateCinema(CinemaDTO cinemaDTO) {
		Cinema cinema = new Cinema();
		cinema.setCinemaId(cinemaDTO.getCinemaId());
		cinema.setAddress(cinemaDTO.getAddress());
		cinema.setName(cinemaDTO.getName());
		boolean result = false;
		try {
			result = new CinemaMapper().update(cinema);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static boolean addCinema(CinemaDTO cinemaDTO) {
		Cinema cinema = new Cinema();
		cinema.setCinemaId(cinemaDTO.getCinemaId());
		cinema.setAddress(cinemaDTO.getAddress());
		cinema.setName(cinemaDTO.getName());
		boolean result = false;
		try {
			result = new CinemaMapper().insert(cinema);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
