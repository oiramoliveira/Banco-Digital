import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		Cliente cliente = new Cliente();
		Conta cc = new ContaCorrente(cliente);
		Conta poupanca = new ContaPoupanca(cliente);

			
			System.out.println(" ==== Conta Bancária ====");
			System.out.println("Opções:");
			System.out.println("1 - Cadastrar nova conta.");
			System.out.println("2 - Consultar Conta.");
			System.out.println("3 - Depositar.");
			System.out.println("4 - Transferir");
			System.out.println("5 - Sacar");
			System.out.print("Escolha uma opção: ");
			
			int escolha = in.nextInt();
				
			
			
			switch (escolha) {
				case 1:
					System.out.print("Digite o nome: ");
					String n = in.nextLine();
					cliente.setNome(n);
					break;

				case 2:
					System.out.println("Consultar saldo da conta.");
					System.out.println("Digite 1 (Conta Corrente) ou 2 (Poupança)");
					int opcao1 = in.nextInt();
					if (opcao1 == 1) {
						cc.imprimirExtrato();
					}
					if (opcao1 == 2) {
						poupanca.imprimirExtrato();
					}
					break;

				case 3:
					System.out.println("Digite 1 (Conta Corrente) ou 2 (Poupança)");
					int opcao2 = in.nextInt();
					if (opcao2 == 1) {
						System.out.println("Informe o valor: ");
						Double val = in.nextDouble();
						cc.depositar(val);
					}
					if (opcao2 == 2) {
						System.out.println("Informe o valor: ");
						Double val = in.nextDouble();
						poupanca.depositar(val);
					}
					break;

				case 4:
					System.out.println("Informe a conta de origem. Digite 1 (Conta Corrente) ou 2 (Poupança)");
					int opcao3 = in.nextInt();
					if (opcao3 == 1) {
						System.out.println("Informe o valor: ");
						Double val1 = in.nextDouble();
						cc.transferir(val1, poupanca);
					}
					if (opcao3 == 2) {
						System.out.println("Informe o valor: ");
						Double val3 = in.nextDouble();
						poupanca.transferir(val3, cc);

					}
					break;

				case 5:
					System.out.println("Informa a conta para saque. Digite 1 (Conta Corrente) ou 2 (Poupança)");
					int opcao4 = in.nextInt();
					if (opcao4 == 1) {
						System.out.println("Valor desejado: ");
						Double val4 = in.nextDouble();
						cc.sacar(val4);
					}
					if (opcao4 == 2) {
						System.out.println("Valor desejado: ");
						Double val4 = in.nextDouble();
						poupanca.sacar(val4);
					}
					break;

				default:
					System.out.println("Opção Inválida! Use 1 Para Conta Corrente ou 2 para Poupança.");

			}
		}
	
	}
