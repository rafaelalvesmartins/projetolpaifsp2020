package views;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.ProcessaCarteira;
import models.Carteira;

public class CarteiraForm extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private  JLabel lbCabecalho;
	private  JTextField tfId, tfNome, tfPerfilInvestimento, tfLucroEsperado, tfPrejuizoMaximo;
	private JTable table;
	private JScrollPane scroll;
	private DefaultTableModel tableModel;
	private JButton jbAdd, jbDel, jbCancelar, jbSalvar;
	private Carteira carteira;
	private int id;


	CarteiraForm(){
		// Adicionar novo ID no textfield
		id = ProcessaCarteira.getAutoId();
		
		// Definições da Janela
		setTitle("Cadastro de Carteira");
		setBounds(250,160,597,410);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);

		// Criando o label
		lbCabecalho = new JLabel("ID \s\s\s\s\s\s\s  Nome	\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s\s	Perfil de Investimento	\s\s\s\s\s\s\sLucro Esp.	\s\s\s\s\s\s\s	Prejuízo Máximo");
		lbCabecalho.setBounds(10,10,580,20);
		panel.add(lbCabecalho);

		// Criando TextField
		tfId = new JTextField();
		tfId.setEnabled(false);
		tfId.setBounds(10,30,40,25);
		tfId.setText(String.format("%d", id));
		panel.add(tfId);

		tfNome = new JTextField();
		tfNome.setBounds(50,30,150,25);
		panel.add(tfNome);

		tfPerfilInvestimento = new JTextField();
		tfPerfilInvestimento.setBounds(200,30,150,25);
		panel.add(tfPerfilInvestimento);

		tfLucroEsperado = new JTextField();
		tfLucroEsperado.setBounds(350,30,80,25);
		panel.add(tfLucroEsperado);

		tfPrejuizoMaximo = new JTextField();
		tfPrejuizoMaximo.setBounds(430,30,70,25);
		panel.add(tfPrejuizoMaximo);

		// Criando Tabela
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Id");
		tableModel.addColumn("Nome");
		tableModel.addColumn("Perfil de Investimento");
		tableModel.addColumn("Lucro Esperado");
		tableModel.addColumn("Prejuízo Máximo");

		table = new JTable(tableModel);
		scroll = new JScrollPane(table);
		scroll.setBounds(10,55,559,275);
		panel.add(scroll);

		// Criar os botões
		jbAdd = new JButton("Add");
		jbAdd.setBounds(500,30,68,25);
		jbAdd.addActionListener(this);
		panel.add(jbAdd);


		jbDel = new JButton("Del");
		jbDel.setBounds(278,330,59,30);
		jbDel.addActionListener(this);
		panel.add(jbDel);

		jbCancelar = new JButton("Cancelar");
		jbCancelar.setBounds(328,330,120,30);
		jbCancelar.addActionListener(this);
		panel.add(jbCancelar);

		jbSalvar = new JButton("Salvar");
		jbSalvar.setBounds(448,330,120,30);
		jbSalvar.addActionListener(this);
		panel.add(jbSalvar);
		
		
		
		// Adicionar as informações do BD na view do usuário
		if(!ProcessaCarteira.getArray().isEmpty()) {// Verifica se o BD não está vazio
			for(Carteira c : ProcessaCarteira.getArray() ) {
				tableModel.addRow(c.toVetor());
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbAdd) { // Adicionar informações na tabela
			if(!tfNome.getText().isEmpty() 
					&& !tfPerfilInvestimento.getText().isEmpty() 
					&& !tfLucroEsperado.getText().isEmpty() 
					&& !tfPrejuizoMaximo.getText().isEmpty()) {// Avaliar se todos os campos foram inseridos
					
				// Utiliza a Classe Carteira DAO para inserir os dados na tabela
				carteira = new Carteira();
				carteira.setId(id);
				carteira.setNome(tfNome.getText());
				carteira.setPerfilDeInvestimento(tfPerfilInvestimento.getText());
				carteira.setLucroEsperado(Double.parseDouble(tfLucroEsperado.getText()));
				carteira.setPrejuizoMaximo(Double.parseDouble(tfPrejuizoMaximo.getText()));
				tableModel.addRow(carteira.toVetor());
				
				//Limpar os campos text field
				id++;
				tfId.setText(String.format("%d", id));
				tfNome.setText("");
				tfPerfilInvestimento.setText("");
				tfLucroEsperado.setText("");
				tfPrejuizoMaximo.setText("");
			}
			
			
		} else if (e.getSource() == jbDel) { // Ao clicar no botão deletar
			if(table.getSelectedRow()>=0) {
				tableModel.removeRow(table.getSelectedRow());
			}else {
				JOptionPane.showInternalMessageDialog(null, "Selecione uma linha para remover.");
			}
						
		} else if (e.getSource() == jbCancelar) { // Ao clicar no botão Cancelar
			dispose();			
		} else if (e.getSource() == jbSalvar) { // Ao clicar no botão salvar
			ArrayList<Carteira> carteiras = new ArrayList<>();
			
			
			for (int i=0;i<tableModel.getRowCount();i++) {
				carteira = new Carteira();
				carteira.setId(Integer.parseInt((String)tableModel.getValueAt(i,0)));
				carteira.setNome((String)tableModel.getValueAt(i, 1));
				carteira.setPerfilDeInvestimento((String)tableModel.getValueAt(i, 2));
				carteira.setLucroEsperado(Double.parseDouble((String)tableModel.getValueAt(i, 3)));
				carteira.setPrejuizoMaximo(Double.parseDouble((String)tableModel.getValueAt(i, 4)));
				carteiras.add(carteira);
				
			}
			
			
			ProcessaCarteira.setArray(carteiras);
			JOptionPane.showMessageDialog(null,"Carteiras salvo com sucesso!");
			dispose();
			
			
			
		}
	}

}