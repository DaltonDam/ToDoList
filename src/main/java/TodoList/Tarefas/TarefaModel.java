package TodoList.Tarefas;

import TodoList.Grupos.GruposModel;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "tb_tarefa")
public class TarefaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private String status;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;

    // uma task tem apenas um grupo
    @ManyToOne
    @JoinColumn(name = "grupos_id") // Foreing Key
    private GruposModel grupos;




}
