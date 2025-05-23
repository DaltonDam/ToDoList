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
    public TarefaModel criarTarefa(@RequestBody TarefaModel tarefa) {
        return tarefaService.criarTarefa(tarefa);
    }

    @GetMapping("/listar")
    public List<TarefaModel> listarTarefas() {
        return tarefaService.listarTarefas();
    }

    @GetMapping("/listar/{id}")
    public TarefaModel listarTarefasPorId(@PathVariable Long id) {
        return tarefaService.listarTarefasPorId(id);
    }

    @PutMapping("/alterarID")
    public String alterarTarefasPorId() {
        return "Alterar Tarefa por id";
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarTarefaPorId(@PathVariable Long id) {
        tarefaService.deletarTarefaPorId(id);
    }

}
