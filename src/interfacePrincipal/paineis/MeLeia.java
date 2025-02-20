package interfacePrincipal.paineis;

public @interface MeLeia {
	/*
	 * Os metodos de acao estao nas seguintes classes:
	 * HeaderListagem e HeaderPainelBotoes
	 * 
	 * 1.A questao da tabela eu fiz uma variavel abstrada que muda os dados
	 * chamada sendo uma DefaultTableModel, ela modifica a tabela original
	 * nao muda a sua vida mas saiba que isso existe e nao esta tao bem feito,
	 * voce vera esse metodo que chama essa variavel la na classe de PainelBotoes.
	 * 
	 * E so um teste entao eu deixei facil de mudar caso a gente queira.
	 * 
	 * 2.A Classe container Croud contem varias classes mas o metodo getPanel
	 * implementado da interface JPanels Actions 
	 * tem as acoes dos botoes, elas sao acionadas no momento de criacao do painel
	 * entao la vao estar as acoes, apesar que eu deixei um espaco no final pra metodos
	 * desse tipo.
	 * 
	 * 3.A tabela nao aceita Header ainda, vou ver o que posso fazer depois.
	 * 
	 * 
	 * */
}
