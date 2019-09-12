package service;

import java.util.ArrayList;
import java.util.List;

import dataMapper.CinemaManagerMapper;
import domain.CinemaManager;
import utils.IdentityMap;
import utils.UnitOfWork;

public class CinemaManagerService {

	
	private CinemaManagerMapper cinemaManagerMapper;
	
	public CinemaManagerService() {
		this.cinemaManagerMapper = new CinemaManagerMapper();
	}
	
	public List<CinemaManager> getAllCinemaManagers(){
		List<CinemaManager> cinemaManagers = new ArrayList<CinemaManager>();
		cinemaManagers = this.cinemaManagerMapper.findAllcinemaManagers();
		return cinemaManagers;
	}
	
	public CinemaManager findCinemaManagerById(int cinemaManagerId) {
		CinemaManager cinemaManager = new CinemaManager();
		cinemaManager.setCinemaManagerId(cinemaManagerId);
		IdentityMap<CinemaManager> identityMap = IdentityMap.getInstance(cinemaManager);
		CinemaManager CinemaManagerInIdentityMap = identityMap.get(cinemaManager.getCinemaManagerId());
		if(CinemaManagerInIdentityMap != null) {
			CinemaManager result = CinemaManagerInIdentityMap;
			return result;
		}
		else {
			return cinemaManagerMapper.findcinemaManagerById(cinemaManagerId);
		}
	}
	
	public void insertCinemaManager(CinemaManager CinemaManager) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(CinemaManager);
		UnitOfWork.getCurrent().commit();
	}
	
	public void deleteCinemaManager(CinemaManager CinemaManager) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(CinemaManager);
		UnitOfWork.getCurrent().commit();
	}
	
	public void updateCinemaManager(CinemaManager CinemaManager) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty(CinemaManager);
		UnitOfWork.getCurrent().commit();
	}
}
