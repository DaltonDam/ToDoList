package ToDoList.Tarefas;

import org.springframework.stereotype.Component;

@Component
public class TarefaMapper {

    public TarefaModel map(TarefaDTO tarefaDTO) {
        TarefaModel tarefaModel = new TarefaModel();
        tarefaModel.setId(tarefaDTO.getId());
        tarefaModel.setDescricao(tarefaDTO.getDescricao());
        tarefaModel.setStatus(tarefaDTO.getStatus());
        tarefaModel.setDataCriacao(tarefaDTO.getDataCriacao());
        tarefaModel.setDataConclusao(tarefaDTO.getDataConclusao());
        tarefaModel.setGrupos(tarefaDTO.getGrupos());
        tarefaModel.setNome(tarefaDTO.getNome());

        return tarefaModel;
    }

    public TarefaDTO map(TarefaModel tarefaModel) {
        TarefaDTO tarefaDTO = new TarefaDTO();
        tarefaDTO.setId(tarefaModel.getId());
        tarefaDTO.setDescricao(tarefaModel.getDescricao());
        tarefaDTO.setStatus(tarefaModel.getStatus());
        tarefaDTO.setDataCriacao(tarefaModel.getDataCriacao());
        tarefaDTO.setDataConclusao(tarefaModel.getDataConclusao());
        tarefaDTO.setGrupos(tarefaModel.getGrupos());
        tarefaDTO.setNome(tarefaModel.getNome());

        return tarefaDTO;
    }
}
