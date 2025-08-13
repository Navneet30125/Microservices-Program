package com.nav.service;

import java.util.List;

import com.nav.entity.Tourist;

public interface ITouristMgmtService {
	public String registerTourist(Tourist tourist);
	public List<Tourist> fetchAllTourist();
	public Tourist fetchTouristById(int tid) throws Exception;
	public String updateTouristDetails(Tourist tourist) throws Exception;
	public List<Tourist> findAllTouristDetailsByName(String name);
	public String updateBudgetById(int tid, double hikePercentage) throws Exception;
	public String removeTouristById(int tid ) throws Exception;

}
