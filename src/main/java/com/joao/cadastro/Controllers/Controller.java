package com.joao.cadastro.Controllers;

import com.joao.cadastro.entidades.Aluno;
import com.joao.cadastro.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class Controller {
    @Autowired
    AlunoRepository alunoRepository;

    @GetMapping(value = "name")
    public String receiveGetRequest(@RequestParam String name){
        return "Salve " + name;
    }

    @PostMapping(value = "cadastro")
    public String receivePostRequest(@RequestBody Aluno aluno){
        alunoRepository.save(aluno);
        return "Recebido com sucesso    " + aluno.getName();
    }
}
