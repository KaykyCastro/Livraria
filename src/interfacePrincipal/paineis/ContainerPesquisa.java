package interfacePrincipal.paineis;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ContainerPesquisa{
	
	private JPanel container;
	//testes de Layout
	private FlowLayout fl;
	private GridLayout gl;
	
	
	public static Object[][] dados;
	private Object[][] dadosReserva = {{"A", "", "", "", "",""}};
	
	
	private JScrollPane rolagem;
	
	private HeaderPainelBotoes headerBotoes;
	private HeaderListagem headerListagem;
	
	/*
	 * Adicionando um container para a tabela JTable 
	 * de apresentacao de dados
	 * */
	private JPanel painelTabela;
	private JTable tabelaDados;
	
	//mudado
	private static DefaultTableModel tb;
	
	public ContainerPesquisa() {
		// TODO Auto-generated constructor stub
		
		//idela que seja mudado
		tabelaDados = new JTable();
		tb = new DefaultTableModel();
		
		this.container = new JPanel();
		this.fl = new FlowLayout();
		//this.gl = new GridLayout(1,1);
		this.fl.setVgap(0);
		fl.setHgap(0);
		
		this.fl.setAlignment(FlowLayout.CENTER);
		
		//BorderLayout bd = new BorderLayout();
		
		this.container.setLayout(fl);
		
		//Instancia paineis
		this.headerBotoes = new HeaderPainelBotoes();
		this.headerListagem = new HeaderListagem();
		this.painelTabela = new JPanel();
		
		
		//adiciona o header1
		this.container.add(headerBotoes.retPanel());
		this.container.add(this.headerListagem.retPainel());
		
		//instancia o scroll da tabela
		this.rolagem = new JScrollPane();
		
	}
	
	public JPanel retPanel() {
		//this.container.setBackground(Color.BLACK);
		//this.container.
		
		this.container.setVisible(true);
		return this.container;
	}
	
	public JPanel retPainelBiblioteca() {
		
		//this.painelTabela.setBackground(null);
		
		
		//this.tabelaDadosLivro = new JTable(this.getTableModel());
		/*
		 * Para uma tabela vamos testar a insercao de uma matriz 
		 * de objetos recebidos de algum lugar junto a uma coluna setada.
		 * Este e apenas um EXEMPLO, vamos colocar o correto depois.
		 * */
		
		
		
		
		
		
		
	
		
		rolagem.setVisible(true);
		setTableData();
		this.painelTabela.add(tabelaDados);
		this.rolagem.add(this.painelTabela);
		//this.painelTabela.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		this.painelTabela.setLayout(new GridLayout());
		
		return this.painelTabela;
	}
	
	public static void getTableData(Object[][] dados){
		//recebe de um getDados por exemplo
		
		
		//Object[][] dados = this.getDadosTabela();
		
		Object[] colunas = {"Codigo", "Nome", "Autor/Endereco", "Genero", "Status", "Multa"};
//		Object[][] dados2 = {
//	            {123, "O Principe", "Maquiavel", "Politicas", "Alugado", 0.0},
//	            {124, "Diario de Um banana", "Nao sei", "Biografia", "Livre", 1.0},
//	            {125, "O Principe", "Maquiavel", "Politicas", "Alugado", 0.0},
//	            {128, "O Principe", "Maquiavel", "Politicas", "Alugado", 102.0}
//	        };
		
		//System.out.println(tabela.getValueAt(0, 0));
		ContainerPesquisa.dados = dados;
		ContainerPesquisa.tb.setDataVector(dados, colunas);
		
	}
	
	
	public void setTableData(){
		
		
		//Aqui se vai obter os dados, como? nao sei
		Object[] colunas = {"Codigo", "Nome", "Autor/Endereco", "Genero", "Status", "Multa"};
		try {
			
				tabelaDados.setModel(ContainerPesquisa.tb);
		}catch(Exception e) {
			System.out.println("excessao");
			ContainerPesquisa.tb.setDataVector(dadosReserva, colunas);
		}
		
		
		
	}
	
	
	
}
