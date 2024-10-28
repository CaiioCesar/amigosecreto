package br.ufpb.dcx.amigosecreto;


class Amigo {
    private String nome;
    private String email;
    private String amigoSecreto;

    public Amigo(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAmigoSecreto(String amigoSecreto) {
        this.amigoSecreto = amigoSecreto;
    }

    public String getAmigoSecreto() {
        return amigoSecreto;
    }
}
