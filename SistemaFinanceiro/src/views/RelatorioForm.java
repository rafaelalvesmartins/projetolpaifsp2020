package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import controllers.ProcessaInvestimento;
import controllers.ProcessaRelatorio;
import models.Investimento;

import java.io.File;



public class RelatorioForm extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextArea areaDeTexto;
	private JScrollPane scroll; 
	private JButton jbSalvar;
	private String relatorio;
	
	RelatorioForm(){
		setTitle("Relatório de Investimento");
		setBounds(250,149,700,450);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);
		
		// Declaração dos componentes do relatório
		
		
		// Fazer o relatório
		relatorio = "\n\t\t\tRelatório de Investimento\n";
		relatorio += "\t---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
		relatorio += "\t ID \t Qtd \t Ação \t DT Compra \t DT Venda \t Carteira \t C Por \t Val At \t Ven Por \t Sub T C \t Sub T V \t Total Atual \t  Resultado \n";
		relatorio += "\t---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
		
		
		for(Investimento i: ProcessaInvestimento.getArray()) {
			relatorio += "\t" + i.getId() +"\t" + i.getQuantidade()  +"\t" + i.getAcao()+"\t" + i.getDataCompra() +"\t" + i.getDataVenda()
			+"\t" + i.getCarteira().getId()+"\t" + i.getCompradoPor()+"\t" + i.getValorAtual()+"\t" + i.getVendidoPor()
			+"\t" + i.getTotalInvestido()+"\t" + i.getTotalVendido() +"\t" + i.getTotalAtual() +"\t" + i.getResultado()+"\n";
		}
		
		relatorio += "\t---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
		relatorio += "\t\t\t\t\tTotal Comprado = " + String.format("R$ %.2f", ProcessaInvestimento.getTotalComprado()) + "\n";
		relatorio += "\t\t\t\t\tTotal Vendido = " + String.format("R$ %.2f", ProcessaInvestimento.getTotalVendido()) + "\n";
		relatorio += "\t\t\t\t\tLucro = " + String.format("R$ %.2f", ProcessaInvestimento.getLucro()) + "\n";
		relatorio += "\t---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
				
		areaDeTexto = new JTextArea(relatorio);
		
		scroll = new JScrollPane(areaDeTexto);
		scroll.setBounds(10,10,665,360);
		panel.add(scroll);
		
		jbSalvar = new JButton("Salvar");
		jbSalvar.setBounds(570,372,100,30);
		panel.add(jbSalvar);
		jbSalvar.addActionListener(this);
		
		
		
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbSalvar) {
			
			JFileChooser fc = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Selecione apenas TXT", "txt");
			fc.setFileFilter(filter);
			
			if(fc.showSaveDialog(this) != 1) {
				File arquivo = fc.getSelectedFile();
				
				if(arquivo.getPath().endsWith(".txt"))
					ProcessaRelatorio.salvarRelatorio(relatorio, arquivo.getPath());
				else
					ProcessaRelatorio.salvarRelatorio(relatorio, arquivo.getPath() + ".txt");
				
				dispose();
				
			}
			
		}
		
	}
	

}
