package br.ufpb.dcx.amigosecreto;
import java.util.List;
import java.util.ArrayList;

public class TestaSistemaAmigo {
    public static void main(String[] args) {
        SistemaAmigo sistema = new SistemaAmigo();


        sistema.cadastraAmigo("José", "jose@email.com");
        sistema.cadastraAmigo("Maria", "maria@email.com");

        try {

            sistema.configuraAmigoSecretoDe("jose@email.com", "maria@email.com");
            sistema.configuraAmigoSecretoDe("maria@email.com", "jose@email.com");


            Mensagem mensagem1 = new MensagemParaAlguem("Maria", "jose@email.com", "Feliz Amigo Secreto!", true);
            sistema.enviarMensagem(mensagem1);


            Mensagem mensagem2 = new MensagemParaAlguem("Maria", "todos", "Olá a todos!", true);
            sistema.enviarMensagem(mensagem2);


            List<Mensagem> anonimas = sistema.pesquisaMensagensAnonimas();
            if (anonimas.isEmpty()) {
                System.out.println("Não há mensagens anônimas.");
            } else {
                System.out.println("Mensagens anônimas:");
                for (Mensagem mensagem : anonimas) {
                    System.out.println(mensagem.getTextoCompletoAExibir());
                }
            }

            String amigoSecreto = sistema.pesquisaAmigoSecretoDe("jose@email.com");
            if ("maria@email.com".equals(amigoSecreto)) {
                System.out.println("Ok");
            }
        } catch (AmigoInexistenteException | AmigoNaoSorteadoException e) {
            System.out.println(e.getMessage());
        }
    }
}

