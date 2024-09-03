package classes;

public abstract class Exame {
    private String dataRealizacao;
    private Paciente pacienteAssociado;
    private Enfermeiro enfermeiroAssociado;
    private double preco;
    private boolean status;
    
    
    // construtores
    public Exame(){};
    
    public Exame(double preco){
        this.preco = preco;
    }

    public Exame(String dataRealizacao, Paciente pacienteAssociado, Enfermeiro enfermeiroAssociado, double preco, boolean status) {
        this.dataRealizacao = dataRealizacao;
        this.pacienteAssociado = pacienteAssociado;
        this.enfermeiroAssociado = enfermeiroAssociado;
        this.preco = preco;
        this.status = status;
    }

    public String getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(String data) {
        this.dataRealizacao = data;
    }

    public Paciente getPacienteAssociado() {
        return pacienteAssociado;
    }

    public void setPacienteAssociado(Paciente pacienteAssociado) {
        this.pacienteAssociado = pacienteAssociado;
    }

    public Enfermeiro getEnfermeiroAssociado() {
        return enfermeiroAssociado;
    }

    public void setEnfermeiroAssociado(Enfermeiro enfermeiroAssociado) {
        this.enfermeiroAssociado = enfermeiroAssociado;
    }

    public boolean getStatus(){
        return this.status;
    }
    
    public void setStatus(boolean status){
        this.status = status;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    } 
    
    public String getSubtipo() {
        if(this instanceof Sorologico) {
            return "Sorológico";
        } else {
            return "Hemograma";
        }
    }
    
    public String getTipoExame() {
        if(this instanceof Sorologico) {
            return ((Sorologico)this).getPatologia();
        } else {
            return ((Hemograma)this).getAlvo();
        }
    }
    
    public String getCpfPacienteAssociado() {
        return this.pacienteAssociado.getCpf();
    }
    
    public String getCpfEnfermeiroAssociado() {
        return this.getEnfermeiroAssociado().getCpf();
    }
    
}
