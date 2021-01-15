package com.masiv.demo.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.masiv.demo.models.entity.Roulette;

@Repository
public interface IRouletteDao extends CrudRepository<Roulette, Integer>{

}
