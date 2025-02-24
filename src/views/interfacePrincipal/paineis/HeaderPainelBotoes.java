package views.interfacePrincipal.paineis;

//package interfacePrincipal.paineis;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HeaderPainelBotoes{
	/*
	 * Instanciando as variaveis de painel, layout e os botoes correspondentes
	 * do painel
	 * */
	//ContainerPesquisa containerPesquisa = new ContainerPesquisa();
	
	private JPanel header;
	private FlowLayout flowLt;
	private JButton btnPesquisarLivro;
	private JButton btnPesquisarCliente;
	private JTextField campoPesquisa;
	private JLabel labelPesquisa;
	//private JTable tabelaDadosLivro;
	//private DefaultTableModel tabelaDefault;
	
	public HeaderPainelBotoes() {
		
		//tabelaDadosLivro = new JTable();
		//tabelaDefault = new DefaultTableModel();
		/*
		 * Configurando o Painel, adicionando Layout, colocando alinhamento
		 * a esquerda
		 * */
		 this.header = new JPanel();
		 this.flowLt = new FlowLayout();
		 flowLt.setAlignment(FlowLayout.LEFT);
		 this.header.setLayout(this.flowLt);
		 //this.header.setBackground(Color.BLUE);
		 
		 
		 /*
			 * Instanciando e configurando os Botoes
			 * */
			this.btnPesquisarCliente = new JButton("Pesquisar Cliente");
			this.btnPesquisarLivro = new JButton("Pesquisar Livro");
		
			/*
			 * Instanciando e configurando o campo de pesquisa
			 * Juntamente a sua Jlabel de informacao
			 * */
			campoPesquisa = new JTextField(19);
			labelPesquisa = new JLabel("Pesquisar:");
			labelPesquisa.setLabelFor(campoPesquisa);
			campoPesquisa.setText("Codigo ou CPF");
			
	}
	
	
	
	public JPanel retPanel() {
		
		//Configurando Botoes
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
		this.btnPesquisarCliente.setCursor(c);
		this.btnPesquisarLivro.setCursor(c);
		this.btnPesquisarLivro.setBackground(Color.lightGray);
		//this.btnPesquisarLivro.setSize(200,100);
		this.btnPesquisarLivro.setVisible(true);
		this.btnPesquisarLivro.setVisible(true);
		System.out.println("Chegou aqui");
		/*
		 * Adicionando componentes ao header
		 * */
		//this.header.add(labelPesquisa);
		this.header.add(campoPesquisa);
		this.header.add(btnPesquisarLivro);
		this.header.add(btnPesquisarCliente);
		this.header.setVisible(true);
		
		/*
		 * Adicionando acoes aos botoes
		 * 
		 * Aqui voce pode colocar as acoes dos botoes ou criar funcoes proprias dentro dessa classe
		 * provavelmente vamos precisar de ajustes entao me contate pra mudarmos
		 * se precisar
		 * */
		this.btnPesquisarCliente.addActionListener(e -> {
			
			//Escreva sua fucao de buscar dados aqui
			Object[][] dados = {
		            {"123.908.201-22", "Luiz", "Nao", "Sei", "Ta la", 0.0},
		            {124, "Diario de Um banana", "Nao sei", "Biografia", "Livre", 1.0},
		            {125, "O Principe", "Maquiavel", "Politicas", "Alugado", 0.0},
		            {128, "O Principe", "Maquiavel", "Politicas", "Alugado", 102.0}
		        };
			
			pesquisaClientes(dados);
		});
		this.btnPesquisarLivro.addActionListener(e -> {
			//Escreva sua fucao de buscar dados aqui
			Object[][] dados = {
		            {123, "O Principe", "Maquiavel", "Politicas", "Alugado", "Alugado"},
		            {124, "Diario de Um banana", "Nao sei", "Biografia", "Livre", "LIvre"},
		            {125, "O Principe", "Maquiavel", "Politicas", "Alugado", "LIvre"},
		            {128, "O Principe", "Maquiavel", "Politicas", "Alugado", "Alugado"}
		        };
			
			pesquisaLivros(dados);
		});
		
		//por fim retorna o JPanel
		return this.header;
	}
	
	/*
	 * Campo de teste
	 * */
	public void pesquisaLivros(Object[][] valor) {
		ContainerPesquisa.getTableData(valor,1);
		System.out.println("Func");
	}
	public void pesquisaClientes(Object[][] valor) {
		ContainerPesquisa.getTableData(valor,0);
		System.out.println("Func2");
	}
	/*
	 * Fim Campo de teste
	 * */
}
