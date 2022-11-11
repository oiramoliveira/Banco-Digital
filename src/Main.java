import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println(" ==== Conta Bancária ====");
		System.out.println("Opções:");
		System.out.println("1 - Cadastrar nova conta.");
		System.out.println("2 - Consultar Conta.");
		System.out.println("3 - Depositar.");
		System.out.println("4 - Transferir");
		System.out.println("5 - Sacar");
		System.out.print("Escolha uma opção: ");

		int escolha = Integer.parseInt(new Scanner(System.in).nextLine());

		Conta cc = new ContaCorrente(null);
		Conta poupanca = new ContaPoupanca(null);
		Cliente cliente = new Cliente();

		switch (escolha) {
			case 1:
				System.out.print("Digite o nome: ");
				String n = in.nextLine();
				cliente.setNome(n);
				break;
							
			case 2:
				System.out.println("Consultar saldo da conta.");
				System.out.println("Digite CC (Conta Corrente) ou CP (Poupança)");
				String opcao1 = in.next();
				if (opcao1 == "CC") {
					cc.imprimirExtrato();
				}
				if (opcao1 == "CP") {
					poupanca.imprimirExtrato();
				} 
				break;

			case 3:
				System.out.println("Informe a conta de destino CC ou CP");
				String opcao2 = in.next();
				if (opcao2 == "CC") {
					System.out.println("Informe o valor: ");
					Double val = in.nextDouble();
					cc.depositar(val);
				}
				if (opcao2 == "CP") {
					System.out.println("Informe o valor: ");
					Double val = in.nextDouble();
					poupanca.depositar(val);
				}
				break;

			case 4:
				System.out.println("Informe a conta de origem. CC (conta corrente) e CP (poupança)");
				String opcao3 = in.next();
				if (opcao3 == "CC") {
					System.out.println("Informe o valor: ");
					Double val1 = in.nextDouble();
					cc.transferir(val1, poupanca);
				}
				if (opcao3 == "CP") {
					System.out.println("Informe o valor: ");
					Double val3 = in.nextDouble();
					poupanca.transferir(val3, cc);

				} 
				break;

			case 5:
				System.out.println("Informa a conta para saque CC (conta corrente) e CP (poupança)");
				String opcao4 = in.next();
				if (opcao4 == "CC") {
					System.out.println("Valor desejado: ");
					Double val4 = in.nextDouble();
					cc.sacar(val4);					
				}
				if (opcao4 == "CP") {
					System.out.println("Valor desejado: ");
					Double val4 = in.nextDouble();
					poupanca.sacar(val4);
				} 				
				break;

			default:
				System.out.println("Opção Inválida! Use letras maiúculas.");
				
		}
		while (escolha != '0')
			
		return;

	
	}

}
