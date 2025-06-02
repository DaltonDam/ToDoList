package ToDoList.Tarefas;

import ToDoList.Grupos.GruposModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarefaDTO {

    private Long id;

    private String descricao;

    private StatusTarefa status;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataConclusao;

    private GruposModel grupos;

    private String nome;


}
