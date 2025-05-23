package TodoList.Tarefas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class TarefaController {

    @GetMapping("/boasvindas")
    public String boasvindas() {
        return "Mensagem de Teste";
    }

    @PostMapping("/criar")
    public String criarTarefa() {
        return "Tarefa criada";
    }

    @GetMapping("/todos")
    public String mostrarTodasAsTarefas() {
        return "Tarefas";
    }

    @GetMapping("/todosID")
    public String mostrarTarefasPorId() {
        return "Mostrar Tarefa por id";
    }

    @PutMapping("/alterarID")
    public String alterarTarefasPorId() {
        return "Alterar Tarefa por id";
    }

    @DeleteMapping("/deletarID")
    public String deletarTarefaPorId() {
        return "Tarefa deletada";
    }

}
