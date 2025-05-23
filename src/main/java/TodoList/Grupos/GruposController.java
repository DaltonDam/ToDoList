package TodoList.Grupos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("grupos")
public class GruposController {

    @GetMapping("/listar")
    public String listarGrupo() {
        return "Grupos listados com sucesso";
    }

    @PostMapping("/criar")
    public String criarGrupo() {
        return "Grupo criado";
    }

    @PutMapping("/alterar")
    public String alterarGrupo() {
        return "Grupo alterado";
    }

    @DeleteMapping("/deletar")
    public String deletarGrupo() {
        return "Grupo deletado";
    }

}
