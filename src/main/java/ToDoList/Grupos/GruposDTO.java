package ToDoList.Grupos;

import ToDoList.Tarefas.TarefaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class GruposDTO {

    private Long id;

    private String nome;

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
