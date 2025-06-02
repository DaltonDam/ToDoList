package ToDoList.Grupos;

import ToDoList.Tarefas.TarefaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_grupos")
@ToString
public class GruposModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Um grupo pode ter várias tasks
    @OneToMany(mappedBy = "grupos")
    @JsonIgnore
    private List<TarefaModel> tarefas;


}
