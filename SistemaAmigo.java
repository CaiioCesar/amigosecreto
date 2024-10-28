package br.ufpb.dcx.amigosecreto;

import java.util.ArrayList;
import java.util.List;

class AmigoInexistenteException extends Exception {
    public AmigoInexistenteException(String message) {
        super(message);
    }
}

class AmigoNaoSorteadoException extends Exception {
    public AmigoNaoSorteadoException(String message) {
        super(message);
    }
}

class SistemaAmigo {
    private List<Amigo> amigos;
    private List<Mensagem> mensagens;

    public SistemaAmigo() {
        amigos = new ArrayList<>();
        mensagens = new ArrayList<>();
    }

    public void cadastraAmigo(String nome, String email) {
        amigos.add(new Amigo(nome, email));
    }

    public Amigo pesquisaAmigo(String email) {
        for (Amigo amigo : amigos) {
            if (amigo.getEmail().equals(email)) {
                return amigo;
            }
        }
        return null;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        Amigo amigo = pesquisaAmigo(emailDaPessoa);
        if (amigo == null) {
            throw new AmigoInexistenteException("Amigo não cadastrado: " + emailDaPessoa);
        }
        amigo.setAmigoSecreto(emailAmigoSorteado);
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> anonimas = new ArrayList<>();
        for (Mensagem mensagem : mensagens) {
            if (mensagem.isAnonima()) {
                anonimas.add(mensagem);
            }
        }
        return anonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return new ArrayList<>(mensagens);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        Amigo amigo = pesquisaAmigo(emailDaPessoa);
        if (amigo == null) {
            throw new AmigoInexistenteException("Amigo não cadastrado: " + emailDaPessoa);
        }
        String amigoSecreto = amigo.getAmigoSecreto();
        if (amigoSecreto == null) {
            throw new AmigoNaoSorteadoException("Amigo secreto não sorteado para: " + emailDaPessoa);
        }
        return amigoSecreto;
    }

    public void enviarMensagem(Mensagem mensagem) {
        mensagens.add(mensagem);
    }
}

