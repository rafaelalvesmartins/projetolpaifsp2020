package controllers;

import java.util.ArrayList;

import models.Investimento;
import models.dao.InvestimentoDAO;



public class ProcessaInvestimento {
	private static InvestimentoDAO investimentoDAO = new InvestimentoDAO();
	private static ArrayList<Investimento> investimentos= new ArrayList<Investimento>();
	
	
	public static void setArray(ArrayList<Investimento> investimentos) {
		ProcessaInvestimento.investimentos = investimentos;
		ProcessaInvestimento.investimentoDAO.salvar(ProcessaInvestimento.investimentos);
	}
	
	public static ArrayList<Investimento> getArray(){
		ProcessaInvestimento.investimentos = ProcessaInvestimento.investimentoDAO.retornar();
		return ProcessaInvestimento.investimentos;
	}
	
	public static int getAutoId() {
		ProcessaInvestimento.investimentos = ProcessaInvestimento.investimentoDAO.retornar();
		if(ProcessaInvestimento.investimentos.isEmpty())
			return 1;
		else
			return ProcessaInvestimento.investimentos.get(ProcessaInvestimento.investimentos.size()-1).getId() + 1;
	}
	
	public static double getTotalComprado() {
		ProcessaInvestimento.investimentos = ProcessaInvestimento.investimentoDAO.retornar();
		double totalComprado = 0.0;
		for(Investimento investimento: ProcessaInvestimento.investimentos) {
			totalComprado += investimento.getCompradoPor() * investimento.getQuantidade();
		}
		return totalComprado;
	}
	
	public static double getTotalVendido() {
		ProcessaInvestimento.investimentos = ProcessaInvestimento.investimentoDAO.retornar();
		double totalVendido = 0.0;
		for(Investimento investimento: ProcessaInvestimento.investimentos) {
			totalVendido += investimento.getVendidoPor() * investimento.getQuantidade();
		}
		return totalVendido;
	}
	
	public static double getLucro() {
		return ProcessaInvestimento.getTotalVendido()-ProcessaInvestimento.getTotalComprado();
	}
	
//	public static void main(String Args[]) {
//		ArrayList<Investimento> investimentos = ProcessaInvestimento.getArray();
//		System.out.println("Quantidade:"+investimentos.size());
//		
//		Investimento investimentoPTBR4 = investimentos.get(0);
//		System.out.println(investimentoPTBR4.toString());
//		
//		Investimento investimentoAZUL4 = investimentos.get(1);
//		System.out.println(investimentoAZUL4.toString());
//		
//		System.out.println("Total Comprado:"+ProcessaInvestimento.getTotalComprado()
//							+ " | Total Vendido:"+ProcessaInvestimento.getTotalVendido()
//							+ " | Lucro:"+ProcessaInvestimento.getLucro());
//	}
}
