package model;

import java.sql.Date;

public class Cliente extends Pessoa{
	private int idCliente;
	private Date dataPrimeiraCompra;
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public Date getDataPrimeiraCompra() {
		return dataPrimeiraCompra;
	}
	public void setDataPrimeiraCompra(Date dataPrimeiraCompra) {
		this.dataPrimeiraCompra = dataPrimeiraCompra;
	}
}
