package Pacotes;
import java.util.Scanner;
import java.util.Random;

public class Banco {
	public static void main(String[] args) {
			
		String nome = null;
		int resposta, contarandom;
		double valorDeposito;
		double valorResgate;
		// por que essa indica��o da vari�vel?
		
		
		System.err.println("Ol�, bem vindo ao Fuctura Bank. Vamos cadastrar a sua conta:");
		System.out.println("Digite o nome do titular da conta: ");
		Scanner inputS = new Scanner(System.in);
		
		ContaCorrente ContaCorrente = new ContaCorrente(nome);
		//instancia da classe ContaCorrente
		
		ContaCorrente.titularConta = inputS.nextLine();
		//o titular da classe ContaCorrente recebe o nome digitado
		
		Random random = new Random();
		contarandom = random.nextInt(10000);
		ContaCorrente.numConta = contarandom;
		//o numero da conta da classe ContaCorrente recebe a conta randomica
		
		System.out.println("Voc� deseja realizar um dep�sito inicial? ");
		System.out.println("1 - SIM | 2 - N�O ");
		
		Scanner recebeResposta = new Scanner(System.in);
		resposta = recebeResposta.nextInt();
		
		// resposta sim para deposito inicial
		
			if (resposta == 1 ) {
				valorDeposito = 0;	
				
				System.out.println("Que bom! Agora, digite o valor que deseja depositar : ");
				Scanner recebeValor = new Scanner(System.in);
				ContaCorrente.valor = recebeValor.nextDouble();
				System.err.println("Criando sua conta... ");
				System.out.println("�timo, " + ContaCorrente.titularConta + ". Sua conta corrente foi aberta com n�mero : " + ContaCorrente.numConta);
				
				ContaCorrente.depositar(); 
				System.err.println("O Saldo atual da sua conta corrente � R$ " + ContaCorrente.getSaldo());
				
				int menu = 1;
				do {
				
				//inicio das op��es do menu para resgate e dados da conta
				System.out.println("Agora que voc� possui uma conta criada, escolha as op��es dispon�veis: ");
				System.err.println("+-------------------------------------+");
				System.err.println("1 - RESGATAR POUPAN�A");
			 	System.err.println("2 - SACAR DA CONTA CORRENTE");
			 	System.err.println("3 - INFORMA��ES DAS CONTAS");
			 	System.err.println("0 - FINALIZAR SESS�O");
				System.err.println("+-------------------------------------+");
								
				Scanner recebeResposta1 = new Scanner(System.in);
				resposta = recebeResposta1.nextInt();
					
				} while (menu == 0); 
									
				if (resposta == 1 ) {
					
					double recebeValorPoup;
					ContaPoupanca ContaPoupanca = new ContaPoupanca(0, null, 0);
					System.out.println("Op��o Resgatar: Insira o valor que deseja resgatar da poupan�a");
					System.err.println("Saldo dispon�vel para resgate : R$ " + ContaPoupanca.getSaldo());
					Scanner recebeValor1 = new Scanner(System.in);
					recebeValorPoup = recebeValor1.nextDouble();
												
						if (recebeValorPoup > ContaPoupanca.getSaldo()) {					
						System.err.println("Este valor � maior que o saldo da conta poupan�a. Resgate n�o efetuado!");
						System.err.println("O saldo da conta poupan�a continua R$ " + ContaPoupanca.getSaldo());
						}
					
						if (recebeValorPoup <= ContaPoupanca.getSaldo()) {	
						ContaPoupanca.valorPoupanca = recebeValorPoup;
						ContaPoupanca.resgatar();
						ContaCorrente.valor = recebeValorPoup;
						ContaCorrente.aplicar();
						System.err.println("O Saldo atual da sua conta corrente agora � R$ " + ContaCorrente.getSaldo());
						
						
						recebeValor1.close();
						}
				}
						if (resposta == 2 ) {
						
						double recebeValorPoup;
						System.out.println("Op��o Sacar: Insira o valor que deseja sacar da conta corrente");
						System.err.println("Saldo dispon�vel para saque : R$ " + ContaCorrente.getSaldo());
						Scanner recebeValor1 = new Scanner(System.in);
						recebeValorPoup = recebeValor1.nextDouble();
						
						if (recebeValorPoup > ContaCorrente.getSaldo()) {					
							System.err.println("Este valor � maior que o saldo da conta. Saque n�o efetuado!");
							System.err.println("Seu saldo ainda continua R$ " + ContaCorrente.getSaldo());
							}
						
						if (recebeValorPoup <= ContaCorrente.getSaldo()) {
							ContaCorrente.valor = recebeValorPoup;
							ContaCorrente.sacar();
							System.err.println("O Saldo atual da sua conta corrente agora � R$ " + ContaCorrente.getSaldo());
							recebeValor1.close();
						}
							
						
					}
						if (resposta == 3 ) {
							ContaCorrente.dadosDaContaCorrente();
							ContaPoupanca ContaPoupanca = new ContaPoupanca(ContaCorrente.numConta, ContaCorrente.titularConta, 0);
							ContaPoupanca.dadosDaContaPoupanca();
							
						}
						
						if (resposta == 0 ) {
							System.err.println("Sess�o Finalizada! Obrigado por utlizar nossos servi�os. Tenha um �timo dia!");

							
						}
				recebeValor.close();
				recebeResposta.close();
				//recebeResposta1.close();
				
			} else {
				
				ContaCorrente.numConta = 0;
				ContaCorrente.titularConta = "";
				System.err.println("Que pena, s� podemos abrir a conta se houver um dep�sito inicial de qualquer valor. \nO Fuctura Bank agradece!");
				System.err.println("Sess�o Finalizada! Obrigado por utilizar nossos servi�os!");
							
			}
			
		}
	
}
