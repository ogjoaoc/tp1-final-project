package classes;

public class Atendente {
    private String turno;
    private int credencial;
    private int qtdAgendamentos;

    public Atendente(String turno, int credencial, int qtdAgendamentos) {
        this.turno = turno;
        this.credencial = credencial;
        this.qtdAgendamentos = qtdAgendamentos;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getCredencial() {
        return credencial;
    }

    public void setCredencial(int credencial) {
        this.credencial = credencial;
    }

    public int getQtdAgendamentos() {
        return qtdAgendamentos;
    }

    public void setQtdAgendamentos(int qtdAgendamentos) {
        this.qtdAgendamentos = qtdAgendamentos;
    }
    
    
}
