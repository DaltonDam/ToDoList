package TodoList.Tarefas;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping("/criar")
    public String criarTarefa() {
        return "Tarefa criada";
    }

    @GetMapping("/listar")
    public List<TarefaModel> listarTarefas() {
        return tarefaService.listarTarefas();
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
