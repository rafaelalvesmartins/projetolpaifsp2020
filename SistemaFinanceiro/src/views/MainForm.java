package views;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class MainForm extends JFrame implements ActionListener  { // Herda todos os atributos e métodos da classe JFrame
	private static final long serialVersionUID = 1L; // Necessário para JFrame trabalhar com byte
	private JPanel panel;
	private JMenuBar barraMenu;
	private JMenu menuArquivo, menuSistema;
	private JMenuItem itemCarteiras, itemInvestimentos, itemRelatorios, itemSair;
	private JLabel lbFundo;
	private ImageIcon fundo;
	
	MainForm(){ // Método construtor
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Define o que acontece quando clica no botão fechar
		setTitle("Sistema Financeiro"); // Define o título da janela
		setBounds(300, 80, 900, 700); // Dimensões da janela x, y, largura e altura
		
		panel = new JPanel(); // Panel para adicionar os elementos na janela
		setContentPane(panel); // Setando o panel na janela
		
		// Definindo menu na janela
		barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		
		setLayout(null); //Define layout, no primeiro momento nulo
		
		// Parte do Menu
		menuArquivo = new JMenu("Arquivo");
		menuSistema = new JMenu("Sistema");
		barraMenu.add(menuArquivo);
		barraMenu.add(menuSistema);
		
		itemCarteiras = new JMenuItem("Carteiras");
		itemInvestimentos = new JMenuItem("Investimentos");
		itemRelatorios = new JMenuItem("Relatórios");
		itemSair = new JMenuItem("Sair");
		
		menuArquivo.add(itemCarteiras);
		menuArquivo.add(itemInvestimentos);
		
		menuSistema.add(itemRelatorios);
		menuSistema.add(itemSair);
		
		// Adicionando Eventos nos itens do menu
		itemCarteiras.addActionListener(this);
		itemInvestimentos.addActionListener(this);
		itemRelatorios.addActionListener(this);
		itemSair.addActionListener(this);
		
		
		// Parte da Imagem
		fundo = new ImageIcon(".\\img\\fundo.jpeg");
		lbFundo = new JLabel();
		lbFundo.setIcon(fundo);
		lbFundo.setBounds(20,15,850,650); // x,y, largura, altura
		panel.add(lbFundo);
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == itemCarteiras) { // Cateiras
			CarteiraForm cf = new CarteiraForm();
			cf.setVisible(true);
		} else if (e.getSource() == itemInvestimentos) { // Investimentos
			System.out.println("Investimentos");
		} else if (e.getSource() == itemRelatorios) { // Relatórios
			System.out.println("Relatórios");			
		} else if (e.getSource() == itemSair) { // Sair
			dispose();		
		}
		
	}
	
	public static void main(String[] args) {
		MainForm mainform = new MainForm();
		mainform.setVisible(true);
	}

	

}
