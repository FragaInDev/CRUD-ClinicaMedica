package application.model;

public class Paciente {
    private String nome;
    private String cpf;
    private String logradouro;
    private String cep;
    private String numEnd;
    private String complemento;
    private String telefone;
    private String email;
    private String tipoSanguineo;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getNumero() {
        return numEnd;
    }
    public void setNumero(String numEnd) {
        this.numEnd = numEnd;
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
    public String getTipoSanguineo() {
        return tipoSanguineo;
    }
    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }
    @Override
    public String toString() {
        return "[cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", email="
                + email + ", logradouro=" + logradouro + ", cep=" + cep + ", numEnd=" + numEnd + ", complemento="+ complemento +"]";
    }
}
