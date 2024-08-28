package classes;

import java.util.Date;

public class Agendamento {
    private int id; 
    private String tipo; // vacina ou exame
    private Exame exameAssociado; // se for Exame, ref pro Exame, se não ref pra Vacina
    private Date dataCriado;
    private double valorTotal;
    
    // gerar csv no formato id, tipo, cpfPaciente, cpfEnfermeiro, dataCriado, dataAgendado, { info exame ou info vacina }
    
    public Agendamento () {
        
    }
    
    public Agendamento(int id, String tipo, Paciente pacienteAssociado, Enfermeiro enfermeiroAssociado, Exame tipoExame, Vacina tipoVacina, Date dataCriado, Date dataAgendado, double valorTotal) {
        this.id = id;
        this.tipo = tipo;
        this.exameAssociado = tipoExame;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public Exame getExameAssociado() {
        return exameAssociado;
    }

    public void setExameAssociado(Exame exameAssociado) {
        this.exameAssociado = exameAssociado;
    }

    public Date getDataCriado() {
        return dataCriado;
    }

    public void setDataCriado(Date dataCriado) {
        this.dataCriado = dataCriado;
    }


    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
    
}
