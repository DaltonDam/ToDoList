package TodoList.Grupos;

import TodoList.Tarefas.TarefaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
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
