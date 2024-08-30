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
    private final ArrayList<Vacina> vacinas;
    private final ArrayList<Exame> exames;
    private final HashMap<String, String> filePathHash; 
    
    public BancoDeDados() {
        
        this.enfermeiros = new ArrayList<>();
        this.atendentes = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.vacinas = new ArrayList<>();
        this.exames = new ArrayList<>();
        this.filePathHash = new HashMap<>();
        
        filePathHash.put("enfermeiro", Paths.get(System.getProperty("user.dir"), "src", "database", "dadosEnfermeiro.csv").toString());
        filePathHash.put("atendente", Paths.get(System.getProperty("user.dir"), "src", "database", "dadosAtendente.csv").toString());
        filePathHash.put("paciente", Paths.get(System.getProperty("user.dir"), "src", "database", "dadosPaciente.csv").toString());
        filePathHash.put("vacina", Paths.get(System.getProperty("user.dir"),"src", "database","dadosVacinas.csv").toString());
        filePathHash.put("exame", Paths.get(System.getProperty("user.dir"),"src", "database","dadosExame.csv").toString());
        
    }
    
    public StringBuilder escreverDadosBase(Vacina vacina){
        StringBuilder sb = new StringBuilder(); sb.append(vacina.getTipoVacina()).append(","); sb.append(vacina.getValidade()).append(",");
        sb.append(String.valueOf(vacina.isDisponivel())).append(","); sb.append(vacina.getQtd()).append(","); sb.append(vacina.getPreco()).append(",");
        return sb;
    }
    
    public StringBuilder escreverDadosBase(Exame exame){
        StringBuilder sb = new StringBuilder();
        
        if(exame instanceof Sorologico){
            sb.append("Sorológico");sb.append(",");sb.append(((Sorologico) exame).getPatologia());sb.append(",");sb.append(((Sorologico) exame).getPreco());sb.append(",");
        } else if(exame instanceof Hemograma){
            sb.append("Hemograma");sb.append(",");sb.append(((Hemograma) exame).getAlvo());sb.append(",");sb.append(((Hemograma) exame).getPreco());sb.append(",");
        }

        return sb;
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
                switch (tipo) { 
                    case "exame" -> {
                        if(dados[0].equals("Sorológico")){
                            Sorologico exame = new Sorologico(dados[1], Double.parseDouble(dados[2]));
                             exames.add((Exame) exame);
                        } else if(dados[0].equals("Hemograma")){
                            Hemograma exame = new Hemograma(dados[1], Double.parseDouble(dados[2]));
                             exames.add((Exame) exame);
                        }
                    }
                    case "vacina" -> {
                        Vacina vac = new Vacina(dados[0], dados[1], Boolean.parseBoolean(dados[2]), Integer.parseInt(dados[3]), Double.parseDouble(dados[4]));
                        vacinas.add(vac);
                    }


                    case "enfermeiro" -> {
                        Enfermeiro enf = new Enfermeiro(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], Boolean.parseBoolean(dados[7]));
                        enfermeiros.add(enf);
                        funcionarios.add(enf);
                    }
                    case "atendente" -> {
                        Atendente atend = new Atendente(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], dados[7], Integer.parseInt(dados[8]), Integer.parseInt(dados[9]));
                        atendentes.add(atend);
                        funcionarios.add(atend);
                    }
                    case "paciente" -> //boolean preferencial = Boolean.parseBoolean(dados[3]);
                        pacientes.add(new Paciente(dados[2], dados[3], dados[4], dados[5], dados[6], dados[0], dados[1] /*preferencial,*/));
                        //Paciente(String nome, String cpf, String sexo, String dataNascimento, String email, String tipoSanguineo, String convenio /*boolean preferencial,*/)
                }
            }
        } catch (IOException e) {
        }
        
    }
    
    public void adicionarVacina(Vacina vacina) throws IOException{
        String filePath = filePathHash.get("vacina");
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            
                StringBuilder sb = escreverDadosBase(vacina);
                bw.write(sb.toString()); bw.newLine(); vacinas.add(vacina); // Adiciona a vacina ao arquivo e à lista em memória
                
        } catch (IOException e) {}
        
    }
    
    public void adicionarExame(Exame exame) throws IOException{
        String filePath = filePathHash.get("exame");
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            
                StringBuilder sb = escreverDadosBase(exame);
                bw.write(sb.toString()); bw.newLine(); exames.add(exame); // Adiciona o exame ao arquivo e à lista em memória
                
        } catch (IOException e) {}
        
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

    public void removerVacina(String tipoVacina){
       
        vacinas.removeIf(v -> v.getTipoVacina().equals(tipoVacina));
        reescreverArquivo("vacina");
        
    }
    
    public void removerExame(String nomeExame){
        exames.removeIf(exame -> {
            if (exame instanceof Sorologico) {
                return ((Sorologico) exame).getPatologia().equals(nomeExame);
            } else if (exame instanceof Hemograma) {
                return ((Hemograma) exame).getAlvo().equals(nomeExame);
            }
            return false;
        });
        reescreverArquivo("exame");   
    }
    
    public void removerPessoa(String cargo, String cpf) {
        
        if (cargo.equals("enfermeiro")) {
            enfermeiros.removeIf(e -> e.getCpf().equals(cpf));
            reescreverArquivo("enfermeiro");
        } 
        
        else if (cargo.equals("atendente")) {
            atendentes.removeIf(a -> a.getCpf().equals(cpf));
            reescreverArquivo("atendente");
        }
        
        else if (cargo.equals("paciente")) {
            pacientes.removeIf(p -> p.getCpf().equals(cpf));
            reescreverArquivo("paciente");
        }
        
        funcionarios.removeIf(f -> f.getCpf().equals(cpf));
        
    }
    
    public void atualizarVacina(Vacina vacina) {
        String tipoVacina = vacina.getTipoVacina();

        // Atualiza a vacina na lista em memória
        for (int i = 0; i < vacinas.size(); i++) {
            if (vacinas.get(i).getTipoVacina().equals(tipoVacina)) {
                vacinas.set(i, vacina);
                break; // Opcional: Se houver várias vacinas com o mesmo tipo, você pode remover isso.
            }
        }
        
        // Reescreve o arquivo atualizado
        reescreverArquivo("vacina");
    }
    
    public void atualizarExame(Exame exameAtualizado) {
        String tipoExame = exameAtualizado.getClass().getSimpleName(); // Obtém o nome da classe (Sorologico ou Hemograma)

        // Atualiza o exame na lista em memória
        for (int i = 0; i < exames.size(); i++) {
            Exame exameExistente = exames.get(i);

            // Verifica se é o mesmo tipo e se o identificador único bate (Patologia para Sorológico ou Alvo para Hemograma)
            if (exameExistente.getClass().getSimpleName().equals(tipoExame)) {
                if ((exameExistente instanceof Sorologico && ((Sorologico) exameExistente).getPatologia().equals(((Sorologico) exameAtualizado).getPatologia())) ||
                    (exameExistente instanceof Hemograma && ((Hemograma) exameExistente).getAlvo().equals(((Hemograma) exameAtualizado).getAlvo()))) {
                    exames.set(i, exameAtualizado);
                    break; // Para após encontrar e atualizar o exame
                }
            }
        }

        // Reescreve o arquivo atualizado
        reescreverArquivo("exame");
    }

    
    public void atualizarFuncionario(Funcionario func) {
        
        String cpf = func.getCpf();
        
        if(func instanceof Enfermeiro) {
            for (int i = 0; i < enfermeiros.size(); i++) {
                if (enfermeiros.get(i).getCpf().equals(cpf)) {
                    enfermeiros.set(i, (Enfermeiro)func);
                    break; 
                }
            }
            reescreverArquivo("enfermeiro");
            
        } else {
            for (int i = 0; i < atendentes.size(); i++) {
                if (atendentes.get(i).getCpf().equals(cpf)) {
                    atendentes.set(i, (Atendente)func);
                    break; 
                }
            }
            reescreverArquivo("atendente");
        }
    }
    
    public void atualizarPaciente(Paciente pacienteAntigo, Paciente pacienteNovo){
        for (int i = 0; i < pacientes.size(); i++) {
                if (pacientes.get(i).getCpf().equals(pacienteAntigo.getCpf())) {
                    pacientes.set(i, pacienteNovo);
                    break;
                }
        }
        reescreverArquivo("paciente");
    }  
    
    public Paciente encontrarPaciente(String cpf){
        for (int i = 0; i < pacientes.size(); i++) {
                if (pacientes.get(i).getCpf().equals(cpf)){
                    return pacientes.get(i);
                }
        }
        return null;
    }
    
    public void reescreverArquivo(String nomeArquivo){
        String filePath = filePathHash.get(nomeArquivo);
        
        if(nomeArquivo.equals("exame")){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                for (Exame e : exames) {
                    StringBuilder sb = escreverDadosBase(e);
                    bw.write(sb.toString());
                    bw.newLine();
                }
            } catch (IOException e) {}
        } 
        
        else if(nomeArquivo.equals("vacina")){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                for (Vacina v : vacinas) {
                    StringBuilder sb = escreverDadosBase(v);
                    bw.write(sb.toString());
                    bw.newLine();
                }
            } catch (IOException e) {}
        } 
        
        else if(nomeArquivo.equals("enfermeiro")){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                for (Enfermeiro e : enfermeiros) {
                    StringBuilder sb = escreverDadosBase(e);
                    sb.append(e.getSalario()).append(",");sb.append(String.valueOf(e.isDisponivel()));
                    bw.write(sb.toString());
                    bw.newLine();
                }
            } catch (IOException e) {}
        }
        
        else if(nomeArquivo.equals("atendente")){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                for (Atendente a : atendentes) {
                    StringBuilder sb = escreverDadosBase(a);
                    sb.append(a.getSalario()).append(",");sb.append(a.getTurno()).append(",");sb.append(a.getCredencial()).append(","); sb.append(String.valueOf(a.getQtdAgendamentos())).append(",");
                    bw.write(sb.toString());
                    bw.newLine();
                }
            } catch (IOException e) {}
        }
        
        else if(nomeArquivo.equals("paciente")){
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                for (Paciente p : pacientes) {
                    String paciente = p.getTipoSanguineo() + "," + p.getConvenio() + ","+ p.getNome()+","+p.getCpf()+","+p.getSexo()+","+p.getDataNascimento()+","+p.getEmail();
                    bw.write(paciente);
                    bw.newLine();
                }
            } catch (IOException e) {}
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
    
    public ArrayList<Vacina> getVacinas(){
        return vacinas;
    }
    
    public ArrayList<Exame> getExames(){
        return exames;
    }
    
}
