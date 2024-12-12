package com.joao.cadastro.core.services;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.entities.Curso;
import com.joao.cadastro.core.entities.DocumentoMatricula;
import com.joao.cadastro.exceptions.MatriculaFoundException;
import com.joao.cadastro.infra.RestMessage;
import  com.joao.cadastro.repository.AlunoRepository;
import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.usecases.CriarRegistroAlunoUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CriarResgistroAlunoService extends BaseService implements CriarRegistroAlunoUseCase {
    @Autowired
    AlunoRepository alunoRepository;

    @Transactional
    public ResponseEntity<RestMessage> criarRegistroAluno(AlunoDto alunoDto) {
        if(checarDocumentoMatricula(alunoDto.getNumeroDocumentoMatricula())){
            String nomeCurso = alunoDto.getNome_curso();
            Curso cursoRealizado = buscarCurso(nomeCurso);
            DocumentoMatricula documentoMatricula = criarRegistroMatricula(alunoDto.getNumeroDocumentoMatricula());

            Aluno aluno = new Aluno();
            aluno.setCurso(cursoRealizado);
            aluno.setNome(alunoDto.getNome_aluno());
            aluno.setDocumentoMatricula(documentoMatricula);

            alunoRepository.save(aluno);
            RestMessage message = new RestMessage("Aluno " + aluno.getNome() +" inserido");
            return ResponseEntity.status(HttpStatus.OK).body(message);
            //return "Aluno " + aluno.getNome() +" inserido";
        }else{
            //return "Numero de matricula ja sendo utilizado";
            throw new MatriculaFoundException();
        }
    }

    private DocumentoMatricula criarRegistroMatricula(int numeroMatricula){
        DocumentoMatricula documentoMatricula = new DocumentoMatricula();
        documentoMatricula.setNumeroDocumento(numeroMatricula);
        return documentoMatricula;
    }
}
