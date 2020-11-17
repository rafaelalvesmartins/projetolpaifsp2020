package views;

import models.Carteira;
import models.Investimento;

public class Testadora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Carteira carteira = new Carteira();
		carteira.setId(1);
		carteira.setLucroEsperado(1000.00);
		carteira.setNome("Rafael Alves");
		carteira.setPerfilDeInvestimento("Moderado");
		carteira.setPrejuizoMaximo(200.00);
//		System.out.println("CSV: "+carteira.toCSV());
//		System.out.println("HTML: "+carteira.toHTML());
//		System.out.println("String: "+carteira.toString());
		
		
		Investimento investimento = new Investimento();
		investimento.setAcao("PETR4");
		investimento.setCarteira(carteira);
		investimento.setCompradoPor(23.93);
		investimento.setDataCompra("17/11/2020");
		investimento.setDataVenda("17/11/2020");
		investimento.setId(1);
		investimento.setQuantidade(100);
		investimento.setValorAtual(23.94);
		investimento.setVendidoPor(23.94);
		
		System.out.println("CSV: "+investimento.toCSV());
		System.out.println("HTML: "+investimento.toHTML());
		System.out.println("String: "+investimento.toString());
		
	}

}
