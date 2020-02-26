package com.enigmacamp.db.services;

import java.util.List;

import com.enigmacamp.db.entity.Murid;

public interface MuridServices {

		List<Murid> findAll();
		
		List<Murid> findLulus();
		
		List<Murid> findTidakLulus();
		
		List<Murid> deleteAll() throws Exception;
		
		Murid findById(Integer id) throws Exception;
		
		Murid delete(Integer id) throws Exception;

		Murid Create(Murid murid) throws Exception;
		
		Murid Update(Murid murid, Integer id) throws Exception;
}
