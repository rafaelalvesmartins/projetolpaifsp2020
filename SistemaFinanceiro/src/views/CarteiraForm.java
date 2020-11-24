package views;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CarteiraForm extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private  JLabel lbCabecalho;
	private  JTextField tfId, tfNome, tfPerfilInvestimento, tfLucroEsperado, tfPrejuizoMaximo;
	private JTable table;
	private JScrollPane scroll;
	private DefaultTableModel tableModel;
	private JButton jbAdd, jbDel, jbCancelar, jbSalvar;


	CarteiraForm(){
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

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbAdd) {
			System.out.println("Add");
		} else if (e.getSource() == jbDel) {
			System.out.println("Del");
		} else if (e.getSource() == jbCancelar) {
			System.out.println("Cancelar");
		} else if (e.getSource() == jbSalvar) {
			System.out.println("Salvar");
		}
	}

}