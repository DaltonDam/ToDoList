package TodoList.Grupos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GruposController {

    private GruposService gruposService;

    public GruposController(GruposService gruposService) {
        this.gruposService = gruposService;
    }

    @GetMapping("/listar")
    public List<GruposDTO> listarGrupos() {
        return gruposService.listarGrupos();
    }

    @GetMapping("/listar/{id}")
    public GruposDTO listarGrupoPorId(@PathVariable Long id) {
        return gruposService.listarGrupoPorId(id);
    }

    @PostMapping("/criar")
    public GruposDTO GruposDTO(GruposDTO grupos) {
        return gruposService.criarGrupoPorId(grupos);
    }

    @PutMapping("/alterar/{id}")
    public GruposDTO alterarGrupo(@PathVariable Long id,@RequestBody GruposDTO grupoAtualizado) {
        return gruposService.atualizarGrupo(id, grupoAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarGrupo(@PathVariable Long id) {
        gruposService.deletarGrupoPorID(id);
    }

}
