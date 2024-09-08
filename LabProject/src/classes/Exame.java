// Classe: Exame
// A classe é abstrata, e pode ser instanciada de forma polimórfica.
// Um exame é instanciado em diferentes momentos, tanto no cadastro de novos tipos de Exames, quanto
// durante o agendamento por parte de um usuário do tipo Atendente.
// Há métodos auxiliares para identificação de subclasses.

package classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Exame {
    
//     Atributos de um Exame:
//     - dataRealizacao: A data em que o exame deverá ser realizado. Exemplo: "2024-10-15" (representando 15 de outubro de 2024).
//     - pacienteAssociado: O paciente associado ao exame. Exemplo: um objeto do tipo Paciente que representa o paciente que vai fazer o exame.
//     - enfermeiroAssociado: O enfermeiro associado ao exame. Exemplo: um objeto do tipo Enfermeiro que é responsável pelo exame.
//     - preco: O preço do exame. Exemplo: 150.00 (representando o custo de 150 reais do exame).
//     - status: Indica se o exame foi concluído (true) ou não (false). Exemplo: true (o exame foi concluído) ou false (o exame não foi concluído).
    
    
    private String dataRealizacao;
    private Paciente pacienteAssociado;
    private Enfermeiro enfermeiroAssociado;
    private double preco;
    private boolean status;
    
 //     Construtores
    
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
    
//    Método auxiliar para saber qual o valor do desconto oferecido pelos diferentes tipos de Convênios cadastrados.
    
    public double precoConvenio(String convenio){
        List<String> examesCobertos;
        examesCobertos = new ArrayList<>();
        
        switch (convenio) {
            case "Sem Convênio" -> {
                return preco;
            }
            case "Unimed" -> {
                examesCobertos.addAll(Arrays.asList("Dengue", "Zika Vírus", "Covid-19", "Colesterol"));

                if (examesCobertos.contains(getTipoExame())) {
                    return preco * 0.9; // 10% de desconto
                } else {
                    return preco;
                }
            }
            case "Amil" -> {
                examesCobertos.addAll(Arrays.asList("Zika Vírus", "Covid-19", "Sífilis", "Ácido Úrico"));

                if (examesCobertos.contains(getTipoExame())) {
                    return preco * 0.85; // 15% de desconto
                } else {
                    return preco;
                }
            }
            case "Bradesco Saúde" -> {
                examesCobertos.addAll(Arrays.asList("Dengue", "Sífilis", "Rubéola", "Toxoplasmose"));

                if (examesCobertos.contains(getTipoExame())) {
                    return preco * 0.75; // 25% de desconto
                } else {
                    return preco;
                }
            }
            case "Porto Seguro" -> {
                examesCobertos.addAll(Arrays.asList("Dengue", "Covid-19", "Rubéola", "Glicemia"));

                if (examesCobertos.contains(getTipoExame())) {
                    return preco * 0.7; // 30% de desconto
                } else {
                    return preco;
                }
            }
            default -> {
                return preco;
            }
        }
    }

//    Getter e setter
    
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
