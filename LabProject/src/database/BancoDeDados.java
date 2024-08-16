package database;

import classes.*;

import java.io.*;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.util.HashMap;

public class BancoDeDados {
    
    private final ArrayList<Enfermeiro> enfermeiros;
    private final ArrayList<Atendente> atendentes;
    private final ArrayList<Paciente> pacientes;
    private final ArrayList<Funcionario> funcionarios;
    private final HashMap<String, String> filePathHash; 

    public BancoDeDados() {
        
        this.enfermeiros = new ArrayList<>();
        this.atendentes = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.filePathHash = new HashMap<>();
        
        filePathHash.put("enfermeiro", Paths.get(System.getProperty("user.dir"), "src", "database", "dadosEnfermeiro.csv").toString());
        filePathHash.put("atendente", Paths.get(System.getProperty("user.dir"), "src", "database", "dadosAtendente.csv").toString());
        filePathHash.put("paciente", Paths.get(System.getProperty("user.dir"), "src", "database", "dadosPaciente.csv").toString());
    
    }

    public StringBuilder escreverDadosBase(Pessoa pessoa) {
        
        StringBuilder sb = new StringBuilder(); sb.append(pessoa.getNome()).append(","); sb.append(pessoa.getCpf()).append(","); 
        sb.append(pessoa.getSexo()).append(","); sb.append(pessoa.getDataNascimento()).append(","); sb.append(pessoa.getEmail()).append(",");
        
        if(pessoa instanceof Enfermeiro) {
            sb.append(((Enfermeiro) pessoa).getSenha()).append(",");
        } else if(pessoa instanceof Atendente) {
            sb.append(((Atendente) pessoa).getSenha()).append(",");
        }
        
        return sb;
        
    }
    
    public void ApagarLinha() {
        // Implementar em breve...
    }
    
    public void lerArquivo(String tipo) {
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePathHash.get(tipo)))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                switch (dados.length) {
                    case 8 -> {
                        Enfermeiro enf = new Enfermeiro(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], Boolean.parseBoolean(dados[7]));
                        enfermeiros.add(enf);
                        funcionarios.add(enf);
                    }
                    case 10 -> {
                        Atendente atend = new Atendente(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], dados[7], Integer.parseInt(dados[8]), Integer.parseInt(dados[9]));
                        atendentes.add(atend);
                        funcionarios.add(atend);
                    }
                    case 9 -> //boolean preferencial = Boolean.parseBoolean(dados[3]);
                        pacientes.add(new Paciente(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6] /*preferencial,*/));
                }
            }
        } catch (IOException e) {
        }
        
    }

    public void adicionarPessoa(Pessoa pessoa) {
        
        String filePath;
        
        if (pessoa instanceof Enfermeiro) {
            
            filePath = filePathHash.get("enfermeiro");
            Enfermeiro enfermeiro = (Enfermeiro) pessoa;
            
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            
                StringBuilder sb = escreverDadosBase(pessoa);
                sb.append(enfermeiro.getSalario()).append(","); sb.append(String.valueOf(enfermeiro.isDisponivel())); 
                bw.write(sb.toString()); bw.newLine();
            
            } catch (IOException e) {
            }
            
        } else if (pessoa instanceof Atendente) {
            
            filePath = filePathHash.get("atendente");
            Atendente atendente = (Atendente) pessoa;
            
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
                
                StringBuilder sb = escreverDadosBase(pessoa);
                sb.append(atendente.getSalario()).append(","); sb.append(atendente.getTurno()).append(",");
                sb.append(atendente.getCredencial()).append(","); sb.append(String.valueOf(atendente.getQtdAgendamentos()));
                bw.write(sb.toString()); bw.newLine();
            
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (pessoa instanceof Paciente) {
            
            filePath = filePathHash.get("paciente");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
                
                Paciente paciente = (Paciente) pessoa;
                StringBuilder sb = escreverDadosBase(pessoa);
                sb.append(paciente.getTipoSanguineo()).append(","); sb.append(paciente.getConvenio());
                
                bw.write(sb.toString()); bw.newLine();
            } catch (IOException e) {
            }
        }
    }

    public void removerPessoa(Pessoa pessoa) {
        
        if (pessoa instanceof Enfermeiro) {
            enfermeiros.remove((Enfermeiro)pessoa);
        } else if (pessoa instanceof Atendente) {
            atendentes.remove((Atendente)pessoa);
        } else if (pessoa instanceof Paciente) {
            pacientes.remove((Paciente)pessoa);
        }
        
    }

    public ArrayList<Enfermeiro> getEnfermeiros() {
        return enfermeiros;
    }

    public ArrayList<Atendente> getAtendentes() {
        return atendentes;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
    
    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    
}
