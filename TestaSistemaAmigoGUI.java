package br.ufpb.dcx.amigosecreto;

import java.util.Scanner;

public class TestaSistemaAmigoGUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaAmigo sistema = new SistemaAmigo();




        System.out.print("Quantos amigos participarão da brincadeira? ");
        int quantidadeAmigos = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha


        for (int i = 0; i < quantidadeAmigos; i++) {
            System.out.print("Nome do amigo: ");
            String nome = scanner.nextLine();
            System.out.print("E-mail do amigo: ");
            String email = scanner.nextLine();
            sistema.cadastraAmigo(nome, email);
        }


        for (int i = 0; i < quantidadeAmigos; i++) {
            System.out.print("E-mail do amigo que deseja configurar amigo secreto: ");
            String email = scanner.nextLine();
            System.out.print("E-mail do amigo secreto sorteado: ");
            String amigoSecreto = scanner.nextLine();
            try {
                sistema.configuraAmigoSecretoDe(email, amigoSecreto);
            } catch (AmigoInexistenteException e) {
                System.out.println(e.getMessage());
            }
        }


        System.out.print("Remetente da mensagem: ");
        String remetente = scanner.nextLine();
        System.out.print("Texto da mensagem: ");
        String texto = scanner.nextLine();
        System.out.print("Mensagem anônima? (true/false): ");
        boolean anonima = scanner.nextBoolean();

        Mensagem mensagem = new MensagemParaAlguem(remetente, "todos", texto, anonima);
        sistema.enviarMensagem(mensagem);

        scanner.close();
    }
}

