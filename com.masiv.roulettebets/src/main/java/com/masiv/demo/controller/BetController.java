package com.masiv.demo.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masiv.demo.models.entity.Bet;
import com.masiv.demo.models.entity.Roulette;
import com.masiv.demo.models.enumerable.ColorEnum;
import com.masiv.demo.service.implement.BetServiceImpl;
import com.masiv.demo.service.implement.RouletteServiceImpl;

@Validated
@RestController
@RequestMapping("/bet")
public class BetController {

	@Autowired
	BetServiceImpl betService;

	@Autowired
	RouletteServiceImpl rouletteService;
	
	Map<String, Object> response;

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestParam(value = "id_roulette", required = true) final int id_roulette,
							@RequestParam(value = "number", required = false) @Min(0) @Max(36) final Integer number, 
							@RequestParam(value = "color", required = false) final String color,
							@RequestParam(value = "amount", required = true) @Max(10000) final BigDecimal amount,
							@RequestHeader(name = "IdUser", required = true) final int id_user) {

		Bet bet = new Bet(id_roulette,number,color,amount, id_user);
		validateCreate(bet);
		if(response.size() > 0) {
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		betService.save(bet);
		return new ResponseEntity<String>("Apuesta guardada",HttpStatus.OK);
	}

	private void validateCreate(Bet bet) {

		response = new HashMap<>();

		if (!(bet.getNumber() != null || bet.getColor() != null)) {
			response.put("message", "Debe realizar solo una apuesta ya sea por número o por color");
			 return;
		}
		if (!rouletteService.validateExist(bet.getFkIdRoulette())) {
			response.put("message", "Id de ruleta no existente");
			 return;
		}
		;
		Roulette roulette = rouletteService.findById(bet.getFkIdRoulette());
		if (!roulette.isState()) {
			response.put("message", "La ruleta debe encontrarse activa");
			 return;
		}
		;
		if (bet.getColor() != null && !validateColor(bet.getColor())) {
			response.put("message", "el color solo puede ser ROJO o NEGRO");
			 return;
		}
		 return;
		 
	}

	private boolean validateColor(String color) {

		for (ColorEnum c : ColorEnum.values()) {
			if (c.name().equals(color)) {
				return true;
			}
		}
		return false;

	}

}
