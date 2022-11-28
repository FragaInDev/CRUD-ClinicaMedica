package application.model;

public class Medico {
    private String nome;
    private String crm;
    private String logradouro;
    private String numEnd;
    private String cep;
    private String complemento;
    private String telefone;
    private String email;
    private Especialidade especialidade;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCrm() {
        return crm;
    }
    public void setCrm(String crm) {
        this.crm = crm;
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
    public Especialidade getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "[crm=" + crm + ", nome=" + nome + ", telefone=" + telefone + ", email="
                + email + ", logradouro=" + logradouro + ", cep=" + cep + ", numEnd=" + numEnd + ", complemento="+ complemento +"]";
}
}
