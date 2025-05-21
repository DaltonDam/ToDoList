package TodoList.Grupos;

import TodoList.Tarefas.TarefaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_grupos")
public class GruposModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private TarefaModel tarefa;

    // Um grupo pode ter várias tasks
    @OneToMany(mappedBy = "grupos")
    private List<TarefaModel> tarefas;


}
