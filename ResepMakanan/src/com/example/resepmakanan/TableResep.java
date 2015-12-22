package com.example.resepmakanan;

public class TableResep
{
	private String kd_benua;
	private String nama;
	private String cara;
	private String resep;



	public String getkd_benua()
	{
		return kd_benua;
	}

	public void setkd_benua(String kd_benua)
	{
		this.kd_benua = kd_benua;
	}

	public String getnama()
	{
		return nama;
	}

	public void setnama(String nama)
	{
		this.nama = nama;
	}
	
	public String getResep() {
		return resep;
	}

	public void setResep(String resep) {
		this.resep = resep;
	}
	
	public String getcara()
	{
		return cara;
	}

	public void setcara(String cara)
	{
		this.cara = cara;
	}
	@Override
	public String toString()
	{
		return this.nama;
	}



}
