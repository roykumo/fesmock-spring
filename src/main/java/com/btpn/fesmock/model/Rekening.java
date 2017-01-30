package com.btpn.fesmock.model;

public class Rekening {
	private String id;
	private String nomer;
	private String nama;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNomer() {
		return nomer;
	}
	public void setNomer(String nomer) {
		this.nomer = nomer;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public Rekening(){}
	public Rekening(String id, String nomer, String nama){
		this.id = id;
		this.nomer = nomer;
		this.nama = nama;
	}
}
