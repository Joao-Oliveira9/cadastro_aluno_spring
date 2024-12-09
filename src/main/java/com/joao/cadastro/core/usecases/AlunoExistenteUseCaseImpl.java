package com.joao.cadastro.core.usecases;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.entities.DocumentoMatricula;
import com.joao.cadastro.repository.AlunoRepository;
import com.joao.cadastro.repository.DocumentoMatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AlunoExistenteUseCaseImpl {
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    DocumentoMatriculaRepository documentoMatriculaRepository;

    public boolean verificarAlunoDeletado(UUID id_aluno){
        if(alunoRepository.findById(id_aluno).isPresent()){
            Aluno aluno = alunoRepository.findById(id_aluno).get();
            if(aluno.getDeletedAt() == null)
            {
                return true;
            }
        }
        return false;
    }

    //eu preciso verificar se aquele numero de documento de matricula existe.
    public boolean checarDocumentoMatricula(int numeroDocumento){
        if(documentoMatriculaRepository.findBynumeroDocumento(numeroDocumento) == null){
            //nao existe aquele registro de documento pode ser inserido
            return true;
        }
        //existe aquele registro não devera haver inserção
        return false;
    }
}
