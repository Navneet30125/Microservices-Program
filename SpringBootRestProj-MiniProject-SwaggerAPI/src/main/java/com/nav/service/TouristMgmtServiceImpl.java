package com.nav.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nav.entity.Tourist;
import com.nav.repo.ITouristRepo;

@Service("touristService")
public class TouristMgmtServiceImpl implements ITouristMgmtService {

	@Autowired
	private ITouristRepo touristRepo;

	@Override
	public String registerTourist(Tourist tourist) {
		int idVal = touristRepo.save(tourist).getId();
		return "Tourist is registered having the id value::" + idVal;
	}

	@Override
	public List<Tourist> fetchAllTourist() {
		List<Tourist> list = touristRepo.findAll();
		list.sort((t1, t2) -> t1.getId().compareTo(t2.getId()));
		return list;
	}

	@Override
	public Tourist fetchTouristById(int tid) throws Exception {
		return touristRepo.findById(tid).orElseThrow(() -> new Exception(tid + " tourist not found"));
	}

	@Override
	public String updateTouristDetails(Tourist tourist) throws Exception {
		Optional<Tourist> optional = touristRepo.findById(tourist.getId());
		if (optional.isPresent()) {
			touristRepo.save(tourist);
			return tourist.getId() + " Tourist is Updated...";
		}
		throw new Exception(tourist.getId() + " Tourist is not found..");
	}

	@Override
	public List<Tourist> findAllTouristDetailsByName(String name) {
		return touristRepo.getTouristByName(name);
	}

	@Override
	public String updateBudgetById(int tid, double hikePercentage) throws Exception {
		Optional<Tourist> optional = touristRepo.findById(tid);
		if (optional.isPresent()) {
			Tourist tourist = optional.get();
			Double budget = tourist.getBudget();
			double newBudget = budget + (budget * hikePercentage / 100.0);
			tourist.setBudget(newBudget);
			touristRepo.save(tourist);
			return "Tourist budget is hiked and new budget is " + newBudget;
		}
		throw new Exception(tid + " tid tourist is not found for updation");

	}

	@Override
	public String removeTouristById(int tid) throws Exception {
		Optional<Tourist> opt = touristRepo.findById(tid);
		if (opt.isPresent()) {
			touristRepo.deleteById(tid);
			return tid + " tid Tourist found and deleted.,,.";
		}
		throw new Exception(tid + " tid is not found......");
	}
}
