package com.masiv.demo.service.implement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.masiv.demo.models.dao.implement.BetDaoImpl;
import com.masiv.demo.models.entity.Bet;
import com.masiv.demo.models.enumerable.ColorEnum;
import com.masiv.demo.service.IBetService;

@Service
public class BetServiceImpl implements IBetService{

	@Autowired
	private BetDaoImpl betDao;
	
	@Value("${global.variables.numberReward}")
	private String numberReward;
	
	@Value("${global.variables.colorReward}")
	private String colorReward;
	
	@Override
	public int save(Bet bet) {
		bet.setIdBet(newId() );
		betDao.save(bet);
		return bet.getIdBet();
	}
	
	@Override
	public int newId() {
		return (int)betDao.countAll() + 1;
	}

	@Override
	public List<Bet> findByRouletteWithWinners(int idRoulette, int winnerNumber) {
		
		
		List<Bet> listBet = findByIdRoulette(idRoulette);
		boolean par = (winnerNumber % 2 == 0);
		
		for(Bet b : listBet) {
			if(b.getNumber() != null && b.getNumber() == winnerNumber) {
				b.setWinState(true);
				b.setWinAmount(b.getAmountBet().multiply(new BigDecimal(numberReward)));
			}
			if(b.getColor() != null) {
				if(validateParByColor(b.getColor()) && par) {
					b.setWinState(true);
					b.setWinAmount(b.getAmountBet().multiply(new BigDecimal(colorReward)));
				}
			}
		}
		return listBet;
	}
	
	private boolean validateParByColor(String color) {

		for (ColorEnum c : ColorEnum.values()) {
			if (c.name().equals(color)) {
				return c.isPar();
			}
		}
		return false;

	}
	
	private List<Bet> findByIdRoulette(int idRoulette){
		List<Bet> listMatches = new ArrayList<>();
		List<Bet> listBet = betDao.findAll(idRoulette);
		for(Bet b : listBet) {
			if(b.getFkIdRoulette() == idRoulette) {
				listMatches.add(b);
			}
		}
		return listMatches;
	}

}
