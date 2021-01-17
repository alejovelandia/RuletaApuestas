package com.masiv.demo.service.implement;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.masiv.demo.models.dao.IRouletteDao;
import com.masiv.demo.models.entity.Roulette;
import com.masiv.demo.service.IRouletteService;

@Service
public class RouletteServiceImpl implements IRouletteService{
	
	private static final Logger logger = LoggerFactory.getLogger(RouletteServiceImpl.class);
	
	@Autowired
	private IRouletteDao rouletteDao;
	
	private Roulette roulette;
	
	@Value("${global.variables.maxNumberBet}")
	private String maxNumberBet;

	@Override
	public int save() {
		roulette = new Roulette(newId());
		rouletteDao.save(roulette);
		return roulette.getIdRoulette();
	}
	
	@Override
	public Roulette findById(int idRoulette) {
		return rouletteDao.findById(idRoulette);
	}
	
	@Override
	public int newId() {
		return (int) (rouletteDao.countAll() + 1);
	}

	@Override
	public boolean activate(int idRoulette) {
		
		try {
			roulette = findById(idRoulette);
			roulette.setState(true);
			rouletteDao.save(roulette);
		}catch (Exception e) {
			logger.error("Error message: " + e.getMessage());
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean validateExist(int idRoulette) {
		roulette = findById(idRoulette);
		return (roulette != null) ?  true :  false ;
	}
	
	@Override
	public int getWinerNumber() {
		double winnerNumber =  Math.random() * Integer.parseInt(maxNumberBet);
		return (int) winnerNumber;
	}

	@Override
	public List<Roulette> findAll() {
		return rouletteDao.findAll();
	}

}
