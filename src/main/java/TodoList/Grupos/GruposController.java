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
    public List<GruposModel> listarGrupos() {
        return gruposService.listarGrupos();
    }

    @GetMapping("/listar/{id}")
    public GruposModel listarGrupoPorId(@PathVariable Long id) {
        return gruposService.listarGrupoPorId(id);
    }

    @PostMapping("/criar")
    public GruposModel criarGrupo(GruposModel gruposModel) {
        return gruposService.criarGrupoPorId(gruposModel);
    }

    @PutMapping("/alterar/{id}")
    public GruposModel alterarGrupo(Long id, GruposModel grupoAtualizado) {
        return gruposService.atualizarGrupo(id, grupoAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarGrupo(@PathVariable Long id) {
        gruposService.deletarGrupoPorID(id);
    }

}
