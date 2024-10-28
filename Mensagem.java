package br.ufpb.dcx.amigosecreto;

// Classe abstrata Mensagem
abstract class Mensagem {
    protected String remetente;
    protected String texto;
    protected boolean anonima;

    public Mensagem(String remetente, String texto, boolean anonima) {
        this.remetente = remetente;
        this.texto = texto;
        this.anonima = anonima;
    }

    public abstract String getTextoCompletoAExibir();

    public String getTexto() {
        return texto;
    }

    public boolean isAnonima() {
        return anonima;
    }
}
