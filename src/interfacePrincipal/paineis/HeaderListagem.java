package interfacePrincipal.paineis;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class HeaderListagem {
	
	private JPanel painelListagem;
	private JComboBox<String> comboBoxLivro;
	private JComboBox<String> comboBoxCliente;
	private JButton b1;
	private FlowLayout fl;
	
	public HeaderListagem() {
		// TODO Auto-generated constructor stub
		b1 = new JButton("teste");
		/*
		 * Configura a combobox de Lvro adicionando as opcoes
		 * disponiveis
		 * */
		this.comboBoxLivro = new JComboBox<String>();
		this.comboBoxLivro.addItem("Livro");
		this.comboBoxLivro.addItem("Listagem por Status");
		this.comboBoxLivro.addItem("Listagem por Genero");
		this.comboBoxLivro.setVisible(true);
		
		/*
		 * Configura a combobox de Cliente adicionando as opcoes
		 * disponiveis, no caso so uma por enquanto
		 * */
		this.comboBoxCliente = new JComboBox<String>();
		this.comboBoxCliente.setToolTipText("Cliente");
		this.comboBoxCliente.addItem("Cliente");
		
		//Configura Painel
		this.painelListagem = new JPanel();
		this.fl = new FlowLayout(FlowLayout.RIGHT);
		
		this.fl = new FlowLayout();
		this.fl.setAlignment(FlowLayout.LEFT);
		this.painelListagem.setLayout(this.fl);
		//this.painelListagem.setBackground(Color.BLUE);
	}
	/*
	 * 
	 * Aqui esta a funcao que voce deve adicionar a acao, fique a vontade
	 * pode criar funcoes por ai tambem, essa e com relacao aos itens do combobox
	 * quando clicados
	 * */
	public JPanel retPainel() {
		comboBoxLivro.addActionListener(e -> {
			//Escreva sua fucao de buscar dados aqui
			System.out.println(comboBoxLivro.getSelectedItem());
		});
		
		
		//Adiciona componentes
		this.painelListagem.add(comboBoxLivro);
		this.painelListagem.add(comboBoxCliente);
		this.painelListagem.setBorder(BorderFactory.createEmptyBorder(0, (int) Math.ceil(ContainerCROUD.screenWidth*0.009), 0, 0));;
		return this.painelListagem;
	}
	
	
	
}
