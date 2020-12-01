package controllers;

import models.dao.CarteiraDAO;

import java.util.ArrayList;

import models.Carteira;

public class ProcessaCarteira {
	private static CarteiraDAO carteiraDAO = new CarteiraDAO();
	private static ArrayList<Carteira> carteiras= new ArrayList<Carteira>();
	
	
	public static void setArray(ArrayList<Carteira> carteiras) {
		ProcessaCarteira.carteiras = carteiras;
		ProcessaCarteira.carteiraDAO.salvar(ProcessaCarteira.carteiras);
	}
	
	public static ArrayList<Carteira> getArray(){
		ProcessaCarteira.carteiras = ProcessaCarteira.carteiraDAO.retornar();
		return ProcessaCarteira.carteiras;
	}
	
	public static int getAutoId() {
		ProcessaCarteira.carteiras = ProcessaCarteira.carteiraDAO.retornar();
		if(ProcessaCarteira.carteiras.isEmpty())
			return 1;
		else
			return ProcessaCarteira.carteiras.get(ProcessaCarteira.carteiras.size()-1).getId() + 1;
	}
	
//	public static void main(String Args[]) {
//		ArrayList<Carteira> carteiras = ProcessaCarteira.getArray();
//		System.out.println("Quantidade:"+carteiras.size());
//		Carteira carteiraRenato = carteiras.get(0);
//		System.out.println(carteiraRenato.toString());
//		Carteira carteiraAna = carteiras.get(1);
//		System.out.println(carteiraAna.toString());
//	}
}
