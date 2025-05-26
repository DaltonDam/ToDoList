package TodoList.Tarefas;

import TodoList.Grupos.GruposRepository;
import TodoList.Grupos.GruposService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/tarefas/ui")
public class TarefaControllerUi {

    private final TarefaService tarefaService;
    private final GruposService gruposService;

    public TarefaControllerUi(TarefaService tarefaService, GruposService gruposService) {
        this.tarefaService = tarefaService;
        this.gruposService = gruposService;
    }

    //Model import springframework.ui
    @GetMapping("/listar")
    public String listarTarefas(Model model) {
        List<TarefaDTO> tarefas = tarefaService.listarTarefas();
        model.addAttribute("tarefas", tarefas);
        return "ListarTarefas"; //Retornar o nome da pagina que renderiza
    }

    @GetMapping("/deletar/{id}")
    public String deletarTarefaPorId(@PathVariable Long id) {
        tarefaService.deletarTarefaPorId(id);
        return "redirect:/tarefas/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String listarTarefasPorId(@PathVariable Long id, Model model) {
        TarefaDTO tarefa = tarefaService.listarTarefasPorId(id);
        if(tarefa != null) {
            model.addAttribute("tarefa", tarefa);
            return "TarefaDetalhes";
        } else {
            model.addAttribute("mensagem", "Tarefa não encontrada.");
            return "ListarTarefas";
        }
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarTarefa(Model model) {
        model.addAttribute("tarefa", new TarefaDTO());
        model.addAttribute("grupos", gruposService.listarGrupos());
        return "AdicionarTarefa";
    }

    @PostMapping("/salvar")
    public String salvarTarefa(@ModelAttribute TarefaDTO tarefa, RedirectAttributes redirectAttributes) {
        tarefaService.criarTarefa(tarefa);
        redirectAttributes.addFlashAttribute("mensagem", "Tarefa salva");
        return "redirect:/tarefas/ui/listar";
    }

    @GetMapping("/alterar/{id}")
    public String mostrarFormularioAlterarTarefa(@PathVariable Long id, Model model) {
        TarefaDTO tarefa = tarefaService.listarTarefasPorId(id);
        if (tarefa != null) {
            model.addAttribute("tarefa", tarefa);
            model.addAttribute("grupos", gruposService.listarGrupos()); // Lista os grupos para o select
            return "AlterarTarefa";
        } else {
            model.addAttribute("mensagem", "Tarefa não encontrada.");
            return "redirect:/tarefas/ui/listar";
        }
    }

    @PostMapping("/alterar")
    public String alterarTarefa(@ModelAttribute TarefaDTO tarefaDTO, RedirectAttributes redirectAttributes) {
        tarefaService.atualizarTarefa(tarefaDTO.getId(), tarefaDTO);
        redirectAttributes.addFlashAttribute("mensagem", "Tarefa alterada com sucesso!");
        return "redirect:/tarefas/ui/listar";
    }



}
