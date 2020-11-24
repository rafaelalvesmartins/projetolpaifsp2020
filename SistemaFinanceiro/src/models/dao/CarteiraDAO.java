package models.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import models.Carteira;

public class CarteiraDAO {

	BufferedWriter bw;
	BufferedReader br;
	String arquivo = ".\\bd\\carteiras.csv";
	
	public boolean salvar(ArrayList<Carteira> carteiras) {
		
		boolean retorno = false;
		try {
			bw = new BufferedWriter(new FileWriter(arquivo,false));
			
			for(Carteira carteira: carteiras) {
				bw.write(carteira.toCSV());
			}
			
			bw.close();
			retorno = true;
		} catch (IOException e) {
			System.out.println("Erro ao salvar:"+e);
		}
		
		return retorno;
	}
	
	public ArrayList<Carteira> retornar(){
		ArrayList<Carteira> carteiras = new ArrayList<Carteira>();
		String[] campos;
		Carteira carteira;
		
		try {
			br = new BufferedReader(new FileReader(arquivo));
			String linha;
			
				linha = br.readLine();
			
			while(linha!=null) {
				campos = linha.split(";");
				carteira = new Carteira();
				carteira.setId(Integer.parseInt(campos[0]));
				carteira.setNome(campos[1]);
				carteira.setPerfilDeInvestimento(campos[2]);
				carteira.setLucroEsperado(Double.parseDouble(campos[3]));
				carteira.setPrejuizoMaximo(Double.parseDouble(campos[4]));
				carteiras.add(carteira);
				linha = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Erro ao retornar, arquivo não encontrado:"+e);
		} catch (IOException e) {
			System.out.println("Erro ao retornar, erro na leitura da linha:"+e);
		} 
		
		return carteiras;
		
	}

}
