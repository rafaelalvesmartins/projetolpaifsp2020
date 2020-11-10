package models;


public class Investimento {
	private int id, quantidade;
	private String acao, dataCompra, dataVenda;
	private Carteira carteira;
	private double compradoPor, valorAtual, vendidoPor;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public String getAcao() {
		return acao;
	}


	public void setAcao(String acao) {
		this.acao = acao;
	}


	public String getDataCompra() {
		return dataCompra;
	}


	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}


	public String getDataVenda() {
		return dataVenda;
	}


	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}


	public Carteira getCarteira() {
		return carteira;
	}


	public void setCarteira(Carteira carteira) {
		this.carteira = carteira;
	}


	public double getCompradoPor() {
		return compradoPor;
	}


	public void setCompradoPor(double compradoPor) {
		this.compradoPor = compradoPor;
	}


	public double getValorAtual() {
		return valorAtual;
	}


	public void setValorAtual(double valorAtual) {
		this.valorAtual = valorAtual;
	}


	public double getVendidoPor() {
		return vendidoPor;
	}


	public void setVendidoPor(double vendidoPor) {
		this.vendidoPor = vendidoPor;
	}


	@Override
	public String toString() {
		return "Investimento [id=" + id + ", quantidade=" + quantidade + ", acao=" + acao + ", dataCompra=" + dataCompra
				+ ", dataVenda=" + dataVenda + ", carteira=" + carteira.getId() + ", compradoPor=" + compradoPor
				+ ", valorAtual=" + valorAtual + ", vendidoPor=" + vendidoPor + "]";
	}


	public String toCSV() {
		return id + ";" + quantidade + ";" + acao
				+ "; " + dataCompra + ";" + dataVenda  + ";" + carteira.getId() + ";" + compradoPor + ";"+ valorAtual + ";" + vendidoPor ;
	}
	
	
	public String[] toVetor() {
		String [] vetorString = new String[5];
		vetorString[0] = Integer.toString(id);
		vetorString[1] = Integer.toString(quantidade);
		vetorString[2] = acao;
		vetorString[3] = dataCompra;
		vetorString[4] = dataVenda;
		vetorString[5] = Integer.toString(carteira.getId());
		vetorString[6] = Double.toString(compradoPor);
		vetorString[7] = Double.toString(valorAtual);
		vetorString[8] = Double.toString(vendidoPor);
		return vetorString;
	}
	
	
	public String toHTML() {
		return "<tr><td>" + id + "</td><td>" + quantidade + "</td><td>" + acao
				+ "</td><td>" + dataCompra + "</td><td>" + dataVenda + "</td></tr>"+ "</td><td>" + carteira.getId() + "</td></tr>"
				+ "</td><td>" + compradoPor + "</td></tr>"+ "</td><td>" + valorAtual + "</td></tr>"+ "</td><td>" + vendidoPor + "</td></tr>";	
	}
	
	
	double getVenderPrejuizo() {
		return compradoPor-compradoPor*carteira.getPrejuizoMaximo();
	}
	
	double getVenderLucro() {
		return compradoPor+compradoPor*carteira.getLucroEsperado();
	}
	
	double getTotalInvestido() {
		return quantidade*compradoPor;
	}
	
	double getTotalVendido() {
		return quantidade*vendidoPor;
	}
	
	double getTotalAtual() {
		if(getTotalVendido()>0)
			return getTotalVendido();
		else
			return quantidade*valorAtual;
	}
	
	String getResultado() {
		if(getTotalVendido()>0) { // Já vendeu o ativo
			if(getTotalVendido()>getTotalInvestido())
				return "Lucro";
			else
				return "Prejuízo";
		} else { // Ainda não vendeu o ativo
			if(getTotalAtual()>getTotalInvestido())
				return "Alta";
			else
				return "Baixa";
		}
				
	}
}
