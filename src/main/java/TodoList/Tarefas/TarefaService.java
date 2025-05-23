package TodoList.Tarefas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<TarefaModel> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public TarefaModel listarTarefasPorId(Long id) {
        Optional<TarefaModel> tarefaPorID = tarefaRepository.findById(id);
        return tarefaPorID.orElse(null);
    }

    public TarefaModel criarTarefa(TarefaModel tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public void deletarTarefaPorId(Long id) {
        tarefaRepository.deleteById(id);
    }

    public TarefaModel atualizarTarefa(Long id, TarefaModel tarefaAtualizada) {
        if (tarefaRepository.existsById(id)) {
            tarefaAtualizada.setId(id);
            return tarefaRepository.save(tarefaAtualizada);
        }
        return null;
    }

}
