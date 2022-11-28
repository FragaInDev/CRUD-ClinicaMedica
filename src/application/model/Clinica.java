package application.model;

public class Clinica {
    private String nome;
    private int id;
    private String logradouro;
    private String numEnd;
    private String cep;
    private String complemento;
    private String telefone;
    private String email;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getNumEnd() {
        return numEnd;
    }
    public void setNumEnd(String numEnd) {
        this.numEnd = numEnd;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email="
                + email + ", logradouro=" + logradouro + ", cep=" + cep + ", numEnd=" + numEnd + ", complemento="+ complemento +"]";
    }
}
