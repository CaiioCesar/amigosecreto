package br.ufpb.dcx.amigosecreto;

// Classe MensagemParaAlguem
class MensagemParaAlguem extends Mensagem {
    private String destinatario;

    public MensagemParaAlguem(String remetente, String destinatario, String texto, boolean anonima) {
        super(remetente, texto, anonima);
        this.destinatario = destinatario;
    }

    @Override
    public String getTextoCompletoAExibir() {
        if (anonima) {
            return "Mensagem para " + destinatario + ". Texto: " + texto;
        } else {
            return "Mensagem de: " + remetente + " para " + destinatario + ". Texto: " + texto;
        }
    }
}
