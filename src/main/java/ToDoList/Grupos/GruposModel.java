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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_grupos")
@ToString
public class GruposModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    // Um grupo pode ter várias tasks
    @OneToMany(mappedBy = "grupos")
    @JsonIgnore
    private List<TarefaModel> tarefas;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<TarefaModel> getTarefas() {
        return tarefas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTarefas(List<TarefaModel> tarefas) {
        this.tarefas = tarefas;
    }
}
