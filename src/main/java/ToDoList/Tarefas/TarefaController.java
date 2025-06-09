package ToDoList.Tarefas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarTarefa(@RequestBody TarefaDTO tarefa) {
        TarefaDTO novaTarefa = tarefaService.criarTarefa(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Tarefa criada: \n    id: " + novaTarefa.getId() + "\n    Nome: " + novaTarefa.getNome());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TarefaDTO>> listarTarefas() {
        List<TarefaDTO> tarefas = tarefaService.listarTarefas();
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarTarefasPorId(@PathVariable Long id) {
        TarefaDTO tarefa = tarefaService.listarTarefasPorId(id);
        if(tarefa != null) {
            return ResponseEntity.ok(tarefa);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Tarefa de id: " + id + " não encontrada.");

    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarTarefasPorId(@PathVariable Long id, @RequestBody TarefaDTO tarefaAtualizada) {
        TarefaDTO tarefa = tarefaService.listarTarefasPorId(id);
        if(tarefa != null) {
            return ResponseEntity.ok(tarefa);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Tarefa de id: " + id + " não encontrada.");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarTarefaPorId(@PathVariable Long id) {
        if(tarefaService.listarTarefasPorId(id) != null) {
            tarefaService.deletarTarefaPorId(id);
            return ResponseEntity.ok("Tarefa de id: " + id + " foi deletada.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Tarefa de id: " + id + " não encontrada.");
    }

}
