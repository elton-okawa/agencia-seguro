package model;

public class Presta {
	private PrestadorServico prestadorServico;
	private Servico servico;
	private float valor;
	
	public PrestadorServico getPrestadorServico() {
		return prestadorServico;
	}
	public void setPrestadorServico(PrestadorServico prestadorServico) {
		this.prestadorServico = prestadorServico;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
}
