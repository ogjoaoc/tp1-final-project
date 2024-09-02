package classes;

public class Vacina {
    private String tipoVacina, validade;
    private boolean disponivel;
    private Enfermeiro enfermeiroAssociado;
    private Paciente pacienteAssociado;
    private int qtd;
    private double preco;
    
    // Construtores
    public Vacina(){}; 
    
    public Vacina(String tipoVacina, String validade, boolean disponivel, int qtd, double preco) {
        this.tipoVacina = tipoVacina;
        this.validade = validade;
        this.disponivel = disponivel;
        this.qtd = qtd;
        this.preco = preco;
    }

    public Vacina(String tipoVacina, String validade, Enfermeiro enfermeiroAssociado, Paciente pacienteAssociado, int qtd, double preco) {
        this.tipoVacina = tipoVacina;
        this.validade = validade;
        this.enfermeiroAssociado = enfermeiroAssociado;
        this.pacienteAssociado = pacienteAssociado;
        this.qtd = qtd;
        this.preco = preco;
    }
    
    // métodos getters e setters
    public String getTipoVacina() {
        return tipoVacina;
    }

    public void setTipoVacina(String tipoVacina) {
        this.tipoVacina = tipoVacina;
    }

    public String getValidade(){
        return this.validade;
    }
    
    public void setValidade(String data){
        this.validade = data;
    }
    
    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public void setPreco(double preco){
        this.preco = preco;
    }
    
    public boolean aplicaVacina() {
        if (disponivel && qtd > 0) {
            qtd--;
            if (qtd == 0) {
                disponivel = false;
            }
            return true;
        }
        return false;
    }

    public Enfermeiro getEnfermeiroAssociado() {
        return enfermeiroAssociado;
    }

    public void setEnfermeiroAssociado(Enfermeiro enfermeiroAssociado) {
        this.enfermeiroAssociado = enfermeiroAssociado;
    }

    public Paciente pacienteAssociado() {
        return pacienteAssociado;
    }

    public void setPacienteASsociado(Paciente pacienteAssociado) {
        this.pacienteAssociado = pacienteAssociado;
    }
    
}