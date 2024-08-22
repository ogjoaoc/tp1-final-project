package interfaces;
import classes.Funcionario;
import java.time.LocalDateTime;

public interface UserLogado {
    
    Funcionario getFuncionario();
    LocalDateTime getDataHoraLogin();
    
}
