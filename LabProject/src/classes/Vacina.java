package classes;

public class Vacina {
    private String tipoVacina;
    private boolean disponivel;
    private int qtd;

    public Vacina(String tipoVacina, boolean disponivel, int qtd) {
        this.tipoVacina = tipoVacina;
        this.disponivel = disponivel;
        this.qtd = qtd;
    }

    public String getTipoVacina() {
        return tipoVacina;
    }

    public void setTipoVacina(String tipoVacina) {
        this.tipoVacina = tipoVacina;
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
}