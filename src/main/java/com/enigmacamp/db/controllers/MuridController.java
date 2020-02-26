package com.enigmacamp.db.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enigmacamp.db.entity.Murid;
import com.enigmacamp.db.entity.Status;
import com.enigmacamp.db.services.MuridServices;

@RestController
@RequestMapping("/murid")
public class MuridController {
	
	
	@Autowired
	MuridServices muridServices;
	
	@GetMapping("")
	public List<Murid> findAll() {
		return muridServices.findAll();
	}
	
	@GetMapping("/lulus")
	public List<Murid> findLulus() {
		return muridServices.findLulus();
	}

	@GetMapping("/tidaklulus")
	public List<Murid> findTidakLulus() {
		return muridServices.findTidakLulus();
	}

	@GetMapping("{id}")
	public Murid findById(@PathVariable Integer id) throws Exception {
		return muridServices.findById(id);
	}
	
	@PostMapping("")
	public Murid Create(@RequestBody Murid murid) throws Exception {
		return muridServices.Create(murid);
	}
	
	@PutMapping("{id}")
	public Murid Update(@RequestBody Murid murid, @PathVariable Integer id) throws Exception {
		return muridServices.Update(murid, id);
	}
	
	@DeleteMapping("{id}")
	public Murid delete(@PathVariable Integer id) throws Exception {
		return muridServices.delete(id);
	}
	
	@DeleteMapping("")
	public List<Murid> deleteAll() throws Exception {
		return muridServices.deleteAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
//
//	@GetMapping(value = "")
//	public List<Murid> list() {
//		return this.pendaftar;
//	}
//
//	@GetMapping(value = "/lulus")
//	public List<Murid> listDiterima() {
//		return this.diterima;
//	}
//
//	@GetMapping(value = "/tidaklulus")
//	public List<Murid> listDitolak() {
//		return this.ditolak;
//	}
//
//
//	@GetMapping(value = "{id}")
//	public Murid findById(@PathVariable Integer id) {
//		return null;
//		
//	}
//	@DeleteMapping(value = "{id}")
//	public Murid delete(@PathVariable Integer id) throws Exception {

//		boolean y = pendaftar.removeIf(pendaftar -> pendaftar.equals(id));
//		if (!y) {
//			throw new Exception("Eror 404 Not Found");
//			
//		}
		

//	@PostMapping(value = "")
//	public Murid daftar(@RequestBody Murid daftar) {
		
//Integer id = 1;
//for (int i = 0; i < pendaftar.size(); i++) {
//	if(id == pendaftar.get(i)) {
//		
//	}
//}
		

//	@PutMapping(value = "{id}")
//	public Murid edit(@RequestBody Murid edit, @PathVariable Integer id) {
//
//		for (Murid baru : find(id)) {
//			if (baru.getId() == id) {
//				Integer data = pendaftar.indexOf(baru);
//				baru.setNama(edit.getNama());
//				baru.setUmur(edit.getUmur());
//				baru.setNilaiAkhir(edit.getNilaiAkhir());
//				if (baru.getNilaiAkhir() >= 75) {
//					baru.setStatus(Status.DiTerima);
//					this.diterima.add(baru);
//				} else {
//					baru.setStatus(Status.DiTolak);
//					this.ditolak.add(baru);
//				}
//				this.pendaftar.set(data, baru);
//			}
//		}
//		return edit;
//	}