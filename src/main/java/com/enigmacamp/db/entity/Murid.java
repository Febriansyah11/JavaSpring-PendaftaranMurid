package com.enigmacamp.db.entity;

public class Murid {

	private Integer id;

	private String nama;

	private Integer umur;

	private Integer nilaiAkhir;

	private Status status;

	public Murid() {
	}

	public Integer getId() {
		return id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Integer getUmur() {
		return umur;
	}

	public void setUmur(Integer umur) {
		this.umur = umur;
	}

	public Integer getNilaiAkhir() {
		return nilaiAkhir;
	}

	public void setNilaiAkhir(Integer nilaiAkhir) {
		this.nilaiAkhir = nilaiAkhir;
	}

}
