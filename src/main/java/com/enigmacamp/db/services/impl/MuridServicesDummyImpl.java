package com.enigmacamp.db.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.util.StringUtils;

import com.enigmacamp.db.entity.Murid;
import com.enigmacamp.db.entity.Status;
import com.enigmacamp.db.services.MuridServices;

public class MuridServicesDummyImpl implements MuridServices {
	private List<Murid> pendaftar = new ArrayList<Murid>();
	private List<Murid> diterima = new ArrayList<Murid>();
	private List<Murid> ditolak = new ArrayList<Murid>();

	@Override
	public List<Murid> findAll() {
		return this.pendaftar;
	}

	public List<Murid> findLulus() {
		return this.diterima;
	}

	public List<Murid> findTidakLulus() {
		return this.ditolak;
	}

	@Override
	public Murid findById(Integer id) throws Exception {
		if (pendaftar.isEmpty()) {
			throw new Exception("Eror 404 List Empty");
		} else {

			for (int i = 0; i < pendaftar.size(); i++) {
				Murid index = pendaftar.get(i);
				if (index.getId() == id) {
					return index;
				}
			}
		}
		throw new Exception("Eror 404 Id Not Found");
	}

	@Override
	public Murid delete(Integer id) throws Exception {
		Murid edit = findById(id);
		if (edit.getId() == id) {
			pendaftar.remove(edit);
		} else {
			throw new Exception("404 Id Not Found");
		}
		return edit;
	}
	

	@Override
	public Murid Create(Murid murid) throws Exception {
		Murid baru = new Murid();
		Integer id = 1;

		for (Murid data : pendaftar) {
			if (data.getId() == id) {
				id++;
			}
		}
		baru.setId(id);

		String regex = "[=/*/+/-/(/)/0-9]*";
		if (StringUtils.isEmpty(murid.getNama().matches(regex))) {
			throw new Exception("404 Masukkan Nama Yang Valid");
		}baru.setNama(murid.getNama().trim());
		

		if (murid.getUmur() <= 0 || murid.getUmur() == null) {
			throw new Exception("Masukkan Umur Yang Valid");
		}baru.setUmur(murid.getUmur());
		

		baru.setNilaiAkhir(murid.getNilaiAkhir());
		if (baru.getNilaiAkhir() < 0 || baru.getNilaiAkhir() > 100) {
			throw new Exception("Masukkan Nilai Yang Valid");
		}

		if (baru.getNilaiAkhir() >= 75) {
			baru.setStatus(Status.DiTerima);
			this.diterima.add(baru);

		} else {
			baru.setStatus(Status.DiTolak);
			this.ditolak.add(baru);
		}
		this.pendaftar.add(baru);
		return baru;
	}

	@Override
	public Murid Update(Murid murid, Integer id) throws Exception {
		Murid edit = findById(id);

		if (edit.getId() == id) {
			Integer data = pendaftar.indexOf(edit);

			String regex = "[=/*/+/-/(/)/0-9]*";
			if (murid.getNama().trim().matches(regex)) {
				throw new Exception("404 Masukkan Nama Yang Valid");
			}murid.setNama(murid.getNama().trim());
			
			
			if (murid.getUmur() <= 0 || murid.getUmur() == null) {
				throw new Exception("Umur Tidak Boleh Null");
			}edit.setUmur(murid.getUmur());

			
			if (murid.getNilaiAkhir() < 0 || murid.getNilaiAkhir() > 100) {
				throw new Exception("Masukkan Nilai Yang Valid");
			}edit.setNilaiAkhir(murid.getNilaiAkhir());

			if (edit.getNilaiAkhir() >= 75) {
				edit.setStatus(Status.DiTerima);
				this.diterima.set(data, edit);

			} else {
				edit.setStatus(Status.DiTolak);
				this.ditolak.set(data, edit);
			}
			this.pendaftar.set(data, edit);
		}
		return edit;
	}

	@Override
	public List<Murid> deleteAll() throws Exception {
		if(pendaftar.isEmpty()) {
			throw new Exception("404 Not Found");
		}
		pendaftar.removeAll(pendaftar);
		diterima.removeAll(diterima);
		ditolak.removeAll(ditolak);
		
		return this.pendaftar;
	}

}
