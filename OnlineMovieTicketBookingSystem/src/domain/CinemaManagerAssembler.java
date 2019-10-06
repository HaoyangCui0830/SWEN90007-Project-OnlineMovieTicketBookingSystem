package domain;

import dataMapper.CinemaManagerMapper;

public class CinemaManagerAssembler {

	public static CinemaManagerDTO createCinemaManagerDTO(CinemaManager cinemaManager) {
		CinemaManagerDTO result = new CinemaManagerDTO();
		result.setCinemaManagerId(cinemaManager.getCinemaManagerId());
		result.setFirstNameString(cinemaManager.getFirstNameString());
		result.setLastNameString(cinemaManager.getLastNameString());
		return result;
	}
	
	public static boolean updateCinemaManagerDTO(CinemaManagerDTO cinemaManagerDTO) {
		CinemaManager cinemaManager = new CinemaManager();
		cinemaManager.setCinemaManagerId(cinemaManagerDTO.getCinemaManagerId());
		cinemaManager.setFirstNameString(cinemaManagerDTO.getFirstNameString());
		cinemaManager.setLastNameString(cinemaManagerDTO.getLastNameString());
		boolean result = false;
		try {
			result = new CinemaManagerMapper().update(cinemaManager);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static boolean addCinemaManagerDTO(CinemaManagerDTO cinemaManagerDTO) {
		CinemaManager cinemaManager = new CinemaManager();
		cinemaManager.setCinemaManagerId(cinemaManagerDTO.getCinemaManagerId());
		cinemaManager.setFirstNameString(cinemaManagerDTO.getFirstNameString());
		cinemaManager.setLastNameString(cinemaManagerDTO.getLastNameString());
		boolean result = false;
		try {
			result = new CinemaManagerMapper().insert(cinemaManager);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
