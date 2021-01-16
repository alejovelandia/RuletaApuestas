package com.masiv.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masiv.demo.service.IRouletteService;

@RestController
@RequestMapping("/roulette")
public class RouletteController {
	
	@Autowired
	IRouletteService rouletteService;
	
	@GetMapping("/create")
	public int create() {
		return rouletteService.save();
	}
	
	@GetMapping("/activate")
	public boolean activate(@PathVariable("id_roulette") final int id_roulette) {
		return rouletteService.activate(id_roulette);
	}
	
	
	
}
