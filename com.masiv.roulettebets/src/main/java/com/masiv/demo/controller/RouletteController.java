package com.masiv.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masiv.demo.models.entity.Bet;
import com.masiv.demo.service.IBetService;
import com.masiv.demo.service.IRouletteService;

@RestController
@RequestMapping("/roulette")
public class RouletteController {
	
	@Autowired
	IRouletteService rouletteService;
	
	@Autowired
	IBetService betService;
	
	Map<String, Object> response;
	
	@GetMapping("/create")
	public int create() {
		return rouletteService.save();
	}
	
	@GetMapping("/activate")
	public boolean activate(@RequestParam(value = "id_roulette", required = true) final int id_roulette) {
		return rouletteService.activate(id_roulette);
	}
	
	@GetMapping("/close")
	public ResponseEntity<?> close(@RequestParam(value = "id_roulette", required = true) final int id_roulette) {
		
		response = new HashMap();
		validateExistRoulette(id_roulette);
		if(response.size() > 0) {
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		findBetByRouletteWithWinner(id_roulette);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
	private void validateExistRoulette(int id_roulette) {
		if(!rouletteService.validateExist(id_roulette)) {
			response.put("message", "Debe ingresar un id de ruleta existente");
			return;
		}
	}
	
	private void findBetByRouletteWithWinner(int id_roulette) {
		int winnerNumber = rouletteService.getWinerNumber();
		List<Bet> listBet = betService.findByRouletteWithWinners(id_roulette, winnerNumber);
		response.put("winnerNumber", winnerNumber);
		response.put("listBet", listBet);
	}
}
