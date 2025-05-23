package TodoList.Grupos;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GruposService {

    private GruposRepository gruposRepository;

    public GruposService(GruposRepository gruposRepository) {
        this.gruposRepository = gruposRepository;
    }

    public List<GruposModel> listarGrupos() {
        return gruposRepository.findAll();
    }

    public GruposModel listarGrupoPorId(Long id) {
        Optional<GruposModel> grupoPorId = gruposRepository.findById(id);
        return grupoPorId.orElse(null);
    }

    public GruposModel criarGrupoPorId(GruposModel gruposModel) {
        return gruposRepository.save(gruposModel);
    }

    public void deletarGrupoPorID(Long id) {
        gruposRepository.deleteById(id);
    }


}
