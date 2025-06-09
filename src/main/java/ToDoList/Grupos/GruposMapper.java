package ToDoList.Grupos;

import org.springframework.stereotype.Component;

@Component
public class GruposMapper {

    public GruposModel map(GruposDTO gruposDTO) {
        GruposModel gruposModel = new GruposModel();
        gruposModel.setId(gruposDTO.getId());
        gruposModel.setNome(gruposDTO.getNome());
        gruposModel.setTarefas(gruposDTO.getTarefas());

        return gruposModel;

    }

    public GruposDTO map(GruposModel gruposModel) {
        GruposDTO gruposDTO = new GruposDTO();
        gruposDTO.setId(gruposModel.getId());
        gruposDTO.setNome(gruposModel.getNome());
        gruposDTO.setTarefas(gruposModel.getTarefas());

        return gruposDTO;

    }


}
