package com.btpn.fesmock.model;

public class Transfer {
	private Rekening sumber;
	private Rekening tujuan;
	private int nilai;
	private String berita;
	
	
	public Rekening getSumber() {
		return sumber;
	}
	public void setSumber(Rekening sumber) {
		this.sumber = sumber;
	}
	public Rekening getTujuan() {
		return tujuan;
	}
	public void setTujuan(Rekening tujuan) {
		this.tujuan = tujuan;
	}
	public int getNilai() {
		return nilai;
	}
	public void setNilai(int nilai) {
		this.nilai = nilai;
	}
	public String getBerita() {
		return berita;
	}
	public void setBerita(String berita) {
		this.berita = berita;
	}
	
	public Transfer(){}
	public Transfer(Rekening sumber, Rekening tujuan, int nilai, String berita){
		this.sumber = sumber;
		this.tujuan = tujuan;
		this.nilai = nilai;
		this.berita = berita;
	}
	
}
