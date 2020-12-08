package models;

public class Carteira {
	private int id;
	private String nome, perfilDeInvestimento;
	private double lucroEsperado, prejuizoMaximo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPerfilDeInvestimento() {
		return perfilDeInvestimento;
	}
	public void setPerfilDeInvestimento(String perfilDeInvestimento) {
		this.perfilDeInvestimento = perfilDeInvestimento;
	}
	public double getLucroEsperado() {
		return lucroEsperado;
	}
	public void setLucroEsperado(double luccroEsperado) {
		this.lucroEsperado = luccroEsperado;
	}
	public double getPrejuizoMaximo() {
		return prejuizoMaximo;
	}
	public void setPrejuizoMaximo(double prejuizoMaximo) {
		this.prejuizoMaximo = prejuizoMaximo;
	}
	
	@Override
	public String toString() {
		return "Carteira [id=" + id + ", nome=" + nome + ", perfilDeInvestimento=" + perfilDeInvestimento
				+ ", luccroEsperado=" + lucroEsperado + ", prejuizoMaximo=" + prejuizoMaximo + "]";
	}
	
	public String toCSV() {
		return id + ";" + nome + ";" + perfilDeInvestimento
				+ "; " + lucroEsperado + ";" + prejuizoMaximo +"\n";
	}
	
	public String[] toVetor() {
		String [] vetorString = new String[5];
		vetorString[0] = Integer.toString(id);
		vetorString[1] = nome;
		vetorString[2] = perfilDeInvestimento;
		vetorString[3] = Double.toString(lucroEsperado);
		vetorString[4] = Double.toString(prejuizoMaximo);
		return vetorString;
	}
	
	public String toHTML() {
		return "<tr><td>" + id + "</td><td>" + nome + "</td><td>" + perfilDeInvestimento
				+ "</td><td>" + lucroEsperado + "</td><td>" + prejuizoMaximo + "</td></tr>";	
	}

}