package models.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import models.Carteira;
import models.Investimento;

public class InvestimentoDAO {

	BufferedWriter bw;
	BufferedReader br;
	String arquivo = ".\\bd\\investimentos.csv";
	
	public boolean salvar(ArrayList<Investimento> investimentos) {
		
		boolean retorno = false;
		try {
			bw = new BufferedWriter(new FileWriter(arquivo,false));
			
			for(Investimento investimento: investimentos) {
				bw.write(investimento.toCSV());
			}
			
			bw.close();
			retorno = true;
		} catch (IOException e) {
			System.out.println("Erro ao salvar:"+e);
		}
		
		return retorno;
	}
	
	public ArrayList<Investimento> retornar(){
		ArrayList<Investimento> investimentos = new ArrayList<Investimento>();
		String[] campos;
		Investimento investimento;
		Carteira carteira;
		
		try {
			br = new BufferedReader(new FileReader(arquivo));
			String linha;
			
			linha = br.readLine();
			
			while(linha!=null) {
				campos = linha.split(";");
				investimento = new Investimento();
				investimento.setId(Integer.parseInt(campos[0]));
				investimento.setQuantidade(Integer.parseInt(campos[1]));
				investimento.setAcao(campos[2]);
				investimento.setDataCompra(campos[3]);
				investimento.setDataVenda(campos[4]);
				
				carteira = new Carteira();
				carteira.setId(Integer.parseInt(campos[5]));
				investimento.setCarteira(carteira);
				
				investimento.setCompradoPor(Double.parseDouble(campos[6]));
				investimento.setValorAtual(Double.parseDouble(campos[7]));
				investimento.setVendidoPor(Double.parseDouble(campos[8]));
				
				investimentos.add(investimento);
				linha = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Erro ao retornar, arquivo não encontrado:"+e);
		} catch (IOException e) {
			System.out.println("Erro ao retornar, erro na leitura da linha:"+e);
		} 
		
		return investimentos;
		
	}
	
//	 public static void main(String args[]) {
//		 InvestimentoDAO investimentoDAO = new InvestimentoDAO();
//		  ArrayList<Investimento> investimentos = investimentoDAO.retornar();
//		  
//		  System.out.println("Quantidade:"+investimentos.size());
//		  Investimento investimentoPTBR4 = investimentos.get(0);
//		  System.out.println(investimentoPTBR4.toString());
//		  Investimento investimentoAZUL4 = investimentos.get(1);
//		  System.out.println(investimentoAZUL4.toString());
		  
		  
		
		 
//		 Carteira carteiraRafael = new Carteira();
//		 carteiraRafael.setId(1);
//		 
//		 Investimento investimentoPTBR4 = new Investimento();
//		 investimentoPTBR4.setId(1);
//		 investimentoPTBR4.setAcao("PTBR4");
//		 investimentoPTBR4.setCarteira(carteiraRafael);
//		 investimentoPTBR4.setCompradoPor(20.00);
//		 investimentoPTBR4.setDataCompra("30/11/2020");
//		 investimentoPTBR4.setDataVenda("01/12/2020");
//		 investimentoPTBR4.setQuantidade(100);
//		 investimentoPTBR4.setValorAtual(21.50);
//		 investimentoPTBR4.setVendidoPor(21.49);
//		 
//		 Investimento investimentoAZUL4 = new Investimento();
//		 investimentoAZUL4.setId(2);
//		 investimentoAZUL4.setAcao("AZUL4");
//		 investimentoAZUL4.setCarteira(carteiraRafael);
//		 investimentoAZUL4.setCompradoPor(10.00);
//		 investimentoAZUL4.setDataCompra("29/11/2020");
//		 investimentoAZUL4.setDataVenda("01/12/2020");
//		 investimentoAZUL4.setQuantidade(200);
//		 investimentoAZUL4.setValorAtual(9.50);
//		 investimentoAZUL4.setVendidoPor(9.55);
//		 
//		 investimentos.add(investimentoPTBR4);
//		 investimentos.add(investimentoAZUL4);
//		 
//		 investimentoDAO.salvar(investimentos);
		 
		 
//		 
//	}

}
