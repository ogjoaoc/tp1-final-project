package classes;

public abstract class Exame {
    private String dataRealizacao;
    private Paciente pacienteAssociado;
    private Enfermeiro enfermeiroAssociado;
    private double preco;
    
    
    // construtores
    public Exame(){};
    
    public Exame(double preco){
        this.preco = preco;
    }

    public Exame(String dataRealizacao, Paciente pacienteAssociado, Enfermeiro enfermeiroAssociado, double preco) {
        this.dataRealizacao = dataRealizacao;
        this.pacienteAssociado = pacienteAssociado;
        this.enfermeiroAssociado = enfermeiroAssociado;
        this.preco = preco;
    }

    public String getData() {
        return dataRealizacao;
    }

    public void setData(String data) {
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
    
    
}
