package TodoList.Tarefas;

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
    public TarefaDTO criarTarefa(@RequestBody TarefaDTO tarefa) {
        return tarefaService.criarTarefa(tarefa);
    }

    @GetMapping("/listar")
    public List<TarefaDTO> listarTarefas() {
        return tarefaService.listarTarefas();
    }

    @GetMapping("/listar/{id}")
    public TarefaDTO listarTarefasPorId(@PathVariable Long id) {
        return tarefaService.listarTarefasPorId(id);
    }

    @PutMapping("/alterar/{id}")
    public TarefaDTO alterarTarefasPorId(@PathVariable Long id, @RequestBody TarefaDTO tarefaAtualizada) {
        return tarefaService.atualizarTarefa(id, tarefaAtualizada);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarTarefaPorId(@PathVariable Long id) {
        tarefaService.deletarTarefaPorId(id);
    }

}
