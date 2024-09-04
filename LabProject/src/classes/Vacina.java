package classes;

public class Vacina {
    private String tipoVacina, validade, dose;
    private boolean disponivel, status;
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

    public Vacina(String tipoVacina, String validade, Enfermeiro enfermeiroAssociado, Paciente pacienteAssociado, String dose, double preco, boolean status) {
        this.tipoVacina = tipoVacina;
        this.validade = validade;
        this.enfermeiroAssociado = enfermeiroAssociado;
        this.pacienteAssociado = pacienteAssociado;
        this.dose = dose;
        this.preco = preco;
        this.status = status;
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
    
    public String getDose(){
        return this.dose;
    }
    
    public void setDose(String dose){
        this.dose = dose;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public void setPreco(double preco){
        this.preco = preco;
    }
    
    public boolean getStatus(){
        return this.status;
    }
    
    public void setStatus(boolean status){
        this.status = status;
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

    public Paciente getPacienteAssociado() {
        return pacienteAssociado;
    }

    public void setPacienteAssociado(Paciente pacienteAssociado) {
        this.pacienteAssociado = pacienteAssociado;
    }
    
    public String getCpfPacienteAssociado() {
        return this.pacienteAssociado.getCpf();
    }
    
    public String getCpfEnfermeiroAssociado() {
        return this.getEnfermeiroAssociado().getCpf();
    }
    
}