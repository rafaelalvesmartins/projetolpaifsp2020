package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.ProcessaCarteira;
import controllers.ProcessaInvestimento;
import models.Carteira;
import models.Investimento;

public class InvestimentoForm extends JDialog implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lbCabecalho, lbTotalComprado, lbTotalVendido, lbDiferenca;
	private JTextField tfId, tfQuantidade, tfAcao, tfDataCompra, tfDataVenda, tfCompradoPor, tfValorAtual, tfVendidoPor, tfTotalComprado, tfTotalVendido, tfDiferenca;
	private JComboBox<String> cbCarteira;
	private JTable table;
	private JScrollPane scroll;
	private DefaultTableModel tableModel;
	private JButton jbAdd, jbDel, jbCancelar, jbSalvar;
	private Investimento investimento;
	private Carteira carteira;
	private int id;
	


	InvestimentoForm(){
		// Adicionar novo ID no textfield
		id = ProcessaInvestimento.getAutoId();
				
				
		// Definições da Janela
		setTitle("Cadastro de Investimento");
		setBounds(250,160,597,410);
		panel = new JPanel();
		setContentPane(panel);
		setLayout(null);

		// Criando o label
		lbCabecalho = new JLabel("ID \s\s\s\s\s\s\s  Qtd	\s	Ação	\s\s\s\s\s\s\s\s\sDT Compra\s\s\s\s	DT Venda\s\s\s\s\s\s\s\s\sCarteira\s\s\s\s\s\s\s\s\s\s\s\s\sC Por \s\s\s\s Val At \s\s\s Ven Por");
		lbCabecalho.setBounds(10,10,580,20);
		panel.add(lbCabecalho);

		// Criando TextField
		tfId = new JTextField();
		tfId.setBounds(10,30,40,25);
		tfId.setEnabled(false);
		tfId.setText(String.format("%d", id));
		panel.add(tfId);

		tfQuantidade = new JTextField();
		tfQuantidade.setBounds(50,30,30,25);
		panel.add(tfQuantidade);

		tfAcao = new JTextField();
		tfAcao.setBounds(80,30,50,25);
		panel.add(tfAcao);

		tfDataCompra = new JTextField();
		tfDataCompra.setBounds(130,30,80,25);
		panel.add(tfDataCompra);

		tfDataVenda = new JTextField();
		tfDataVenda.setBounds(210,30,80,25);
		panel.add(tfDataVenda);
		
		cbCarteira = new JComboBox<String>();
		cbCarteira.setBounds(290,30,100,25);
		panel.add(cbCarteira);
		
		tfCompradoPor = new JTextField();
		tfCompradoPor.setBounds(390,30,40,25);
		panel.add(tfCompradoPor);
		
		tfValorAtual = new JTextField();
		tfValorAtual.setBounds(430,30,40,25);
		panel.add(tfValorAtual);
		
		tfVendidoPor = new JTextField();
		tfVendidoPor.setBounds(470,30,40,25);
		panel.add(tfVendidoPor);

		// Criando Tabela
		tableModel = new DefaultTableModel();
		tableModel.addColumn("ID");
		tableModel.addColumn("Qtd");
		tableModel.addColumn("Ação");
		tableModel.addColumn("DT Compra");
		tableModel.addColumn("DT Venda");
		tableModel.addColumn("Carteira");
		tableModel.addColumn("C Por");
		tableModel.addColumn("Val At");
		tableModel.addColumn("Ven Por");
		tableModel.addColumn("Sub T Comprado");
		tableModel.addColumn("Sub T Vendido");

		table = new JTable(tableModel);
		scroll = new JScrollPane(table);
		scroll.setBounds(10,55,559,275);
		panel.add(scroll);
		
		
		// Totais rótulos e textfields
		lbTotalComprado = new JLabel("Total Comprado");
		lbTotalComprado.setBounds(10,330,40,20);
		panel.add(lbTotalComprado);
		
		tfTotalComprado = new JTextField();
		tfTotalComprado.setBounds(50,330,40,25);
		System.out.println(ProcessaInvestimento.getTotalComprado());
		tfTotalComprado.setText(String.format("%.2f", ProcessaInvestimento.getTotalComprado()));
		panel.add(tfTotalComprado);
		
		lbTotalVendido = new JLabel("Total Vendido");
		lbTotalVendido.setBounds(90,330,40,20);
		panel.add(lbTotalVendido);
		
		tfTotalVendido = new JTextField();
		tfTotalVendido.setBounds(130,330,40,25);
		tfTotalVendido.setText(String.format("%.2f", ProcessaInvestimento.getTotalVendido()));
		panel.add(tfTotalVendido);
		
		lbDiferenca = new JLabel("Diferença");
		lbDiferenca.setBounds(170,330,40,20);
		panel.add(lbDiferenca);
		
		tfDiferenca = new JTextField();
		tfDiferenca.setBounds(210,330,40,25);
		tfDiferenca.setText(String.format("%.2f", ProcessaInvestimento.getLucro()));
		panel.add(tfDiferenca);
		
		

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
		if(!ProcessaInvestimento.getArray().isEmpty()) {// Verifica se o BD não está vazio
			for(Investimento i : ProcessaInvestimento.getArray() ) {
				tableModel.addRow(i.toVetor());
			}
		}
		
		// Adicionar as carteiras no combo box
		for(Carteira c: ProcessaCarteira.getArray()) {
			cbCarteira.addItem(c.getId()+" - "+c.getNome());
		}
		
		
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbAdd) { // Adicionar informações na tabela
			if(!tfQuantidade.getText().isEmpty() 
					&& !tfAcao.getText().isEmpty() 
					&& !tfDataCompra.getText().isEmpty() 
					&& !tfDataVenda.getText().isEmpty()
					&& cbCarteira.getSelectedIndex()>=0
					&& !tfCompradoPor.getText().isEmpty()
					&& !tfValorAtual.getText().isEmpty()
					&& !tfVendidoPor.getText().isEmpty()) {// Avaliar se todos os campos foram inseridos
					
				// Utiliza a Classe Investimento DAO para inserir os dados na tabela
				investimento = new Investimento();
				investimento.setId(id);
				investimento.setQuantidade(Integer.parseInt(tfQuantidade.getText()));
				investimento.setAcao(tfAcao.getText());
				investimento.setDataCompra(tfDataCompra.getText());
				investimento.setDataVenda(tfDataVenda.getText());
				
				carteira = ProcessaCarteira.getArray().get(cbCarteira.getSelectedIndex());
				investimento.setCarteira(carteira);
				investimento.setCompradoPor(Double.parseDouble(tfCompradoPor.getText()));
				investimento.setValorAtual(Double.parseDouble(tfValorAtual.getText()));
				investimento.setVendidoPor(Double.parseDouble(tfVendidoPor.getText()));
				tableModel.addRow(investimento.toVetor());
				
				//Limpar os campos text field
				id++;
				tfId.setText(String.format("%d", id));
				tfQuantidade.setText("");
				tfAcao.setText("");
				tfDataCompra.setText("");
				tfDataVenda.setText("");
				cbCarteira.setSelectedIndex(-1);
				tfCompradoPor.setText("");
				tfValorAtual.setText("");
				tfVendidoPor.setText("");
				
				
				tfTotalComprado.setText(String.format("%f", ProcessaInvestimento.getTotalComprado()));
				tfTotalComprado.setText(String.valueOf(ProcessaInvestimento.getTotalVendido()));
				tfTotalComprado.setText(String.valueOf(ProcessaInvestimento.getLucro()));
				
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
			ArrayList<Investimento> investimentos = new ArrayList<>();
			
			
			for (int i=0;i<tableModel.getRowCount();i++) {
				investimento = new Investimento();
				investimento.setId(Integer.parseInt((String)tableModel.getValueAt(i,0)));
				investimento.setQuantidade(Integer.parseInt((String)tableModel.getValueAt(i, 1)));
				investimento.setAcao((String)tableModel.getValueAt(i, 2));
				investimento.setDataCompra((String)tableModel.getValueAt(i, 3));
				investimento.setDataVenda((String)tableModel.getValueAt(i, 4));
				
				
				carteira = new Carteira();
				carteira.setId(Integer.parseInt((String)tableModel.getValueAt(i, 5)));
				investimento.setCarteira(carteira);
				
				investimento.setCompradoPor(Double.parseDouble((String)tableModel.getValueAt(i, 6)));
				investimento.setValorAtual(Double.parseDouble((String)tableModel.getValueAt(i, 7)));
				investimento.setVendidoPor(Double.parseDouble((String)tableModel.getValueAt(i, 8)));
				investimentos.add(investimento);
				
			}
			
			
			ProcessaInvestimento.setArray(investimentos);
			JOptionPane.showMessageDialog(null,"Investimentos salvo com sucesso!");
			dispose();
			
			
		}
	}
}
