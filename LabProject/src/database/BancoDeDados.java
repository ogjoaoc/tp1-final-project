package database;

import classes.Atendente;
import classes.Enfermeiro;
import classes.Paciente;
import classes.Pessoa;

import java.io.*;
import java.util.ArrayList;

public class BancoDeDados {
    private String filePathFuncionarios;
    private String filePathPacientes;
    private ArrayList<Pessoa> funcionarios;
    private ArrayList<Paciente> pacientes;

    public BancoDeDados(String filePathFuncionarios, String filePathPacientes) {
        this.filePathFuncionarios = filePathFuncionarios;
        this.filePathPacientes = filePathPacientes;
        this.funcionarios = new ArrayList<>();
        this.pacientes = new ArrayList<>();
    }

    public void lerArquivo(String tipo) {
        String filePath = tipo.equalsIgnoreCase("funcionario") ? filePathFuncionarios : filePathPacientes;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (tipo.equalsIgnoreCase("funcionario")) {
                    if (dados.length == 6) { // Enfermeiro
                        boolean disponivel = Boolean.parseBoolean(dados[0]);
                        String nome = dados[1];
                        String cpf = dados[2];
                        String sexo = dados[3];
                        String dataNascimento = dados[4];
                        String email = dados[5];
                        funcionarios.add(new Enfermeiro(disponivel, nome, cpf, sexo, dataNascimento, email));
                    } else if (dados.length == 8) { // Atendente
                        String turno = dados[0];
                        int credencial = Integer.parseInt(dados[1]);
                        int qtdAgendamentos = Integer.parseInt(dados[2]);
                        String nome = dados[3];
                        String cpf = dados[4];
                        String sexo = dados[5];
                        String dataNascimento = dados[6];
                        String email = dados[7];
                        funcionarios.add(new Atendente(turno, credencial, qtdAgendamentos, nome, cpf, sexo, dataNascimento, email));
                    }
                } else if (tipo.equalsIgnoreCase("paciente")) {
                    if (dados.length == 9) { // Paciente
                        String tipoSanguineo = dados[0];
                        String convenio = dados[1];
                        int idade = Integer.parseInt(dados[2]);
                        boolean preferencial = Boolean.parseBoolean(dados[3]);
                        String nome = dados[4];
                        String cpf = dados[5];
                        String sexo = dados[6];
                        String dataNascimento = dados[7];
                        String email = dados[8];
                        pacientes.add(new Paciente(tipoSanguineo, convenio, idade, preferencial, nome, cpf, sexo, dataNascimento, email));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void escreverArquivo(String tipo) {
        String filePath = tipo.equalsIgnoreCase("funcionario") ? filePathFuncionarios : filePathPacientes;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            if (tipo.equalsIgnoreCase("funcionario")) {
                for (Pessoa pessoa : funcionarios) {
                    StringBuilder sb = new StringBuilder();
                    if (pessoa instanceof Enfermeiro) {
                        Enfermeiro enfermeiro = (Enfermeiro) pessoa;
                        sb.append(enfermeiro.isDisponivel()).append(",");
                        sb.append(enfermeiro.getNome()).append(",");
                        sb.append(enfermeiro.getCpf()).append(",");
                        sb.append(enfermeiro.getSexo()).append(",");
                        sb.append(enfermeiro.getDataNascimento()).append(",");
                        sb.append(enfermeiro.getEmail());
                    } else if (pessoa instanceof Atendente) {
                        Atendente atendente = (Atendente) pessoa;
                        sb.append(atendente.getTurno()).append(",");
                        sb.append(atendente.getCredencial()).append(",");
                        sb.append(atendente.getQtdAgendamentos()).append(",");
                        sb.append(atendente.getNome()).append(",");
                        sb.append(atendente.getCpf()).append(",");
                        sb.append(atendente.getSexo()).append(",");
                        sb.append(atendente.getDataNascimento()).append(",");
                        sb.append(atendente.getEmail());
                    }
                    bw.write(sb.toString());
                    bw.newLine();
                }
            } else if (tipo.equalsIgnoreCase("paciente")) {
                for (Paciente paciente : pacientes) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(paciente.getTipoSanguineo()).append(",");
                    sb.append(paciente.getConvenio()).append(",");
                    sb.append(paciente.getIdade()).append(",");
                    sb.append(paciente.isPreferencial()).append(",");
                    sb.append(paciente.getNome()).append(",");
                    sb.append(paciente.getCpf()).append(",");
                    sb.append(paciente.getSexo()).append(",");
                    sb.append(paciente.getDataNascimento()).append(",");
                    sb.append(paciente.getEmail());
                    bw.write(sb.toString());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionarPessoa(Pessoa pessoa) {
        if (pessoa instanceof Enfermeiro || pessoa instanceof Atendente) {
            funcionarios.add(pessoa);
        } else if (pessoa instanceof Paciente) {
            pacientes.add((Paciente) pessoa);
        }
    }

    public void removerPessoa(Pessoa pessoa, String tipo) {
       if (pessoa instanceof Enfermeiro || pessoa instanceof Atendente) {
            funcionarios.remove(pessoa);
        } else if (pessoa instanceof Paciente) {
            pacientes.remove((Paciente) pessoa);
        }
    }

    public ArrayList<Pessoa> getFuncionarios() {
        return funcionarios;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
}
