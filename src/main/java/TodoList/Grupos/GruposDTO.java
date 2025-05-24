package TodoList.Grupos;

import TodoList.Tarefas.TarefaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GruposDTO {

    private Long id;

    private String nome;

    private List<TarefaModel> tarefas;


}
