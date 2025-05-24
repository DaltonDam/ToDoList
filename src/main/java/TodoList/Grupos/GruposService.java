package TodoList.Grupos;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GruposService {

    private GruposRepository gruposRepository;
    private GruposMapper gruposMapper;

    public GruposService(GruposRepository gruposRepository, GruposMapper gruposMapper) {
        this.gruposRepository = gruposRepository;
        this.gruposMapper = gruposMapper;
    }

    public List<GruposDTO> listarGrupos() {
        List<GruposModel> grupos = gruposRepository.findAll();
        return grupos.stream()
                .map(gruposMapper::map)
                .collect(Collectors.toList());
    }

    public GruposDTO listarGrupoPorId(Long id) {
        Optional<GruposModel> grupoPorId = gruposRepository.findById(id);
        return grupoPorId.map(gruposMapper::map).orElse(null);
    }

    public GruposDTO criarGrupoPorId(GruposDTO gruposDTO) {
        GruposModel grupo = gruposMapper.map(gruposDTO);
        grupo = gruposRepository.save(grupo);
        return gruposMapper.map(grupo);
    }

    public void deletarGrupoPorID(Long id) {
        gruposRepository.deleteById(id);
    }

    public GruposDTO atualizarGrupo(Long id, GruposDTO gruposDTO) {
        Optional<GruposModel> grupoExistente = gruposRepository.findById(id);
        if (grupoExistente.isPresent()) {
            GruposModel grupoAtualizado = gruposMapper.map(gruposDTO);
            grupoAtualizado.setId(id);
            GruposModel grupoSalvo = gruposRepository.save(grupoAtualizado);
            return gruposMapper.map(grupoSalvo);
        }
        return null;
    }


}
