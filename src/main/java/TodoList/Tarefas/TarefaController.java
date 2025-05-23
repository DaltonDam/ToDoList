package TodoList.Tarefas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @PostMapping("/criar")
    public String criarTarefa() {
        return "Tarefa criada";
    }

    @GetMapping("/listar")
    public String mostrarTodasAsTarefas() {
        return "Tarefas";
    }

    @GetMapping("/listarID")
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
