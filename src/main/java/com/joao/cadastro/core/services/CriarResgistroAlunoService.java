package com.joao.cadastro.core.services;

import com.joao.cadastro.core.Dtos.AlunoDto;
import com.joao.cadastro.core.entities.Curso;
import com.joao.cadastro.core.entities.DocumentoMatricula;
import  com.joao.cadastro.repository.AlunoRepository;
import com.joao.cadastro.core.entities.Aluno;
import com.joao.cadastro.core.usecases.CriarRegistroAlunoUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CriarResgistroAlunoService extends BaseService implements CriarRegistroAlunoUseCase {
    @Autowired
    AlunoRepository alunoRepository;

    @Transactional
    public String criarRegistroAluno(AlunoDto alunoDto) {
        if(checarDocumentoMatricula(alunoDto.getNumeroDocumentoMatricula())){
            String nomeCurso = alunoDto.getNome_curso();
            Curso cursoRealizado = buscarCurso(nomeCurso);
            DocumentoMatricula documentoMatricula = criarRegistroMatricula(alunoDto.getNumeroDocumentoMatricula());

            Aluno aluno = new Aluno();
            aluno.setCurso(cursoRealizado);
            aluno.setNome(alunoDto.getNome_aluno());
            aluno.setDocumentoMatricula(documentoMatricula);

            alunoRepository.save(aluno);
            return "Aluno " + aluno.getNome() +" inserido";
        }
        return "Numero de matricula ja sendo utilizado";

    }

    private DocumentoMatricula criarRegistroMatricula(int numeroMatricula){
        DocumentoMatricula documentoMatricula = new DocumentoMatricula();
        documentoMatricula.setNumeroDocumento(numeroMatricula);
        return documentoMatricula;
    }
}
