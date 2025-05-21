package TodoList.Tarefas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TarefaController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome";
    }


}
