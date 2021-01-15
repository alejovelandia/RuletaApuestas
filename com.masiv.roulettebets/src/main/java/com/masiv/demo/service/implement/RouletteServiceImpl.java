package com.masiv.demo.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masiv.demo.models.dao.IRouletteDao;
import com.masiv.demo.models.entity.Roulette;
import com.masiv.demo.service.IRouletteService;

@Service
public class RouletteServiceImpl implements IRouletteService{
	
	@Autowired
	private IRouletteDao rouletteDao;
	
	private Roulette roulette;

	@Override
	public int save() {
		roulette = new Roulette();
		rouletteDao.save(roulette);
		return roulette.getIdRoulette();
	}

	@Override
	public boolean activate(int idRoulette) {
		
		try {
			roulette = rouletteDao.findById(idRoulette).get();
			roulette.setState(true);
			rouletteDao.save(roulette);
		}catch (Exception e) {
			return false;
		}
		
		return true;
	}
	

}
