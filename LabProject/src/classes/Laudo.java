package classes;

public class Laudo {
    String dataCriacao;
    Paciente pacienteAssociado;
    Enfermeiro enfermeiroAssociado;
    String info;
    String nomeExame;

    public String getNomeExame() {
        return nomeExame;
    }

    public void setNomeExame(String nomeExame) {
        this.nomeExame = nomeExame;
    }

    public Laudo(String dataCriacao, Paciente pacienteAssociado, Enfermeiro enfermeiroAssociado, String info, String nomeExame) {
        this.dataCriacao = dataCriacao;
        this.pacienteAssociado = pacienteAssociado;
        this.enfermeiroAssociado = enfermeiroAssociado;
        this.info = info;
        this.nomeExame = nomeExame;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    
}
