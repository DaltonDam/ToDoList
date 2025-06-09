package ToDoList.Grupos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GruposController {

    private final GruposService gruposService;

    public GruposController(GruposService gruposService) {
        this.gruposService = gruposService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<GruposDTO>> listarGrupos() {
        List<GruposDTO> grupos = gruposService.listarGrupos();
        return ResponseEntity.ok(grupos);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarGrupoPorId(@PathVariable Long id) {
        GruposDTO grupo = gruposService.listarGrupoPorId(id);
        if(grupo != null) {
            return ResponseEntity.ok(grupo);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Grupo de id: " + id + " não encontrado.");
    }

    @PostMapping("/criar")
    public ResponseEntity<String> GruposDTO(@RequestBody GruposDTO grupos) {
        GruposDTO novoGrupo = gruposService.criarGrupoPorId(grupos);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Grupo criado: \n    id: " + novoGrupo.getId() + "\n    Nome: " + novoGrupo.getNome());
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarGrupo(@PathVariable Long id,@RequestBody GruposDTO grupoAtualizado) {
        GruposDTO grupo = gruposService.atualizarGrupo(id, grupoAtualizado);
        if(grupo != null) {
            return ResponseEntity.ok(grupo);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Grupo de id: " + id + " não encontrado.");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarGrupo(@PathVariable Long id) {
        if(gruposService.listarGrupoPorId(id) != null) {
            gruposService.deletarGrupoPorID(id);
            return ResponseEntity.ok("Grupo de id: " + id + " foi deletado.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Grupo de id: " + id + " não encontrado.");
    }

}
