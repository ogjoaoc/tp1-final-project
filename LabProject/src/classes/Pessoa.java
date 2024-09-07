// Classe: Pessoa
// Superclasse auxiliar para o cadastro de usuários e pacientes.
// Armazena atributos gerais de uma Pessoa real.

package classes;

public class Pessoa {
    
//    Atributos específicos de uma Pessoa;
//    - nome: Ex: "Maria da Silva".
//    - cpf: identificador.
//    - sexo: Masculino, Feminino ou outro.
//    - dataNascimento: data em que a pessoa nasceu.
//    - email: email dessa pessoa.
    
    protected String nome;
    protected String cpf;
    protected String sexo;
    protected String dataNascimento;
    protected String email;
    
//    Construtores
    
    public Pessoa() {
        
    }
    
    public Pessoa(String nome, String cpf, String sexo, String dataNascimento, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

//    Getter e setters
    
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
