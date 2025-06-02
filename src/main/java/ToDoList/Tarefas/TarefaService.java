package ToDoList.Tarefas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final TarefaMapper tarefaMapper;

    public TarefaService(TarefaRepository tarefaRepository, TarefaMapper tarefaMapper) {
        this.tarefaRepository = tarefaRepository;
        this.tarefaMapper = tarefaMapper;
    }

    public List<TarefaDTO> listarTarefas() {
        List<TarefaModel> tarefas = tarefaRepository.findAll();
        return  tarefas.stream()
                .map(tarefaMapper::map)
                .collect(Collectors.toList());
    }

    public TarefaDTO listarTarefasPorId(Long id) {
        Optional<TarefaModel> tarefaPorID = tarefaRepository.findById(id);
        return tarefaPorID.map(tarefaMapper::map).orElse(null);
    }

    public TarefaDTO criarTarefa(TarefaDTO tarefaDTO) {
        TarefaModel tarefa = tarefaMapper.map(tarefaDTO);
        tarefa = tarefaRepository.save(tarefa);
        return tarefaMapper.map(tarefa);
    }

    public void deletarTarefaPorId(Long id) {
        tarefaRepository.deleteById(id);
    }

    public TarefaDTO atualizarTarefa(Long id, TarefaDTO tarefaDTO) {
        Optional<TarefaModel> tarefaExistente = tarefaRepository.findById(id);
        if (tarefaExistente.isPresent()) {
            TarefaModel tarefaAtualizada = tarefaMapper.map(tarefaDTO);
            tarefaAtualizada.setId(id);
            TarefaModel tarefaSalva = tarefaRepository.save(tarefaAtualizada);
            return tarefaMapper.map(tarefaSalva);
        }
        return null;

    }

}
